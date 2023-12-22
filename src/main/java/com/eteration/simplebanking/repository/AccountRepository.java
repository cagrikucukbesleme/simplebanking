package com.eteration.simplebanking.repository;

import com.eteration.simplebanking.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author cagri
 */
@Repository
public interface AccountRepository extends JpaRepository<Account,String> {
    Account findByAccountNumber (String accountNumber);
}
