package com.example;

public interface CoinHandler {
    void setNextHandler(CoinHandler nextHandler);
    void handleRequest(int amount);
}
