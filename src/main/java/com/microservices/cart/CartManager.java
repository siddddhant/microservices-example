package com.microservices.cart;

public interface CartManager {

    /**
     *
     * @param request
     * @return
     */
    CartProto.ProcessItemResponse addItem(CartProto.AddItemRequest request);


}
