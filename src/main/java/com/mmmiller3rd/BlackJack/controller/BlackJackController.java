package com.mmmiller3rd.BlackJack.controller;

import com.mmmiller3rd.BlackJack.model.Deck;
import com.mmmiller3rd.BlackJack.service.DeckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlackJackController {
    private final DeckService deckService;

    @Autowired
    public BlackJackController(DeckService deckService) {
        this.deckService = deckService;
    }

    @GetMapping(value = "/newGame")
    public ResponseEntity<Deck> startNewGame(@RequestParam(defaultValue = "7", required = false) String numPlayer, @RequestParam(defaultValue = "4", required = false) String position) {
        Deck gameDeck = deckService.getGameDeck(3);
        return ResponseEntity.ok(gameDeck);
    }
}
