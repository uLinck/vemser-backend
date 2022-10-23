package br.com.dbc.vemser.pessoaapi.entity;

import lombok.*;
import org.apache.commons.lang3.builder.ToStringExclude;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Endereco {
    @ToStringExclude
    @NotEmpty
    private Integer idEndereco, idPessoa;
    @NotNull
    private TipoEndereco tipo;
    @NotBlank
    @Size(max=250)
    private String logradouro;
    @NotNull
    private Integer numero;
    @NotBlank
    private String complemento;
    @NotNull
    @NotBlank
    @Size(max=8)
    private String cep;
    @NotNull
    @NotBlank
    @Size(max=250)
    private String cidade;
    @NotNull
    private String estado;
    @NotNull
    private String pais;
}
