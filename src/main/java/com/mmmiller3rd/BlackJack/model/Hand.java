package com.mmmiller3rd.BlackJack.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class Hand {
    private List<Card> cards;
    private boolean isDealer;
    private boolean isPlayer;

    public Hand(boolean isPlayer) {
        cards = new ArrayList<>();
        this.isPlayer = isPlayer;
    }
}
