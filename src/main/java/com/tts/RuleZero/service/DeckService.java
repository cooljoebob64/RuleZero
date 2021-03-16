package com.tts.RuleZero.service;

import com.tts.RuleZero.model.Deck;
import com.tts.RuleZero.model.DeckDisplay;
import com.tts.RuleZero.model.User;

import java.util.List;

public interface DeckService {
    List<DeckDisplay> findAll();
    List<DeckDisplay> findAllByUser(User user);
    void save(Deck deck);
}
