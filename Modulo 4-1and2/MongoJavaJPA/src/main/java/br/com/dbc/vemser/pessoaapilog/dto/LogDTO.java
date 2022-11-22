package br.com.dbc.vemser.pessoaapilog.dto;

import br.com.dbc.vemser.pessoaapilog.enums.TipoLog;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogDTO {

    private String id;

    //@Enumerated(EnumType.STRING)
    private TipoLog tipoLog;

    private String descricao;

    private String data;

}
