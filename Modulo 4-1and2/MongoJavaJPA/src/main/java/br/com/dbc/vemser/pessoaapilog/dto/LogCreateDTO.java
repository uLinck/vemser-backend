package br.com.dbc.vemser.pessoaapilog.dto;

import br.com.dbc.vemser.pessoaapilog.enums.TipoLog;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogCreateDTO {

    //@Enumerated(EnumType.STRING)
    private TipoLog tipoLog;
    private String descricao;

}
