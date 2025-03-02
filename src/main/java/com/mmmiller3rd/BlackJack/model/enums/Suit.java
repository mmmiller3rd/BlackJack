package com.mmmiller3rd.BlackJack.model.enums;

public enum Suit {
    Spade ("S"),
    Diamond ("D"),
    Club ("C"),
    Heart ("H");

    private String suit;

    Suit(String suit) {
        this.suit = suit;
    }

    public static Suit from(char suit) {
        return switch (suit) {
            case 'S' -> Spade;
            case 'D' -> Diamond;
            case 'C' -> Club;
            default -> Heart;
        };
    }

    public String text() {
        return this.suit;
    }
}
