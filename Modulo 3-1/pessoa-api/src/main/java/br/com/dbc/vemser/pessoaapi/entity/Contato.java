package br.com.dbc.vemser.pessoaapi.entity;

import lombok.*;
import org.apache.commons.lang3.builder.ToStringExclude;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Contato {
    @NotNull
    @ToStringExclude
    private Integer idContato;
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
