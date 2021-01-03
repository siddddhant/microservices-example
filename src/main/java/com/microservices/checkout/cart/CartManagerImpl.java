package com.microservices.checkout.cart;

import com.microservices.checkout.cart.validators.CartValidators;
import com.microservices.checkout.utils.ApplicationMetric;
import com.microservices.checkout.utils.Timed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class CartManagerImpl implements CartManager {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final CartStore store;
    private final CartValidators cartValidators;
    private final CartMetric cartMetric;

    /*
        Initializing CartManager.
        Example of Dependency Inversion Principle(Injecting Cart store)
     */
    public CartManagerImpl(CartStore store, CartValidators cartValidators, CartMetric cartMetric) {
        this.store = store;
        this.cartValidators = cartValidators;
        this.cartMetric = cartMetric;
    }


    @Override
    @Timed(name = "Add-Item")
    public Future<CartProto.ProcessItemResponse> addItem(CartProto.AddItemRequest request) {
        log.debug("Processing AddItem for request: {}", request.toString());

        if (request.getCartId().isEmpty()) {
            log.error("CartId missing in the request {}", request.toString());
            CartException.InvalidUserRequest err = new CartException.InvalidUserRequest("cartId", "Empty cart id");
            return CompletableFuture.completedFuture(CartProto.ProcessItemResponse.newBuilder()
                    .setSuccess(false)
                    .setErrorCode(err.statusCode())
                    .setErrorMsg(err.getMessage())
                    .build());
        }

        store.findCart(request.getCartId())
                .map(cart -> cartValidators.validate(cart, request));

        /// Continue

        log.debug("Item {} succesfully added to cart {}", request.getItem().getId(), "");
        cartMetric.itemAdded();
        return null;
    }

}
