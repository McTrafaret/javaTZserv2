package com.udalny.endpoints;


import com.udalny.entity.packet.Packet;
import com.udalny.update.handler.UpdateHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DatabaseUpdateController {

    static Logger logger = LoggerFactory.getLogger(DatabaseUpdateController.class);

    @Autowired
    List<UpdateHandler> handlers;

    @PutMapping("/update")
    public void update(@RequestBody Packet p) {
        logger.info(p.toString());
        for (UpdateHandler handler : handlers) {
           if(handler.probe(p))
               handler.update(p);
        }

    }

}
