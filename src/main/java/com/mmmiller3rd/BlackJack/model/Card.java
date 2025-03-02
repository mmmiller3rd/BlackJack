package com.mmmiller3rd.BlackJack.model;

import com.mmmiller3rd.BlackJack.model.enums.Rank;
import com.mmmiller3rd.BlackJack.model.enums.Suit;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Card {
    private Suit suit;
    private Rank rank;
    private int value;

    public Card(String card) {
        this.rank = Rank.from(card.substring(0, card.length() - 1));
        this.suit = Suit.from(card.charAt(card.length()-1));
        this.value = this.rank.value();
    }

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
        this.value = rank.value();
    }

    @Override
    public String toString() {
        return this.rank.text() + this.suit.text();
    }
}
