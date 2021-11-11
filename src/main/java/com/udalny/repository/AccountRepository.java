package com.udalny.repository;

import com.udalny.entity.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccountRepository extends CrudRepository<Account, Integer> {

    Account getById(int id);
    List<Account> getByAccountNumber(String accountNumber);
    List<Account> getByTreasuryAccountNumber(String treasuryAccountNumber);
    boolean existsById(int id);
    boolean existsByAccountNumber(String accountNumber);
    boolean existsByTreasuryAccountNumber(String treasuryAccountNumber);
    boolean existsByAccountNumberAndTreasuryAccountNumber(String accountNumber, String treasuryAccountNumber);
}
