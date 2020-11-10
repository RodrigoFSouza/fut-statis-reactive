package com.ferreira.rf.ligas.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Contato {
    @Id
    private String id;
    private TipoContato tipo;
    private String contato;
    private String nomeContato;
}
