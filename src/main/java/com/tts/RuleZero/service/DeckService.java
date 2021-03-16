package com.tts.RuleZero.service;

import com.tts.RuleZero.model.Deck;
import com.tts.RuleZero.model.DeckDisplay;

import java.util.List;

public interface DeckService {
    List<DeckDisplay> findAll();
    void save(Deck deck);
}
