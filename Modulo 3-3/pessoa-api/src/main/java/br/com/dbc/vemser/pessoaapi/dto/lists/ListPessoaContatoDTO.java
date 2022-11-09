package br.com.dbc.vemser.pessoaapi.dto.lists;

import br.com.dbc.vemser.pessoaapi.dto.contato.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.dto.pessoa.PessoaDTO;
import lombok.*;

import java.util.Set;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ListPessoaContatoDTO extends PessoaDTO {
   private Set<ContatoDTO> contatos;
}
