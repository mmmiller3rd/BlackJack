package com.mmmiller3rd.BlackJack.service;

import com.mmmiller3rd.BlackJack.model.Card;
import com.mmmiller3rd.BlackJack.model.Deck;
import com.mmmiller3rd.BlackJack.model.enums.Rank;
import com.mmmiller3rd.BlackJack.model.enums.Suit;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

@Component
public class DeckService {

    private final Random num;

    public int numDecks;
    public Deck gameDeck;

    public DeckService() {
        num = new Random();
        gameDeck = new Deck();
    }

    public boolean initializeNewGame() {
        numDecks = num.nextInt(7) + 2;
        gameDeck = getGameDeck(numDecks);
        shuffle();
        return true;
    }

    public Deck getGameDeck(Integer numDecks) {
        Deck gameDeck = new Deck();
        IntStream.range(0, numDecks).forEach(x -> {
            gameDeck.getCards().addAll(generateDeck().getCards());
        });
        return gameDeck;
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

    public void shuffle() {
        int shuffles = num.nextInt(900) + 100;
        IntStream.range(0, shuffles).forEach(x -> {
            for (int index = 0; index < gameDeck.getCards().size(); index++) {
                int swap = num.nextInt(gameDeck.getCards().size());
                while (swap == index) {
                    swap = num.nextInt(gameDeck.getCards().size());
                }
                Card temp = gameDeck.getCards().get(index);
                gameDeck.getCards().set(index, gameDeck.getCards().get(swap));
                gameDeck.getCards().set(swap, temp);
            }
        });
        setCutCard();
    }

    public void setCutCard() {
        int cutIndex = num.nextInt(16) + (int) (gameDeck.getCards().size() * .192308);
        gameDeck.setCutIndex((gameDeck.getCards().size() - 1) - cutIndex);
        gameDeck.setReadIndex(0);
    }
}
