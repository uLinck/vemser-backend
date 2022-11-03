package br.com.dbc.vemser.pessoaapi.dto.lists;

import br.com.dbc.vemser.pessoaapi.dto.filme.FilmeAvaliadoDTO;
import br.com.dbc.vemser.pessoaapi.dto.pessoa.PessoaDTO;
import lombok.*;

import java.util.Set;
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ListPessoaFilmeDTO extends PessoaDTO {
   private Set<FilmeAvaliadoDTO> filmes;
}
