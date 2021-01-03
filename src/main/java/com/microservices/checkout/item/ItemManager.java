package com.microservices.checkout.item;

import com.microservices.checkout.cart.CartProto;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class ItemManager {

    /**
     * Given an item and its quantity, validate if it is available.
     *
     * @param item     Item to be validated
     * @param quantity Quantity of the item
     * @return Future of true if item is serviceable
     *  Future if false if item is unserviceable
     *  Failed Future in case of an error
     */
    public Future<Boolean> validateItem(CartProto.Item item, Long quantity) {
        return CompletableFuture.completedFuture(true);
    }
}
