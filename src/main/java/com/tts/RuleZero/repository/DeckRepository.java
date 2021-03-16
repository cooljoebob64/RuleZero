package com.tts.RuleZero.repository;

import com.tts.RuleZero.model.Deck;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeckRepository extends PagingAndSortingRepository<Deck, Long> {
}
