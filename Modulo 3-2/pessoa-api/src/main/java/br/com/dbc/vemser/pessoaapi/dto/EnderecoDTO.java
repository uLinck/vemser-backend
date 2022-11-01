package br.com.dbc.vemser.pessoaapi.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class EnderecoDTO extends EnderecoCreateDTO {

    @NotEmpty
    @Schema(description = "id do endereço")
    private Integer idEndereco;

}
