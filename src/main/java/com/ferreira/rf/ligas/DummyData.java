package com.ferreira.rf.ligas;

import com.ferreira.rf.ligas.domain.Treinador;
import com.ferreira.rf.ligas.infra.repository.TreinadorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.UUID;

@Component
public class DummyData implements CommandLineRunner {

    private final TreinadorRepository treinadorRepository;

    public DummyData(TreinadorRepository treinadorRepository) {
        this.treinadorRepository = treinadorRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        treinadorRepository.deleteAll()
                .thenMany(
                        Flux.just("Mourinho", "Jorge Jesus", "Vanderley Luxemburgo", "Pepe Guardiola", "Abel Ferreira")
                        .map(nome -> Treinador.builder().id(UUID.randomUUID().toString()).nome(nome).build())
                        .flatMap(treinadorRepository::save)
                ).subscribe(System.out::println);
    }
}
