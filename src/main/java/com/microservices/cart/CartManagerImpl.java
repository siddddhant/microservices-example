package com.microservices.cart;

public class CartManagerImpl implements CartManager {

    private final CartStore store;

    /*
        Initializing CartManager.
        Example of Dependency Inversion Principle(Injecting Cart store)
     */
    public CartManagerImpl(CartStore store){
        this.store = store;
    }

    @Override
    public CartProto.ProcessItemResponse addItem(CartProto.AddItemRequest request) {
        return null;
    }
}
