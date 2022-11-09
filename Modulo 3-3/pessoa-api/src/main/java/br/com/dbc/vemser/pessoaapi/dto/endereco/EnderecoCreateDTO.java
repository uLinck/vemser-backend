package br.com.dbc.vemser.pessoaapi.dto.endereco;

import br.com.dbc.vemser.pessoaapi.entity.enums.TipoEndereco;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoCreateDTO {
    @JsonIgnore
    @Schema(description = "id da pessoa")
    private Integer idPessoa;
    @NotNull(message = "O tipo do endereço não pode ser nulo!")
    @Schema(description = "Tipo do endereço")
    private TipoEndereco tipo;
    @NotBlank
    @Size(max=250, message = "O campo de logradouro não pode ter mais de 250 caracteres!")
    @Schema(description = "Logradouro")
    private String logradouro;
    @NotNull(message = "O campo de número não poder estar nulo")
    @Schema(description = "Número do endereço")
    private Integer numero;
    @NotBlank
    @Schema(description = "Complemento")
    private String complemento;
    @NotBlank(message = "O campo de CEP não pode estar nulo!")
    @Size(max=8, message = "O campo de CEP não pode ter mais que 8 caracteres!")
    @Schema(description = "CEP")
    private String cep;
    @NotBlank(message = "O campo de Cidade não pode ser nulo!")
    @Size(max=250, message = "O campo de Cidade não pode conter mais que 250 caracteres!")
    @Schema(description = "Cidade")
    private String cidade;
    @NotNull(message = "O campo de Estado não pode estar nulo!")
    @Schema(description = "Estado")
    private String estado;
    @NotNull(message = "O campo de País não pode estar nulo!")
    @Schema(description = "Pais")
    private String pais;

}
