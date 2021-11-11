package com.udalny.repository;

import com.udalny.entity.Organization;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrganizationRepository extends CrudRepository<Organization, Integer> {

    List<Organization> getByInnAndKpp(String inn, String kpp);
    List<Organization> getByCname(String cname);
    boolean existsByCname(String cname);
    boolean existsByInnAndKpp(String inn, String kpp);
}
