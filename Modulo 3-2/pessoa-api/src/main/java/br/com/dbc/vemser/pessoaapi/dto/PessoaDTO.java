package br.com.dbc.vemser.pessoaapi.dto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class PessoaDTO extends PessoaCreateDTO {

    @NotEmpty
    @Schema(description = "Id da pessoa")
    private Integer idPessoa;

}
