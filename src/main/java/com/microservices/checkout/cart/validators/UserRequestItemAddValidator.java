package com.microservices.checkout.cart.validators;

import com.microservices.checkout.cart.CartException;
import com.microservices.checkout.cart.CartProto;
import io.vavr.control.Either;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

public class UserRequestItemAddValidator
        implements ItemAddValidator {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public CompletionStage<Either<CartException, Void>> validate(CartProto.Cart cart, CartProto.AddItemRequest itemRequest) {
        if (itemRequest.getItem().getPrice() <= 0.0) {
            logger.error("Item Price found to be empty in request {} for cart id {}", itemRequest.toString(), cart.getId());
            return CompletableFuture.completedFuture(Either.left(new CartException.InvalidUserRequest("Item price", "Item price cannot be less than or equal to 0")));
        }
        return CompletableFuture.completedFuture(Either.right(null));
    }
}
