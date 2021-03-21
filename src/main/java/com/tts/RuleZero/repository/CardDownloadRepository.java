package com.tts.RuleZero.repository;

import com.tts.RuleZero.model.CardDownload;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardDownloadRepository extends PagingAndSortingRepository<CardDownload, Long> {
}
