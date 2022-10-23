package br.com.dbc.vemser.pessoaapi.dto;

import br.com.dbc.vemser.pessoaapi.entity.TipoEndereco;
import lombok.Data;;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class EnderecoCreateDTO {

    private Integer idPessoa;
    @NotNull(message = "O tipo do endereço não pode ser nulo!")
    private TipoEndereco tipo;
    @NotBlank
    @Size(max=250, message = "O campo de logradouro não pode ter mais de 250 caracteres!")
    private String logradouro;
    @NotNull(message = "O campo de número não poder estar nulo")
    private Integer numero;
    @NotBlank
    private String complemento;
    @NotBlank(message = "O campo de CEP não pode estar nulo!")
    @Size(max=8, message = "O campo de CEP não pode ter mais que 8 caracteres!")
    private String cep;
    @NotBlank(message = "O campo de Cidade não pode ser nulo!")
    @Size(max=250, message = "O campo de Cidade não pode conter mais que 250 caracteres!")
    private String cidade;
    @NotNull(message = "O campo de Estado não pode estar nulo!")
    private String estado;
    @NotNull(message = "O campo de País não pode estar nulo!")
    private String pais;

}
