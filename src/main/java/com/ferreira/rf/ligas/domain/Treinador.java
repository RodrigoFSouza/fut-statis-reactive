package com.ferreira.rf.ligas.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document
public class Treinador {
    @Id
    private String id;
    private String nome;
}
