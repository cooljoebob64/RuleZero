package com.tts.RuleZero.service;

import com.tts.RuleZero.model.Deck;
import com.tts.RuleZero.model.DeckDisplay;
import com.tts.RuleZero.model.User;

import java.util.List;
import java.util.Optional;

public interface DeckService {
    List<DeckDisplay> findAll();
    List<DeckDisplay> findAllByUser(User user);
    Optional<DeckDisplay> findById(Long id);
    void save(Deck deck);
    Deck addNewDeck(User user);
    int toggleActive(DeckDisplay deckDisplay);
}
