package com.ferreira.rf.ligas.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Selecao {
    @Id
    private String id;
    private String nome;
}
