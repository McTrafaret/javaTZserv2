package com.udalny.entity.statistics.handler;

import com.udalny.entity.statistics.DocumentsStatistics;
import com.udalny.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("statistics_query")
@Service
public class QueryStatisticsHandler
        implements StatisticsHandler {

    @Autowired
    private DocumentRepository documentRepository;

    @Override
    public DocumentsStatistics createStatistics() {
        return documentRepository.getStatistics();
    }
}
