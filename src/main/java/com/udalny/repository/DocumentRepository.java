package com.udalny.repository;

import com.udalny.entity.Document;
import com.udalny.entity.statistics.DocumentsStatistics;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface DocumentRepository extends CrudRepository<Document, Integer> {

    @Query(value = "SELECT new com.udalny.entity.statistics.DocumentsStatistics(COUNT(d.id), SUM(d.amountOut)/COUNT(d.id)) FROM Document d")
    DocumentsStatistics getStatistics();
}
