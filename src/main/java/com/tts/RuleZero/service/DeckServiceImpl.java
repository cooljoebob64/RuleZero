package com.tts.RuleZero.service;

import com.tts.RuleZero.model.Deck;
import com.tts.RuleZero.model.DeckDisplay;
import com.tts.RuleZero.model.User;
import com.tts.RuleZero.repository.DeckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class DeckServiceImpl implements DeckService{

    @Autowired
    DeckRepository deckRepository;

    public void save(Deck deck){
        deckRepository.save(deck);
    }

    public Deck addNewDeck(User user){
        Deck newDeck = new Deck();
        newDeck.setUser(user);
        deckRepository.save(newDeck);
        return newDeck;
    }

    public List<DeckDisplay> findAll(){
        List<Deck> decks = (List)deckRepository.findAll();
        return formatDeckList(decks);
    }

    public Optional<DeckDisplay> findById(Long id){
        Optional<Deck> foundDeck = deckRepository.findById(id);
        return foundDeck.map(this::formatDeck);
    }

    public List<DeckDisplay> findAllByUser(User user){
        List<Deck> decks = deckRepository.findAllByUserOrderByCreatedAtDesc(user);
        return formatDeckList(decks);
    }

    private DeckDisplay formatDeck(Deck deck){
        deck.setLastAccessedAt(new Date());
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
        deckDisplay.setLastUpdatedAt(deck.getLastUpdatedAt());
        deckDisplay.setLastAccessedAt(deck.getLastAccessedAt());
        return deckDisplay;
    }

    private List<DeckDisplay> formatDeckList(List<Deck> decks){
        List<DeckDisplay> response = new ArrayList<>();
        for(Deck deck : decks){
            response.add(formatDeck(deck));
        }
        return response;
    }
}
