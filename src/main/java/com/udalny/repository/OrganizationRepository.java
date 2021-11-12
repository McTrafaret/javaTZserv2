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
SELECT A.CName, A.pay, B.rec FROM (
    SELECT ORGANIZATIONS.ID AS ID, ORGANIZATIONS.CName, COUNT(DOCUMENTS.ID) AS pay
    FROM ORGANIZATIONS
    LEFT JOIN DOCUMENTS
    ON ORGANIZATIONS.ID = DOCUMENTS.PayId
    GROUP BY ID
) AS A JOIN (
    SELECT ORGANIZATIONS.ID AS ID, COUNT(DOCUMENTS.ID) AS rec
    FROM ORGANIZATIONS
    LEFT JOIN DOCUMENTS
    ON ORGANIZATIONS.ID = DOCUMENTS.RecId
    GROUP BY ID
) AS B ON A.ID = B.ID
            """, nativeQuery = true
    )
    List<OrganizationInfo> getAllInfo();

    @Query(
            value = """
SELECT A.CName, A.pay, B.rec FROM (
    SELECT ORGANIZATIONS.ID AS ID, ORGANIZATIONS.CName, COUNT(DOCUMENTS.ID) AS pay
    FROM ORGANIZATIONS
    LEFT JOIN DOCUMENTS
    ON ORGANIZATIONS.ID = DOCUMENTS.PayId
    GROUP BY ID
) AS A JOIN (
    SELECT ORGANIZATIONS.ID AS ID, COUNT(DOCUMENTS.ID) AS rec
    FROM ORGANIZATIONS
    LEFT JOIN DOCUMENTS
    ON ORGANIZATIONS.ID = DOCUMENTS.RecId
    GROUP BY ID
) AS B ON A.ID = B.ID
WHERE CName = ?1
            """, nativeQuery = true
    )
    OrganizationInfo getInfoByCname(String cname);
}
