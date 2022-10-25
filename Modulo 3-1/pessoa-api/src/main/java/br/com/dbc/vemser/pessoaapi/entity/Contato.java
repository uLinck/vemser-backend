package br.com.dbc.vemser.pessoaapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Contato {

    private Integer idContato;
    private Integer idPessoa;
    private TipoContato tipoContato;
    private String numero;
    private String descricao;



}
