package com.mmmiller3rd.BlackJack.service;

import com.mmmiller3rd.BlackJack.model.Card;
import com.mmmiller3rd.BlackJack.model.Deck;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.*;

class DeckServiceTest {
    private DeckService deckService;

    @BeforeEach
    void setUp() {
        deckService = Mockito.spy(new DeckService());

    }

    @Test
    void initializeNewGame() {
        assertTrue(deckService.initializeNewGame());
        verify(deckService, times(1)).getGameDeck(argThat(value -> value >= 2 && value < 9));
        verify(deckService, atLeast(2)).generateDeck();
        verify(deckService, atMost(8)).generateDeck();
        verify(deckService, times(1)).shuffle();
        verify(deckService, times(1)).setCutCard();
        assertTrue(deckService.gameDeck.getCards().size() >= 104);
    }

    @Test
    void getGameDeck() {
        int gameDeckSize = 6 * 52;
        Deck gameDeck = deckService.getGameDeck(6);
        verify(deckService, times(6)).generateDeck();
        assertNotNull(gameDeck);
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

    @Test
    void shuffle() {
        int numDecks = 2;
        Deck temp = deckService.getGameDeck(numDecks);
        List<Card> cardListSpy = Mockito.spy(temp.getCards());
        deckService.gameDeck = new Deck(cardListSpy);
        deckService.shuffle();
        int swapped = 0;
        String[] suits = {"S", "D", "C", "H"};
        String[] ranks = {"A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3", "2"};
        for (int z = 0; z < numDecks; z++) {
            for (int x = 0; x < suits.length; x++) {
                for (int y = 0; y < ranks.length; y++) {
                    String card = ranks[y] + suits[x];
                    if (!card.equalsIgnoreCase(deckService.gameDeck.getCards().get(52 * z + 13 * x + y).toString())) {
                        swapped++;
                    }
                }
            }
        }
        assertTrue(swapped > 20); // as shuffling is random this may fail
        verify(deckService.gameDeck.getCards(), atLeast(200 * deckService.gameDeck.getCards().size())).set(anyInt(), any());
        verify(deckService.gameDeck.getCards(), atMost(2000 * deckService.gameDeck.getCards().size())).set(anyInt(), any());
        verify(deckService, times(1)).setCutCard();
    }

    @Test
    void setCutCard() {
        deckService.gameDeck = Mockito.spy(deckService.getGameDeck(2));
        deckService.setCutCard();
        assertTrue(deckService.gameDeck.getCutIndex() <= deckService.gameDeck.getCards().size() - 21
                && deckService.gameDeck.getCutIndex() >= deckService.gameDeck.getCards().size() - 37);
        verify(deckService.gameDeck, times(1)).setCutIndex(anyInt());
        verify(deckService.gameDeck, times(1)).setReadIndex(eq(0));
        assertEquals(0, deckService.gameDeck.getReadIndex());
    }
}