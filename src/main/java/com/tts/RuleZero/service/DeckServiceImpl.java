package com.tts.RuleZero.service;

import com.tts.RuleZero.model.Deck;
import com.tts.RuleZero.model.DeckDisplay;
import com.tts.RuleZero.model.User;
import com.tts.RuleZero.repository.DeckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeckServiceImpl implements DeckService{

    @Autowired
    DeckRepository deckRepository;

    public void save(Deck deck){
        deckRepository.save(deck);
    }

    public List<DeckDisplay> findAll(){
        List<Deck> decks = (List)deckRepository.findAll();
        return formatDecks(decks);
    }

    public List<DeckDisplay> findAllByUser(User user){
        List<Deck> decks = deckRepository.findAllByUserOrderByCreatedAtDesc(user);
        return formatDecks(decks);
    }

    private List<DeckDisplay> formatDecks(List<Deck> decks){
        List<DeckDisplay> response = new ArrayList<>();
        for(Deck deck : decks){
            DeckDisplay deckDisplay = new DeckDisplay();
            deckDisplay.setId(deck.getId());
            deckDisplay.setTitle(deck.getTitle());
            deckDisplay.setDescription(deck.getDescription());
            deckDisplay.setCardCount(deck.getCardCount());
            deckDisplay.setColors(deck.getColors());
            deckDisplay.setUser(deck.getUser());
            deckDisplay.setQualities(deck.getQualities());
            deckDisplay.setCards(deck.getCards());
            deckDisplay.setDeckImage(deckDisplay.getDeckImage());
            response.add(deckDisplay);
        }
        return response;
    }
}
