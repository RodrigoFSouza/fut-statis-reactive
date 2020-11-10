package com.ferreira.rf.ligas.services;

import com.ferreira.rf.ligas.domain.Treinador;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ITreinador {
    Flux<Treinador> findAll();
    Mono<Treinador> findById(String id);
    Mono<Treinador> create(Treinador treinador);
    Mono<Treinador> update(Treinador treinador);
    Mono<Treinador> delete(String id);
}
