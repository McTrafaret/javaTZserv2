package com.udalny.update.handler;

import com.udalny.database.AccountHandler;
import com.udalny.database.BankHandler;
import com.udalny.database.OrganizationHandler;
import com.udalny.entity.Document;
import com.udalny.entity.summarydocument.SummaryDocument;
import com.udalny.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SummaryDocumentUpdateHandler
        implements UpdateHandler<SummaryDocument> {

    @Autowired
    private OrganizationHandler organizationHandler;

    @Autowired
    private AccountHandler accountHandler;

    @Autowired
    private BankHandler bankHandler;

    @Autowired
    private DocumentRepository documentRepository;

    @Override
    public boolean probe(SummaryDocument doc) {
        return true;
    }

    @Override
    public void update(SummaryDocument doc) {

        Document res = new Document();
        res.setDocNum(doc.getDocNum());
        res.setDocDate(doc.getDocDate());
        res.setDocGUID(doc.getDocGuid());
        res.setOperType(doc.getOperType());
        res.setAmountOut(doc.getAmountOut());
        res.setPayer(organizationHandler.get(doc.getInfPay()));
        res.setPayerAccount(accountHandler.get(doc.getBankPay()));
        res.setPayerBank(bankHandler.get(doc.getBankPay()));
        res.setReceiver(organizationHandler.get(doc.getInfRcp()));
        res.setReceiverAccount(accountHandler.get(doc.getBankRcp()));
        res.setReceiverBank(bankHandler.get(doc.getBankRcp()));

        documentRepository.save(res);

    }
}
