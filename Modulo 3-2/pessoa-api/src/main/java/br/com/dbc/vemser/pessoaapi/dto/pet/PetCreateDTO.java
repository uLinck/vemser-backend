package br.com.dbc.vemser.pessoaapi.dto.pet;

import br.com.dbc.vemser.pessoaapi.entity.classes.PetInformacoes;
import br.com.dbc.vemser.pessoaapi.entity.enums.TipoPet;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embedded;
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

    @Schema(description = "id da pessoa")
    private Integer idPessoa;

    private PetInformacoesDTO petInformacoes;


}
