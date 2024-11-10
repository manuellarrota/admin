package com.manu.crud_generator.repositories;

import com.manu.crud_generator.entities.BPTransaction;
import com.manu.crud_generator.utils.repository.CustomCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BPTransactionRepository extends CustomCrudRepository<BPTransaction> {

}