package com.tts.RuleZero.repository;

import com.tts.RuleZero.model.Deck;
import com.tts.RuleZero.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeckRepository extends PagingAndSortingRepository<Deck, Long> {
    List<Deck> findAllByUserOrderByCreatedAtDesc(User user);
}
