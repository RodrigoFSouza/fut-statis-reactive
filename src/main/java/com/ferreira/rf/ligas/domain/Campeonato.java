package com.ferreira.rf.ligas.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Campeonato {
    private String id;
    private String nome;
    private String descricao;
}