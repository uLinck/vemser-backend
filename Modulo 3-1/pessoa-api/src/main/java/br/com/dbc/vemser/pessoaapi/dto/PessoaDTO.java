package br.com.dbc.vemser.pessoaapi.dto;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class PessoaDTO extends PessoaCreateDTO {

    @NotEmpty
    private Integer idPessoa;

}
