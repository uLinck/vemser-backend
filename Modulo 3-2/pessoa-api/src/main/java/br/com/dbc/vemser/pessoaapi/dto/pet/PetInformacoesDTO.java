package br.com.dbc.vemser.pessoaapi.dto.pet;

import br.com.dbc.vemser.pessoaapi.entity.enums.TipoPet;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PetInformacoesDTO {

    private String nome;

    private TipoPet tipo;

}
