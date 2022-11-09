package br.com.dbc.vemser.pessoaapi.dto.pessoa;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PessoaCreateDTO {

    @NotNull
    @NotBlank
    @Schema(description = "Nome da Pessoa")
    private String nome;
    @NotNull
    @Past
    @Schema(description = "Data de nascimento")
    private LocalDate dataNascimento;
    @CPF
    @Schema(description = "CPF da pessoa")
    private String cpf;
    @Email
    @NotBlank
    @Schema(description = "Email da pessoa")
    private String email;
}
