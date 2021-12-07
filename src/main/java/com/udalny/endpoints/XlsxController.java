package com.udalny.endpoints;

import com.udalny.database.DocumentService;
import com.udalny.xlsx.DocumentListToSpreadsheetConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class XlsxController {

    @Autowired
    private DocumentService documentService;

    @Autowired
    private DocumentListToSpreadsheetConverter converter;

    @GetMapping("/save")
    public void save() {
        converter.convert(documentService.getAll());
    }
}
