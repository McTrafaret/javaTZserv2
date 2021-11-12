package com.udalny.endpoints;

import com.google.gson.Gson;
import com.udalny.entity.statistics.OrganizationInfo;
import com.udalny.entity.statistics.OrganizationInfoObject;
import com.udalny.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RestController
public class OrganizationInfoController {

    private static Gson gson = new Gson();

    @Autowired
    OrganizationRepository organizationRepository;

    @GetMapping(value = "/info", produces = MediaType.APPLICATION_JSON_VALUE)
    public String info(@RequestParam(required = false) String cname) {
        if(cname != null) {
            OrganizationInfo info = organizationRepository.getInfoByCname(cname);
            if(info == null)
                return gson.toJson(null);

            return gson.toJson(new OrganizationInfoObject(info.getCname(), info.getPay(), info.getRec()));
        }

        List<OrganizationInfo> allInfo = organizationRepository.getAllInfo();
        if(allInfo == null)
            return gson.toJson(null);
        List<OrganizationInfoObject> res = new LinkedList<>();
        for (OrganizationInfo info : allInfo) {
            res.add(new OrganizationInfoObject(info.getCname(), info.getPay(), info.getRec()));
        }

        return gson.toJson(res);
    }
}
