package com.ferreira.rf.ligas.web.api.flux;

import com.ferreira.rf.ligas.domain.Treinador;
import com.ferreira.rf.ligas.services.TreinadorService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;


import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

// @Component
public class TreinadorHandler {
    private TreinadorService treinadorService;

    public TreinadorHandler(TreinadorService treinadorService) {
        this.treinadorService = treinadorService;
    }

    public Mono<ServerResponse> findAll(ServerRequest request) {
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(treinadorService.findAll(), Treinador.class);
    }

    public Mono<ServerResponse> findById(ServerRequest request) {
        String id = request.pathVariable("id");

        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(treinadorService.findById(id), Treinador.class);
    }

    public Mono<ServerResponse> create(ServerRequest request) {
        final Mono<Treinador> treinador = request.bodyToMono(Treinador.class);

        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(fromPublisher(treinador.flatMap(treinadorService::create), Treinador.class));
    }
}
