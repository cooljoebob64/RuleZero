package com.tts.RuleZero.controller;

import com.tts.RuleZero.config.SwaggerConfig;
import com.tts.RuleZero.model.Deck;
import com.tts.RuleZero.repository.DeckRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@Api(tags = {
        SwaggerConfig.TAG_V1
})
@RequestMapping("/decks")
public class DeckController {

    @Autowired
    DeckRepository deckRepository;

    @GetMapping("/")
    @ApiOperation(value = "Get the list of all decks", response = Deck.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 302, message = "Found - Provided the list of decks")
    })
    public ResponseEntity<List<Deck>> getDeckList() {
        List<Deck> deckList = (List<Deck>) deckRepository.findAll();
        return new ResponseEntity<>(deckList, HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get a specific deck by providing its id number", response = Deck.class)
    @ApiResponses(value = {
            @ApiResponse(code = 302, message = "Found - Provided the deck requested"),
            @ApiResponse(code = 404, message = "Not Found - No deck with the specified id was found")
    })
    public ResponseEntity<Deck> getDeck(@PathVariable(value = "id") Long id) {
        Optional<Deck> deck = deckRepository.findById(id);
        if (deck.isPresent()) {
            return new ResponseEntity<>(deck.get(), HttpStatus.FOUND);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
