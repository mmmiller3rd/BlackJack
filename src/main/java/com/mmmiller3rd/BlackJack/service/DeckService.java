package com.mmmiller3rd.BlackJack.service;

import com.mmmiller3rd.BlackJack.model.Card;
import com.mmmiller3rd.BlackJack.model.Deck;
import com.mmmiller3rd.BlackJack.model.enums.Rank;
import com.mmmiller3rd.BlackJack.model.enums.Suit;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Random;

@Component
public class DeckService {

    private Random num;

    public int numDecks;
    public Deck gameDeck;

    public DeckService() {
        num = new Random();
    }

    public boolean initializeNewGame() {
        if (num == null) {
            num = new Random();
        }
        numDecks = num.nextInt(7) + 2;
        gameDeck = getGameDeck(numDecks);
        return true;
    }

    public Deck getGameDeck(int numDecks) {
        Deck gameDeck = new Deck();
        for (int x = 0; x < numDecks; x++) {
            gameDeck.getCards().addAll(generateDeck().getCards());
        }
        shuffle(gameDeck);
        setCutCard(gameDeck);
        return gameDeck;
    }

    public void shuffle() {
        shuffle(gameDeck);
        setCutCard(gameDeck);
    }

    public void setCutCard(Deck gameDeck) {
        if (num == null) {
            num = new Random();
        }
        int cutIndex = num.nextInt(16) + (int) (gameDeck.getCards().size() * .192308);
        gameDeck.setCutIndex((gameDeck.getCards().size() - 1) - cutIndex);
        gameDeck.setReadIndex(0);
    }

    public void shuffle(Deck deck) {
        if (num == null) {
            num = new Random();
        }
        int shuffles = num.nextInt(900) + 100;
        for (int x = 0; x < shuffles; x++) {
            for (int index = 0; index < deck.getCards().size(); index++) {
                int swap = num.nextInt(deck.getCards().size());
                while (swap == index) {
                    swap = num.nextInt(deck.getCards().size());
                }
                Card temp = deck.getCards().get(index);
                deck.getCards().set(index, deck.getCards().get(swap));
                deck.getCards().set(swap, temp);
            }
        }
    }

    public Deck generateDeck() {
        Deck deck = new Deck();
        Arrays.stream(Suit.values()).forEach(suit -> {
            Arrays.stream(Rank.values()).forEach(rank -> {
                deck.getCards().add(new Card(suit, rank));
            });
        });
        return deck;
    }
}
