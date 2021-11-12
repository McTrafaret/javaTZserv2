package com.udalny.endpoints;

import com.udalny.entity.Document;
import com.udalny.repository.DocumentRepository;
import com.udalny.xlsx.DocumentListToSpreadsheetConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RestController
public class XlsxController {

    @Autowired
    private DocumentRepository documentRepository;

    @Autowired
    private DocumentListToSpreadsheetConverter converter;

    @GetMapping("/save")
    public void save() {
        List<Document> documentList = new LinkedList<>();
        for (Document doc : documentRepository.findAll()) {
            documentList.add(doc);
        }
        converter.convert(documentList);
    }
}
