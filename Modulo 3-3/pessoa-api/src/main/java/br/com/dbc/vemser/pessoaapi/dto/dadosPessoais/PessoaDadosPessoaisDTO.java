package br.com.dbc.vemser.pessoaapi.dto.dadosPessoais;

import br.com.dbc.vemser.pessoaapi.dto.pessoa.Sexo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PessoaDadosPessoaisDTO{


    @NotEmpty
    @NotBlank
    @Schema(description = "Nome da pessoa")
    private String nome;

    @NotEmpty
    @NotBlank
    @Schema(description = "CPF da pessoa", example = "12345678901")
    private String cpf;

    @NotEmpty
    @NotBlank
    @Schema(description = "CNH da pessoa")
    private String cnh;

    @NotEmpty
    @NotBlank
    @Schema(description = "Nome da mãe da pessoa")
    private String nomeMae;

    @NotEmpty
    @NotBlank
    @Schema(description = "Nome do Pai da pessoa")
    private String nomePai;

    @NotEmpty
    @NotBlank
    @Schema(description = "RG da pessoa", example = "12345678901")
    private String rg;

    @NotNull
    @Schema(description = "Sexo da pessoa", example = "M")
    private Sexo sexo;

    @NotEmpty
    @NotBlank
    @Schema(description = "Titulo de eleitor", example = "12345678901")
    private String tituloEleitor;

    @NotEmpty
    @NotBlank
    @Schema(description = "Email da pessoa", example = "pessoa@gmail.com")
    private String email;

    @NotNull(message = "Informe a data de nascimento")
    @Past(message = "a data deve estar no passado")
    @Schema(description = "Data de nascimento da pessoa")
    private LocalDate dataNascimento;

}
