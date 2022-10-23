package br.com.dbc.vemser.pessoaapi.dto;

import br.com.dbc.vemser.pessoaapi.entity.TipoContato;
import lombok.Data;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class ContatoCreateDTO {
    @NotNull
    private Integer idPessoa;
    @NotNull
    private TipoContato tipoContato;
    @NotNull
    @Size(max=13)
    private String numero;
    @NotNull
    @NotBlank
    private String descricao;

}
