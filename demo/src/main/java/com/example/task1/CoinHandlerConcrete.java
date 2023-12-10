package com.example;

public class CoinHandlerConcrete implements CoinHandler {
    private int denomination;
    private CoinHandler nextHandler;

    public CoinHandlerConcrete(int denomination) {
        this.denomination = denomination;
    }

    @Override
    public void setNextHandler(CoinHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleRequest(int amount) {
        if (amount >= denomination) {
            int num = amount / denomination;
            int remainder = amount % denomination;
            System.out.println(num + " coin(s) of denomination " + denomination);

            if (remainder != 0 && nextHandler != null) {
                nextHandler.handleRequest(remainder);
            }
        } else if (nextHandler != null) {
            nextHandler.handleRequest(amount);
        } else {
            System.out.println("Cannot provide exact change for amount: " + amount);
        }
    }
}
