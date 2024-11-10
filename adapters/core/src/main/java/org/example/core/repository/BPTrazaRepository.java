package org.example.core.repository;

import org.example.core.domain.BPTraza;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BPTrazaRepository extends CrudRepository<BPTraza, Long> {
}
