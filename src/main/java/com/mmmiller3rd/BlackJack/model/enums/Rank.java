package com.mmmiller3rd.BlackJack.model.enums;

public enum Rank {
    Ace ("A", 11),
    King ("K", 10),
    Queen ("Q", 10),
    Jack ("J", 10),
    ten ("10", 10),
    nine ("9", 9),
    eight ("8", 8),
    seven ("7", 7),
    six ("6", 6),
    five ("5", 5),
    four ("4", 4),
    three ("3", 3),
    two ("2", 2);

    private String text;
    private int value;

    Rank(String text, int value) {
        this.text = text;
        this.value = value;
    }

    public static Rank from(String rank) {
        return switch (rank) {
            case "A" -> Ace;
            case "K" -> King;
            case "Q" -> Queen;
            case "J" -> Jack;
            case "10" -> ten;
            case "9" -> nine;
            case "8" -> eight;
            case "7" -> seven;
            case "6" -> six;
            case "5" -> five;
            case "4" -> four;
            case "3" -> three;
            default -> two;
        };
    }

    public int value() {
        return this.value;
    }

    public String text() {
        return this.text;
    }
}
