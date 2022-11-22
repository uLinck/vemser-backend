package br.com.dbc.vemser.pessoaapilog.dto;

import br.com.dbc.vemser.pessoaapilog.enums.TipoLog;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LogDTOContador {

    private TipoLog tipoLog;
    private Integer quantidade;

}
