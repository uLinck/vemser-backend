package br.com.dbc.vemser.pessoaapi.dto.pet;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PetCreateDTO {

    @Schema(description = "id da pessoa")
    private Integer idPessoa;

    private PetInformacoesDTO petInformacoes;


}
