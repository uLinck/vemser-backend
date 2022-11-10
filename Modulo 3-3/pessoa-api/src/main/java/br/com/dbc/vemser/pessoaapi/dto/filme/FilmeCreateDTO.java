package br.com.dbc.vemser.pessoaapi.dto.filme;

import br.com.dbc.vemser.pessoaapi.entity.enums.TipoFilme;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class FilmeCreateDTO {

    @NotBlank
    @Schema(description = "descrição")
    private String descricao;
    @NotNull
    @Schema(description = "nota")
    private int nota;
    @NotNull
    @Schema(description = "tipo do filme")
    private TipoFilme tipoFilme;
}
