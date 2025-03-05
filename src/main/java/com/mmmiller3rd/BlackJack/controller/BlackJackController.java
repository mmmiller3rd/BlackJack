package com.mmmiller3rd.BlackJack.controller;

import com.mmmiller3rd.BlackJack.model.Deck;
import com.mmmiller3rd.BlackJack.model.Hands;
import com.mmmiller3rd.BlackJack.service.DeckService;
import com.mmmiller3rd.BlackJack.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlackJackController {
    private final DeckService deckService;
    private final GameService gameService;

    @Autowired
    public BlackJackController(DeckService deckService, GameService gameService) {
        this.deckService = deckService;
        this.gameService = gameService;
    }

    @GetMapping(value = "/newGame")
    public ResponseEntity<Deck> startNewGame(@RequestParam(defaultValue = "7", required = false) String numPlayer, @RequestParam(defaultValue = "4", required = false) String position) {
        gameService.startNewGame(Integer.parseInt(numPlayer), Integer.parseInt(position));
        return ResponseEntity.ok(gameService.gameDeck);
    }

    @GetMapping(value = "/deal")
    public ResponseEntity<Hands> deal() {
        return ResponseEntity.ok(gameService.deal());
    }
}
