package br.com.dbc.vemser.pessoaapilog.entity;

import br.com.dbc.vemser.pessoaapilog.enums.TipoLog;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//import javax.persistence.EnumType;
//import javax.persistence.Enumerated;

@Document(collection = "log")
@Getter
@Setter
public class LogEntity {

    @Id
    private String id;

    //@Enumerated(EnumType.STRING)
    private TipoLog tipoLog;

    private String descricao;

    private String data;

}
