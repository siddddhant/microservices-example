package com.microservices.cart;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.Future;

public interface CartStore {

    /**
     * @param user
     * @return
     */
    Future<CartProto.Cart> createCart(CartProto.User user);

    /**
     * @param cart
     * @return
     */
    Future<CartProto.Cart> updateCart(CartProto.Cart cart);

    /**
     *
     * @param id
     * @return
     */
    Future<Optional<CartProto.Cart>> findCart(String id);

    /**
     *
     * @param userId
     * @return
     */
    Future<List<CartProto.Cart>> findCartByUserId(String userId);


}
