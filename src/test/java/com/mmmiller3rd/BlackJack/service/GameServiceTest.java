package com.mmmiller3rd.BlackJack.service;

import com.mmmiller3rd.BlackJack.model.Card;
import com.mmmiller3rd.BlackJack.model.Deck;
import com.mmmiller3rd.BlackJack.model.Hands;
import com.mmmiller3rd.BlackJack.model.enums.Rank;
import com.mmmiller3rd.BlackJack.model.enums.Suit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GameServiceTest {

    private DeckService deckService_spy;
    private GameService gameService_spy;

    @BeforeEach
    public void setUp() {
        deckService_spy = Mockito.spy(new DeckService());
        gameService_spy = Mockito.spy(new GameService(deckService_spy));
    }

    @Test
    void startNewGame() {
        int numPlayers = 7;
        int position = 4;
        gameService_spy.startNewGame(numPlayers, position);
        verify(deckService_spy, times(1)).initializeNewGame();
        verify(gameService_spy, times(1)).initializeHands();
        assertNotNull(gameService_spy.gameDeck);
        assertTrue(gameService_spy.hands.getHands().get(position -1).isPlayer());
        assertTrue(gameService_spy.hands.getHands().get(numPlayers).isDealer());
        assertEquals(numPlayers, gameService_spy.numPlayers);
        assertEquals(position, gameService_spy.playerPosition);
        assertNotNull(gameService_spy.hands);
        assertNotNull(gameService_spy.hands.getHands());
        assertEquals(numPlayers + 1, gameService_spy.hands.getHands().size());
        assertTrue(gameService_spy.gameInProgress);
    }

    @Test
    void initializeHands() {
        gameService_spy.numPlayers = 7;
        gameService_spy.playerPosition = 4;
        gameService_spy.initializeHands();
        assertNotNull(gameService_spy.hands);
        assertNotNull(gameService_spy.hands.getHands());
        assertEquals(8, gameService_spy.hands.getHands().size());
        assertTrue(gameService_spy.hands.getHands().get(3).isPlayer());
        assertTrue(gameService_spy.hands.getHands().get(7).isDealer());
    }

    @Test
    void deal() {
        initialize();
        int readIndex = gameService_spy.gameDeck.getReadIndex();
        Hands hands = gameService_spy.deal();
        assertNotNull(hands);
        verify(gameService_spy, times(1)).initializeHands();
        assertEquals(readIndex + (8) * 2, gameService_spy.gameDeck.getReadIndex());
        hands.getHands().forEach(hand -> {
            assertEquals(2, hand.getCards().size());
        });
    }

    @Test
    void deal_afterCutIndexReached() {
        initialize();
        int cutIndex = gameService_spy.gameDeck.getCutIndex();
        gameService_spy.gameDeck.setReadIndex(cutIndex);
        Hands hands = gameService_spy.deal();
        assertNotNull(hands);
        assertEquals(16, gameService_spy.gameDeck.getReadIndex());
        hands.getHands().forEach(hand -> {
            assertEquals(2, hand.getCards().size());
        });
        verify(deckService_spy, times(1)).shuffle();
        verify(gameService_spy, times(2)).initializeHands();
    }

    private void initialize() {
        gameService_spy.numPlayers = 7;
        gameService_spy.playerPosition = 4;
        deckService_spy.gameDeck = new Deck();
        deckService_spy.gameDeck.setCutIndex(45);
        deckService_spy.gameDeck.setCutIndex(50);
        Arrays.stream(Suit.values()).forEach(suit -> {
            Arrays.stream(Rank.values()).forEach(rank -> {
                deckService_spy.gameDeck.getCards().add(new Card(suit, rank));
            });
        });
        gameService_spy.gameDeck = deckService_spy.gameDeck;
    }
}