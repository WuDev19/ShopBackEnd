package com.example.ShopBackEnd.dto.request;

public class CartAndCartItemRequest {
    private CartRequest cartRequest;
    private CartItemRequest cartItemRequest;

    public CartAndCartItemRequest() {
    }

    public CartAndCartItemRequest(CartRequest cartRequest, CartItemRequest cartItemRequest) {
        this.cartRequest = cartRequest;
        this.cartItemRequest = cartItemRequest;
    }

    public CartRequest getCartRequest() {
        return cartRequest;
    }

    public void setCartRequest(CartRequest cartRequest) {
        this.cartRequest = cartRequest;
    }

    public CartItemRequest getCartItemRequest() {
        return cartItemRequest;
    }

    public void setCartItemRequest(CartItemRequest cartItemRequest) {
        this.cartItemRequest = cartItemRequest;
    }
}
