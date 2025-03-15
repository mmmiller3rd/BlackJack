package com.mmmiller3rd.BlackJack.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class Deck {
    private List<Card> cards = new ArrayList<>();
    private int cutIndex;
    private int readIndex;

    public Deck(List<Card> cards) {
        this.cards = cards;
    }
}
