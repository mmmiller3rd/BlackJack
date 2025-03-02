package com.mmmiller3rd.BlackJack.service;

import com.mmmiller3rd.BlackJack.model.Deck;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class DeckServiceTest {
    private DeckService deckService;

    @BeforeEach
    void setUp() {
        deckService = new DeckService();
    }

    @Test
    void getGameDeck() {
        int gameDeckSize = 6 * 52;
        Deck gameDeck = deckService.getGameDeck(6);
        assertFalse(gameDeck.getCards().get(0).toString().equalsIgnoreCase("AS"));
        assertTrue(gameDeck.getCutIndex() < gameDeckSize - 61 && gameDeck.getCutIndex() > 76);
    }

    @Test
    void generateDeck() {
        String[] suits = {"S", "D", "C", "H"};
        Deck deck = deckService.generateDeck();
        for (int x = 0; x < 4; x++) {
            assertEquals("A" + suits[x], deck.getCards().get(13 * x).toString());
            assertEquals("K" + suits[x], deck.getCards().get(1 + (13 * x)).toString());
            assertEquals("Q" + suits[x], deck.getCards().get(2 + (13 * x)).toString());
            assertEquals("J" + suits[x], deck.getCards().get(3 + (13 * x)).toString());
            assertEquals("10" + suits[x], deck.getCards().get(4 + (13 * x)).toString());
            assertEquals("9" + suits[x], deck.getCards().get(5 + (13 * x)).toString());
            assertEquals("8" + suits[x], deck.getCards().get(6 + (13 * x)).toString());
            assertEquals("7" + suits[x], deck.getCards().get(7 + (13 * x)).toString());
            assertEquals("6" + suits[x], deck.getCards().get(8 + (13 * x)).toString());
            assertEquals("5" + suits[x], deck.getCards().get(9 + (13 * x)).toString());
            assertEquals("4" + suits[x], deck.getCards().get(10 + (13 * x)).toString());
            assertEquals("3" + suits[x], deck.getCards().get(11 + (13 * x)).toString());
            assertEquals("2" + suits[x], deck.getCards().get(12 + (13 * x)).toString());
        }

    }
}