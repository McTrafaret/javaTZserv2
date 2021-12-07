package com.udalny.endpoints;

import com.google.gson.Gson;
import com.udalny.database.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrganizationInfoController {

    private static Gson gson = new Gson();

    @Autowired
    OrganizationService organizationService;

    @GetMapping(value = "/info", produces = MediaType.APPLICATION_JSON_VALUE)
    public String info(@RequestParam(required = false) String cname) {
        if(cname != null) {
            return gson.toJson(organizationService.getInfo(cname));
        }

        return gson.toJson(organizationService.getInfo());
    }
}
