package com.udalny.repository;

import com.udalny.entity.Bank;
import org.springframework.data.repository.CrudRepository;

public interface BankRepository extends CrudRepository<Bank, Integer> {

    Bank getByBic(String bic);
    Bank getById(int id);
    boolean existsByBic(String bic);
    boolean existsById(int id);

}
