package com.ferreira.rf.ligas.web.api;

import com.ferreira.rf.ligas.domain.Treinador;
import com.ferreira.rf.ligas.services.TreinadorService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.sql.SQLOutput;
import java.time.Duration;

@RestController
@RequestMapping("/api/treinadores")
public class TreinadorResource {

    private TreinadorService treinadorService;

    public TreinadorResource(TreinadorService treinadorService) {
        this.treinadorService = treinadorService;
    }

    @GetMapping
    public Flux<Treinador> getTreinadores() {
        return treinadorService.findAll();
    }

    @GetMapping("{id}")
    public Mono<Treinador> getTreinador(@PathVariable String id) {
        return treinadorService.findById(id);
    }

    @GetMapping(value = "/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Tuple2<Long, Treinador>> getTreinadoresByEvents() {
        Flux<Long> interval = Flux.interval(Duration.ofSeconds(10));
        Flux<Treinador> events = treinadorService.findAll();
        System.out.println("Gerou novo Evento");
        return Flux.zip(interval, events);

    }

    @PostMapping
    public Mono<Treinador> createTreinador(@RequestBody Treinador treinador) {
        return treinadorService.create(treinador);
    }

    @PutMapping
    public Mono<Treinador> updateTreinador(@RequestBody Treinador treinador) {
        return treinadorService.update(treinador);
    }

    @DeleteMapping("{id}")
    public Mono<Treinador> deleteTreinador(@PathVariable String id) {
        return treinadorService.delete(id);
    }
}
