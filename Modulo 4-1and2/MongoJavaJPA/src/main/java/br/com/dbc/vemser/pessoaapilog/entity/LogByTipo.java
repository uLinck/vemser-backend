package br.com.dbc.vemser.pessoaapilog.entity;

import br.com.dbc.vemser.pessoaapilog.enums.TipoLog;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "log")
@Getter
@Setter
public class LogByTipo {

    @Id
    private TipoLog tipoLog;
    private Integer quantidade;

}
