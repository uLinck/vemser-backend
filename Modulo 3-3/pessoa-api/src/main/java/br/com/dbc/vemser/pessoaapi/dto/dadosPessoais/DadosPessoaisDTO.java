package br.com.dbc.vemser.pessoaapi.dto.dadosPessoais;

import br.com.dbc.vemser.pessoaapi.dto.pessoa.Sexo;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DadosPessoaisDTO {

    private String cnh;
    private String cpf;
    private String nome;
    private String nomeMae;
    private String nomePai;
    private String rg;
    private Sexo sexo;
    private String tituloEleitor;
}

