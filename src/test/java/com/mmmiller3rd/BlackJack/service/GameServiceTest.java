package com.mmmiller3rd.BlackJack.service;

import com.mmmiller3rd.BlackJack.model.Deck;
import com.mmmiller3rd.BlackJack.model.Hands;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GameServiceTest {

    @Mock
    private DeckService deckService_mock;

    @Spy
    @InjectMocks
    private GameService gameService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void startNewGame() {
        int numPlayers = 7;
        int position = 4;
        when(deckService_mock.initializeNewGame()).thenReturn(true);
        gameService.startNewGame(numPlayers, position);
        verify(deckService_mock, times(1)).initializeNewGame();
        verify(gameService, times(1)).initializeHands();
        assertNull(gameService.gameDeck);
        assertEquals(numPlayers, gameService.numPlayers);
        assertEquals(position, gameService.playerPosition);
        assertNotNull(gameService.hands);
        assertNotNull(gameService.hands.getHands());
        assertEquals(numPlayers + 1, gameService.hands.getHands().size());
        assertTrue(gameService.gameInProgress);
    }

    @Test
    void deal() {
        int numPlayers = 7;
        int position = 4;
        when(deckService_mock.initializeNewGame()).thenCallRealMethod();
        when(deckService_mock.getGameDeck(anyInt())).thenCallRealMethod();
        when(deckService_mock.generateDeck()).thenCallRealMethod();
        doCallRealMethod().when(deckService_mock).setCutCard(any());
        gameService.startNewGame(numPlayers, position);
        int readIndex = gameService.gameDeck.getReadIndex();
        Hands hands = gameService.deal();
        assertNotNull(hands);
        assertEquals(readIndex + (numPlayers + 1) * 2, gameService.gameDeck.getReadIndex());
        hands.getHands().forEach(hand -> {
            assertEquals(2, hand.getCards().size());
        });
    }

    @Test
    void deal_afterCutIndexReached() {
        int numPlayers = 7;
        int position = 4;
        when(deckService_mock.initializeNewGame()).thenCallRealMethod();
        when(deckService_mock.getGameDeck(anyInt())).thenCallRealMethod();
        when(deckService_mock.generateDeck()).thenCallRealMethod();
        doCallRealMethod().when(deckService_mock).setCutCard(any());
        doCallRealMethod().when(deckService_mock).shuffle();
        gameService.startNewGame(numPlayers, position);
        int cutIndex = gameService.gameDeck.getCutIndex();
        gameService.gameDeck.setReadIndex(cutIndex);
        Hands hands = gameService.deal();
        assertNotNull(hands);
        assertEquals(16, gameService.gameDeck.getReadIndex());
        hands.getHands().forEach(hand -> {
            assertEquals(2, hand.getCards().size());
        });
        verify(deckService_mock, times(1)).shuffle();
    }
}