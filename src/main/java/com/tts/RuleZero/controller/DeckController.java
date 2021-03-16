package com.tts.RuleZero.controller;

import com.tts.RuleZero.model.Deck;
import com.tts.RuleZero.repository.DeckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class DeckController {

    @Autowired
    DeckRepository deckRepository;

    @GetMapping("/decks")
    public ResponseEntity<List<Deck>> getDeckList(){
        List<Deck> deckList = (List<Deck>) deckRepository.findAll();
        return new ResponseEntity<>(deckList, HttpStatus.FOUND);
    }

    @GetMapping("/decks/{id}")
    public ResponseEntity<Deck> getDeck(@PathVariable Long id){
       Optional<Deck> deck = deckRepository.findById(id);
       if(deck.isPresent()){
           return new ResponseEntity<>(deck.get(), HttpStatus.FOUND);
       } else
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
