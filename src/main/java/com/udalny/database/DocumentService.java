package com.udalny.database;

import com.udalny.entity.Document;
import com.udalny.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    public List<Document> getAll() {
        List<Document> documents = new LinkedList<>();
        for (Document doc : documentRepository.findAll()) {
            documents.add(doc);
        }
        return documents;
    }
}
