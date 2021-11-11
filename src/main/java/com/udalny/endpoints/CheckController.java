package com.udalny.endpoints;

import com.udalny.entity.Bank;
import com.udalny.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckController {

    @Autowired
    private BankRepository bankRepository;


    @GetMapping(value = "check/{bic}")
    public void update(@PathVariable("bic") String bic) {

        bankRepository.save(new Bank(bic));

    }

    @GetMapping(value = "get/{bic}")
    public Bank get(@PathVariable("bic") String bic) {

        return bankRepository.getByBic(bic);
    }

}
