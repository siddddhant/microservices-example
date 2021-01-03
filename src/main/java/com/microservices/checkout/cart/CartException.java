package com.microservices.checkout.cart;

public abstract class CartException extends Throwable {

    public abstract String statusCode();

    public static class ItemNotAvailable extends CartException {
        private final CartProto.Item item;

        public ItemNotAvailable(CartProto.Item item) {
            this.item = item;
        }

        @Override
        public String getMessage() {
            return String.format("Item %s is not available", item.getName());
        }


        @Override
        public String statusCode() {
            return "ITEM_NOT_AVAILABLE";
        }
    }

    public static class InvalidUserRequest extends CartException {
        private final String field;
        private final String msg;

        public InvalidUserRequest(String field, String msg) {
            this.field = field;
            this.msg = msg;

        }

        @Override
        public String getMessage() {
            return String.format("Field %s is invalid. Reason: %s", field, msg);
        }

        @Override
        public String statusCode() {
            return "INVALID_REQUEST";
        }
    }

}
