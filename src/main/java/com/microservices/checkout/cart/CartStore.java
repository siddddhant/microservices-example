package com.microservices.checkout.cart;

import java.util.List;
import java.util.Optional;

public interface CartStore {

    /**
     * @param user
     * @return
     */
    CartProto.Cart createCart(CartProto.User user);

    /**
     * @param cart
     * @return
     */
    CartProto.Cart updateCart(CartProto.Cart cart);

    /**
     * @param id
     * @return
     */
    Optional<CartProto.Cart> findCart(String id);

    /**
     * @param userId
     * @return
     */
    List<CartProto.Cart> findCartByUserId(String userId);


}
