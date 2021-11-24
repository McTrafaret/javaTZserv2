package com.udalny.update.handler;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.udalny.database.OrganizationService;
import com.udalny.entity.Organization;
import com.udalny.entity.PTDocument;
import com.udalny.entity.PTDocumentEntity;
import com.udalny.entity.packet.Packet;
import com.udalny.entity.packet.PacketType;
import com.udalny.repository.PTDocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PTUpdateHandler
        implements UpdateHandler {

    private final Gson gson = new GsonBuilder().setDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz").create();

    @Autowired
    private OrganizationService organizationService;

    @Autowired
    private PTDocumentRepository ptDocumentRepository;

    @Override
    public boolean probe(Packet p) {
        return p.getType() == PacketType.PT;
    }

    @Override
    public void update(Packet p) {
        List<PTDocument> docs = gson.fromJson(p.getData(), new TypeToken<List<PTDocument>>(){}.getType());
        for (PTDocument doc : docs) {
            PTDocumentEntity entity = new PTDocumentEntity();

            Organization organization = organizationService.get(doc.getSenderOrganizationName());
            entity.setSenderOrganizationName(organization);
            organization = organizationService.get(doc.getReceiverOrganizationName());
            entity.setReceiverOrganizationName(organization);

            entity.setGuidReceived(doc.getGuidReceived());
            entity.setNumReceived(doc.getNumReceived());
            entity.setDateReceived(doc.getDateReceived());
            entity.setAmountSend(doc.getAmountSend());
            entity.setGuidSend(doc.getGuidSend());
            entity.setTypeSend(doc.getTypeSend());
            entity.setTypeNameSend(doc.getTypeNameSend());
            entity.setNumSend(doc.getNumSend());
            entity.setDateSend(doc.getDateSend());
            entity.setRejectionReason(doc.getRejectionReason());

            ptDocumentRepository.save(entity);
        }
    }
}
