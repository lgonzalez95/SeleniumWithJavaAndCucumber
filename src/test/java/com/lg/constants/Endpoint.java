package com.lg.constants;

public enum Endpoint {
    LOGIN("?route=account/login"),
    REGISTER("?route=account/register"),
    HOME("?route=common/home"),
    CART("?route=checkout/cart");

    public final String url;

    Endpoint(String url) {
        this.url = url;
    }
}
