package com.ferreira.rf.ligas.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;

@Data
@Document
public class Jogador {
    @Id
    private String id;
    private String nome;
    private BigInteger idade;

}
