package br.com.dbc.vemser.pessoaapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.*;
import java.time.LocalDate;
@Data
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
    private String cpf;
    @Email
    @NotBlank
    private String email;
}
