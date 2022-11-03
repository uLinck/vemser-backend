package br.com.dbc.vemser.pessoaapi.dto.lists;

import br.com.dbc.vemser.pessoaapi.dto.pessoa.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.entity.classes.ContatoEntity;
import lombok.*;

import java.util.Set;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ListPessoaContatoDTO extends PessoaDTO {
   private Set<ContatoEntity> contatos;
}
