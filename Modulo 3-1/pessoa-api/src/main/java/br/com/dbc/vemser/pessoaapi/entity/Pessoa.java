package br.com.dbc.vemser.pessoaapi.entity;

import lombok.*;
import org.apache.commons.lang3.builder.ToStringExclude;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@NoArgsConstructor
@Data
public class Pessoa {

    @ToStringExclude
    private Integer idPessoa;
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


    public Pessoa(Integer idPessoa, String nome, LocalDate dataNascimento, String cpf) {
        this.idPessoa = idPessoa;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
    }


}
