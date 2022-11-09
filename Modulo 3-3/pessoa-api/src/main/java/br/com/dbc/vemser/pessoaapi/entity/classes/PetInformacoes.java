package br.com.dbc.vemser.pessoaapi.entity.classes;

import br.com.dbc.vemser.pessoaapi.entity.enums.TipoPet;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PetInformacoes implements Serializable {

    @Schema(description = "nome do pet")
    @NotBlank(message = "O nome do pet é obrigatório")
    @NotEmpty(message = "O nome do pet é obrigatório")
    @Column(name = "nome")
    private String nome;

    @Schema(description = "Tipo do pet")
    @Enumerated(EnumType.ORDINAL)
    @NotNull(message = "O tipo do pet é obrigatório")
    @Column(name = "tipo")
    private TipoPet tipo;

}
