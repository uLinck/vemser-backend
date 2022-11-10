package br.com.dbc.vemser.pessoaapi.dto.pessoa;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PessoaReportDTO {
    private Integer idPessoa;
    private String nome;
    private String email;
    private String numero;
    private String cep;
    private String cidade;
    private String estado;
    private String pais;
    private String petNome;
    private String descricaoFilme;
    private String descricaoPessoa;
    private LocalDate dtAssistido;
    private Integer notaPessoa;
    private Integer notaFilme;

}
