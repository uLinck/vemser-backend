package br.com.dbc.vemser.pessoaapi.dto.pet;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PetDTO extends PetCreateDTO {
    @Schema(description = "id do pet")
    private Integer idPet;
}
