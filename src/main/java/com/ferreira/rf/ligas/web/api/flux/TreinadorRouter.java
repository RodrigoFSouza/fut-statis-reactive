package com.ferreira.rf.ligas.web.api.flux;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

// @Configuration
public class TreinadorRouter {

    //@Bean
    public RouterFunction<ServerResponse> route(TreinadorHandler handler) {
        return RouterFunctions
                .route(GET("/treinador").and(accept(MediaType.APPLICATION_JSON)), handler::findAll)
                .andRoute(GET("/treinador/{id}").and(accept(MediaType.APPLICATION_JSON)), handler::findById)
                .andRoute(POST("/treinador/{id}").and(accept(MediaType.APPLICATION_JSON)), handler::create);
    }
}
