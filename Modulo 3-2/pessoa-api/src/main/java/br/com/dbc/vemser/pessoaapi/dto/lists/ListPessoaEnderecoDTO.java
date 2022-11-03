package br.com.dbc.vemser.pessoaapi.dto.lists;

import br.com.dbc.vemser.pessoaapi.dto.endereco.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.dto.pessoa.PessoaCreateDTO;
import lombok.*;

import java.util.List;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ListPessoaEnderecoDTO extends PessoaCreateDTO {
  private List<EnderecoDTO> enderecos;
}
