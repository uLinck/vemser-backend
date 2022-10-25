package br.com.dbc.vemser.pessoaapi.dto;

import lombok.Data;

import javax.validation.constraints.*;
import java.time.LocalDate;
@Data
public class PessoaCreateDTO {

    @NotNull
    @NotBlank
    private String nome;
    @NotNull
    @Past
    private LocalDate dataNascimento;
    @NotNull
    @NotBlank
    @Size(min=11, max=11)
    private String cpf;
    @Email
    @NotBlank
    private String email;
}
