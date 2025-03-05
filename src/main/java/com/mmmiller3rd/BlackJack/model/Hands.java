package com.mmmiller3rd.BlackJack.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Hands {
    private List<Hand> hands = new ArrayList<>();
}
