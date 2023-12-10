package com.example;

public class ATMChain {
    public static void main(String[] args) {
        int amount = 123; // Just an example

        CoinHandler handler50 = new CoinHandlerConcrete(50);
        CoinHandler handler20 = new CoinHandlerConcrete(20);
        CoinHandler handler10 = new CoinHandlerConcrete(10);
        CoinHandler handler5 = new CoinHandlerConcrete(5);
        CoinHandler handler1 = new CoinHandlerConcrete(1);

        handler50.setNextHandler(handler20);
        handler20.setNextHandler(handler10);
        handler10.setNextHandler(handler5);
        handler5.setNextHandler(handler1);

        handler50.handleRequest(amount);
    }
}
