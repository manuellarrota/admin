package org.example.core.repository;

import org.example.core.domain.BPTransaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BPTransactionRepository extends CrudRepository<BPTransaction, Long> {
}
