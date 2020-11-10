package com.ferreira.rf.ligas.services;

import com.ferreira.rf.ligas.domain.Treinador;
import com.ferreira.rf.ligas.infra.repository.TreinadorRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TreinadorService implements ITreinador {

    private TreinadorRepository treinadorRepository;

    public TreinadorService(TreinadorRepository treinadorRepository) {
        this.treinadorRepository = treinadorRepository;
    }

    @Override
    public Flux<Treinador> findAll() {

        return treinadorRepository.findAll();
    }

    @Override
    public Mono<Treinador> findById(String id) {
        return treinadorRepository.findById(id);
    }

    @Override
    public Mono<Treinador> create(Treinador treinador) {
        return treinadorRepository.save(treinador);
    }

    @Override
    public Mono<Treinador> update(Treinador treinador) {
        return treinadorRepository
                .findById(treinador.getId())
                .map(t -> Treinador.builder().id(t.getId()).nome(t.getNome()).build())
                .flatMap(treinadorRepository::save);
    }

    @Override
    public Mono<Treinador> delete(String id) {
        return treinadorRepository
                .findById(id)
                .flatMap(t -> treinadorRepository.deleteById(id).thenReturn(t));
    }
}
