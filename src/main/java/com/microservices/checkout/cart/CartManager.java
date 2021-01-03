package com.microservices.checkout.cart;

import java.util.concurrent.Future;

public interface CartManager {

    /**
     * Given an AddItemRequest, add item to the user cart and return an item processed response.
     * In case item is not available or request was not processed for any other valid reason, existing cart will
     * be returned
     * @param request AddItemRequest
     * @return Future of ProcessItemResponse
     *  Failed future in case of unknown exceptions
     */
    Future<CartProto.ProcessItemResponse> addItem(CartProto.AddItemRequest request);


}
