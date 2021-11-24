package com.udalny.database;


import com.udalny.entity.Organization;
import com.udalny.entity.summarydocument.InfPay;
import com.udalny.entity.summarydocument.InfRcp;
import com.udalny.repository.OrganizationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationService {

    private static Logger logger = LoggerFactory.getLogger(OrganizationService.class);

    @Autowired
    private OrganizationRepository organizationRepository;

    public Organization get(String inn, String kpp, String cname) {
        if(organizationRepository.existsByInnAndKpp(inn, kpp)) {
            List<Organization> res = organizationRepository.getByInnAndKpp(inn, kpp);
            if (res.size() == 1)
                return res.get(0);
            else
                logger.warn("Found more than one entry of organizations by inn and kpp");
        }
        if(organizationRepository.existsByCname(cname)) {
            List<Organization> res = organizationRepository.getByCname(cname);
            if (res.size() == 1)
                return res.get(0);
            else
                logger.warn("Found more than one entry of organizations by cname");
        }
        return organizationRepository.save(new Organization(inn, kpp, cname));
    }

    public Organization get(String cname) {

        if(organizationRepository.existsByCname(cname)) {
            List<Organization> res = organizationRepository.getByCname(cname);
            if (res.size() == 1)
                return res.get(0);
            else
                logger.warn("Found more than one entry of organizations by cname");
        }
        return organizationRepository.save(new Organization("Unknown", "Unknown", cname)); // don't know what to do with this

    }

    public Organization get(InfPay infPay) {
        return get(infPay.getInnPay(), infPay.getKppPay(), infPay.getCnamePay());
    }

    public Organization get(InfRcp infRcp) {
        return get(infRcp.getInnPay(), infRcp.getKppPay(), infRcp.getCnamePay());
    }

}
