- запрос на получение для каждой организации кол-ва документов, где организация отправитель
`SELECT ORGANIZATIONS.CName, COUNT(DOCUMENTS.ID) AS pay FROM ORGANIZATIONS LEFT JOIN DOCUMENTS ON ORGANIZATIONS.ID = DOCUMENTS.PayId GROUP BY PayId;`
  
- запрос на получение для каждой организации кол-ва документов, где организация получатель
`SELECT ORGANIZATIONS.CName, COUNT(DOCUMENTS.ID) AS rec FROM ORGANIZATIONS LEFT JOIN DOCUMENTS ON ORGANIZATIONS.ID = DOCUMENTS.RecId GROUP BY RecId;`


- общий запрос
```
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
) AS B ON A.ID = B.ID;
```