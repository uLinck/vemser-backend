package br.com.dbc.vemser.pessoaapi.dto;


import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class EnderecoDTO extends EnderecoCreateDTO {

    @NotEmpty
    private Integer idEndereco;

}
