package com.udalny.endpoints;


import com.udalny.entity.summarydocument.SummaryDocument;
import com.udalny.update.handler.UpdateHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DatabaseUpdateController {

    static Logger logger = LoggerFactory.getLogger(DatabaseUpdateController.class);

    @Autowired
    UpdateHandler<SummaryDocument> handler;

    @PutMapping("/update")
    public ResponseEntity<List<SummaryDocument>> update(@RequestBody List<SummaryDocument> docs) {
        logger.info(docs.toString());
        for (SummaryDocument doc : docs) {
            if (handler.probe(doc))
                handler.update(doc);
        }

        return ResponseEntity.ok(docs);
    }

}
