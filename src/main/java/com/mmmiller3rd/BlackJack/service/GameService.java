package com.mmmiller3rd.BlackJack.service;

import com.mmmiller3rd.BlackJack.model.Deck;
import com.mmmiller3rd.BlackJack.model.Hand;
import com.mmmiller3rd.BlackJack.model.Hands;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Slf4j
@Component
public class GameService {
    private final DeckService deckService;
    public Deck gameDeck;
    public int numPlayers;
    public int playerPosition;
    public Hands hands;
    public boolean gameInProgress;

    @Autowired
    public GameService(DeckService deckService) {
        this.deckService = deckService;
    }

    public void startNewGame(int numPlayers, int playerPosition) {
        if (!gameInProgress) {
            gameInProgress = deckService.initializeNewGame();
            gameDeck = deckService.gameDeck;
            this.numPlayers = numPlayers;
            this.playerPosition = playerPosition;
            initializeHands();
        }
    }

    public void initializeHands() {
        hands = new Hands();
        for (int x = 0; x < numPlayers; x++) {
            hands.getHands().add(new Hand(x == (playerPosition - 1)));
        }
        hands.getHands().add(new Hand());
        hands.getHands().get(numPlayers).setDealer(true);
        hands.getHands().get(numPlayers).setCards(new ArrayList<>());
    }

    public Hands deal() {
        initializeHands();
        int handIndex = 0;
        int deckReadIndex = gameDeck.getReadIndex();
        for (int x = 0; x < hands.getHands().size() * 2; x++) {
            if (deckReadIndex == gameDeck.getCutIndex()) {
                log.info("Reached cut card, shuffling and re-dealing...");
                deckService.shuffle();
                return deal();
            }
            if (handIndex > numPlayers) {
                handIndex = 0;
            }
            hands.getHands().get(handIndex).getCards().add(gameDeck.getCards().get(deckReadIndex));
            deckReadIndex++;
            handIndex++;
        }
        gameDeck.setReadIndex(deckReadIndex);
        return this.hands;
    }
}
