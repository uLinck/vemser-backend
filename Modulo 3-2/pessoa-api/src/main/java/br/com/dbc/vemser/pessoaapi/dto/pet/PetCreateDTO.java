package br.com.dbc.vemser.pessoaapi.dto.pet;

import br.com.dbc.vemser.pessoaapi.entity.enums.TipoPet;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PetCreateDTO {

    @Schema(description = "nome do pet")
    @NotBlank(message = "O nome do pet é obrigatório")
    @NotEmpty(message = "O nome do pet é obrigatório")
    private String nome;

    @Schema(description = "Tipo do pet")
    @Enumerated(EnumType.ORDINAL)
    @NotNull(message = "O tipo do pet é obrigatório")
    private TipoPet tipo;

    @Schema(description = "id da pessoa")
    private Integer idPessoa;


}
