package com.tts.RuleZero.repository;

import com.tts.RuleZero.model.UriList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UriListRepository extends CrudRepository<UriList, Long> {
}
