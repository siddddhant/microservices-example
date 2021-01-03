package com.microservices.checkout.cart.validators;

import com.microservices.checkout.cart.CartException;
import com.microservices.checkout.cart.CartProto;
import io.vavr.control.Either;

import java.util.concurrent.CompletionStage;

public interface ItemAddValidator {

    /**
     * Example of Open-Closed principle
     * Validator for adding item to the cart. Return true if the validation pass. Return false in case validation fails.
     *
     * @param cart        Cart for the user in which item has to be added
     * @param itemRequest AddItem request object
     * @return true in case item can be added to the cart
     * false in case item cannot be added to the cart
     */
    CompletionStage<Either<CartException, Void>> validate(CartProto.Cart cart, CartProto.AddItemRequest itemRequest);
}

