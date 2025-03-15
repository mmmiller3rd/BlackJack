package com.mmmiller3rd.BlackJack.model;

import com.mmmiller3rd.BlackJack.model.enums.Rank;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

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
