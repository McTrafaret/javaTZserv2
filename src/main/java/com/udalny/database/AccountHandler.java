package com.udalny.database;

import com.udalny.entity.Account;
import com.udalny.entity.summarydocument.BankPay;
import com.udalny.entity.summarydocument.BankRcp;
import com.udalny.repository.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountHandler {

    private static Logger logger = LoggerFactory.getLogger(AccountHandler.class);

    @Autowired
    private AccountRepository accountRepository;

    public Account get(String accountNumber, String treasuryAccountNumber) {

        if(accountRepository.existsByAccountNumber(accountNumber)) {
            List<Account> res = accountRepository.getByAccountNumber(accountNumber);
            if (res.size() == 1)
                return res.get(0);
            else
                logger.warn("Found more than one entry by accountNumber");
        }

        if(accountRepository.existsByTreasuryAccountNumber(treasuryAccountNumber)) {
            List<Account> res = accountRepository.getByTreasuryAccountNumber(treasuryAccountNumber);
            if (res.size() == 1)
                return res.get(0);
            else
                logger.warn("Found more than one entry by treasuryAccountNumber");
        }

        return accountRepository.save(new Account(accountNumber, treasuryAccountNumber));
    }

    public Account get(BankPay bankPay) {
        return get(bankPay.getBsPay(), bankPay.getBsKsPay());
    }

    public Account get(BankRcp bankRcp) {
        return get(bankRcp.getBsPay(), bankRcp.getBsKsPay());
    }

}
