package com.mmmiller3rd.BlackJack.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Deck {
    private List<Card> cards = new ArrayList<>();
    private int cutIndex;
}
