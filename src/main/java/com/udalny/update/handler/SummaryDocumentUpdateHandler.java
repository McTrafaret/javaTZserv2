package com.udalny.update.handler;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.udalny.database.AccountService;
import com.udalny.database.BankService;
import com.udalny.database.OrganizationService;
import com.udalny.entity.Document;
import com.udalny.entity.packet.Packet;
import com.udalny.entity.packet.PacketType;
import com.udalny.entity.summarydocument.SummaryDocument;
import com.udalny.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SummaryDocumentUpdateHandler
        implements UpdateHandler {

    private final Gson gson = new GsonBuilder().setDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz").create();

    @Autowired
    private OrganizationService organizationService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private BankService bankService;

    @Autowired
    private DocumentRepository documentRepository;

    @Override
    public boolean probe(Packet p) {
        return p.getType() == PacketType.REPORT_PAYDOCS;
    }

    @Override
    public void update(Packet p) {

        List<SummaryDocument> docs = gson.fromJson(p.getData(), new TypeToken<List<SummaryDocument>>(){}.getType());

        for (SummaryDocument doc : docs) {

            Document res = new Document();
            res.setDocNum(doc.getDocNum());
            res.setDocDate(doc.getDocDate());
            res.setDocGUID(doc.getDocGuid());
            res.setOperType(doc.getOperType());
            res.setAmountOut(doc.getAmountOut());
            res.setPayer(organizationService.get(doc.getInfPay()));
            res.setPayerAccount(accountService.get(doc.getBankPay()));
            res.setPayerBank(bankService.get(doc.getBankPay()));
            res.setReceiver(organizationService.get(doc.getInfRcp()));
            res.setReceiverAccount(accountService.get(doc.getBankRcp()));
            res.setReceiverBank(bankService.get(doc.getBankRcp()));

            documentRepository.save(res);
        }
    }
}
