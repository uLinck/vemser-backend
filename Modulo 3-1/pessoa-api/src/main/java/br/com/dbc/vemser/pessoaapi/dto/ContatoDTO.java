package br.com.dbc.vemser.pessoaapi.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ContatoDTO extends ContatoCreateDTO {

    @NotNull
    private Integer idContato;
}
