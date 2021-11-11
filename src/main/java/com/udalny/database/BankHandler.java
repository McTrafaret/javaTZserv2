package com.udalny.database;

import com.udalny.entity.Bank;
import com.udalny.entity.summarydocument.BankPay;
import com.udalny.entity.summarydocument.BankRcp;
import com.udalny.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankHandler {

    @Autowired
    private BankRepository bankRepository;

    public Bank get(String bic) {
        if (bankRepository.existsByBic(bic)) {
            return bankRepository.getByBic(bic);
        }

        return bankRepository.save(new Bank(bic));

    }

    public Bank get(BankPay bankPay) {
        return get(bankPay.getBicPay());
    }

    public Bank get(BankRcp bankRcp) {
        return get(bankRcp.getBicPay());
    }

}
