package com.ferreira.rf.ligas.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Clube {
    @Id
    private String id;
    private String nome;
    private Integer fundacao;
    private Endereco endereco;
    private Contato contato;
}
