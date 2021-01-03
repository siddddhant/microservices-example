package com.microservices.checkout.cart.validators;

import com.microservices.checkout.cart.CartException;
import com.microservices.checkout.cart.CartProto;
import io.vavr.control.Either;

import java.util.concurrent.CompletionStage;

public class CartValidators {

    private final UserRequestItemAddValidator userRequestItemAddValidator;

    public CartValidators(UserRequestItemAddValidator userRequestItemAddValidator) {
        this.userRequestItemAddValidator = userRequestItemAddValidator;
    }

    public CompletionStage<Either<CartException, Void>> validate(CartProto.Cart cart, CartProto.AddItemRequest addItemRequest) {
        return userRequestItemAddValidator.validate(cart, addItemRequest);
    }

}
