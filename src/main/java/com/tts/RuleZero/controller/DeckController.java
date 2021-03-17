package com.tts.RuleZero.controller;

import com.tts.RuleZero.config.SwaggerConfig;
import com.tts.RuleZero.model.Deck;
import com.tts.RuleZero.model.DeckDisplay;
import com.tts.RuleZero.model.User;
import com.tts.RuleZero.repository.DeckRepository;
import com.tts.RuleZero.repository.UserRepository;
import com.tts.RuleZero.service.DeckService;
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

    @Autowired
    DeckService deckService;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/")
    @ApiOperation(value = "Get the list of all decks", response = DeckDisplay.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 302, message = "Found - Provided the list of decks")
    })
    public ResponseEntity<List<DeckDisplay>> getDeckList() {
        List<DeckDisplay> deckList = deckService.findAll();
        return new ResponseEntity<>(deckList, HttpStatus.FOUND);
    }

    @GetMapping(value="/user/{userId}")
    @ApiOperation(value = "Get a list of decks by providing a user Id number", response = DeckDisplay.class)
    @ApiResponses(value = {
            @ApiResponse(code = 302, message = "Found - Provided the decks requested"),
            @ApiResponse(code = 404, message = "Not Found - No decks with the specified User Id were found")
    })
    public ResponseEntity<List<DeckDisplay>> getUserDecks(@PathVariable(value = "userId") Long userId) {
        Optional<User> selectedUser = userRepository.findById(userId);
        List<DeckDisplay> decks;
        if(selectedUser.isPresent()){
            decks = deckService.findAllByUser(selectedUser.get());
        } else return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(decks, HttpStatus.FOUND);
    }

    @GetMapping(value="/{id}")
    @ApiOperation(value = "Get a specific deck by providing its id number", response = DeckDisplay.class)
    @ApiResponses(value = {
            @ApiResponse(code = 302, message = "Found - Provided the deck requested"),
            @ApiResponse(code = 404, message = "Not Found - No deck with the specified id was found")
    })
    public ResponseEntity<DeckDisplay> getDeck(@PathVariable(value = "id") Long id) {
        Optional<DeckDisplay> deck = deckService.findById(id);
        if (deck.isPresent()) {
            return new ResponseEntity<>(deck.get(), HttpStatus.FOUND);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
