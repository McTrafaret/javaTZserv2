package com.udalny.xlsx;

import com.udalny.entity.Document;

import java.util.List;

public interface DocumentListToSpreadsheetConverter {

    void convert(List<Document> docs);
}
