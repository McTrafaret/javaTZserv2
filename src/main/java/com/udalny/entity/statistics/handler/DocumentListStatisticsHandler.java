package com.udalny.entity.statistics.handler;

import com.udalny.entity.Document;
import com.udalny.entity.statistics.DocumentsStatistics;
import com.udalny.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

@Service
@Profile("statistics_list")
public class DocumentListStatisticsHandler
        implements StatisticsHandler {

    @Autowired
    private DocumentRepository documentRepository;

    @Override
    public DocumentsStatistics createStatistics() {
        List<Document> documentList = new LinkedList<>();
        documentRepository.findAll().forEach(documentList::add);
        int count = documentList.size();
        BigDecimal temp = new BigDecimal(0);
        for (Document doc : documentList) {
            temp = temp.add(doc.getAmountOut());
        }
        return new DocumentsStatistics(count, temp.divide(new BigDecimal(count)));
    }
}
