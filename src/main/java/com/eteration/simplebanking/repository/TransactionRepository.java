package com.eteration.simplebanking.repository;

import com.eteration.simplebanking.model.TransactionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author cagri
 */
@Repository
public interface TransactionRepository extends JpaRepository<TransactionModel, String> {
}
