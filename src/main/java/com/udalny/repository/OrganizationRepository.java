package com.udalny.repository;

import com.udalny.entity.Organization;
import com.udalny.entity.statistics.OrganizationInfo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrganizationRepository extends CrudRepository<Organization, Integer> {
    
    List<Organization> getByInnAndKpp(String inn, String kpp);
    List<Organization> getByCname(String cname);
    boolean existsByCname(String cname);
    boolean existsByInnAndKpp(String inn, String kpp);

    @Query(
            value = """
SELECT ORGANIZATIONS.ID,
       CName,
       SUM(CASE WHEN ORGANIZATIONS.ID = PayId THEN 1 ELSE 0 END) AS pay,
       SUM(CASE WHEN ORGANIZATIONS.ID = RecId THEN 1 ELSE 0 END) AS rec
FROM
    ORGANIZATIONS JOIN DOCUMENTS
ON
    ORGANIZATIONS.ID = PayId
    OR
    ORGANIZATIONS.ID = RecId
GROUP BY
    ORGANIZATIONS.ID
            """, nativeQuery = true
    )
    List<OrganizationInfo> getAllInfo();

    @Query(
            value = """
SELECT ORGANIZATIONS.ID,
       CName,
       SUM(CASE WHEN ORGANIZATIONS.ID = PayId THEN 1 ELSE 0 END) AS pay,
       SUM(CASE WHEN ORGANIZATIONS.ID = RecId THEN 1 ELSE 0 END) AS rec
FROM
    ORGANIZATIONS JOIN DOCUMENTS
ON
    ORGANIZATIONS.ID = PayId
    OR
    ORGANIZATIONS.ID = RecId
WHERE CName = ?1
            """, nativeQuery = true
    )
    OrganizationInfo getInfoByCname(String cname);
}
