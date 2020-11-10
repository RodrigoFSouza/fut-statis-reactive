package com.ferreira.rf.ligas.infra.repository;

import com.ferreira.rf.ligas.domain.Treinador;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreinadorRepository extends ReactiveMongoRepository<Treinador, String> {
}
