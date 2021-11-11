package com.udalny.endpoints;

import com.google.gson.Gson;
import com.udalny.entity.statistics.handler.StatisticsHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatisticsController {

    private static final Gson gson = new Gson();

    @Autowired
    private StatisticsHandler statisticsHandler;

    @GetMapping(value = "/statistics", produces = MediaType.APPLICATION_JSON_VALUE)
    public String statistics() {
        return gson.toJson(statisticsHandler.createStatistics());
    }
}
