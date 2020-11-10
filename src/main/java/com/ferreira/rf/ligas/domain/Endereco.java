package com.ferreira.rf.ligas.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Endereco {
    @Id
    private String id;
    private String cep;
    private String logradouro;
    private String bairro;
    private String cidade;
    private String pais;
    private String numero;
    private String complmento;
}
