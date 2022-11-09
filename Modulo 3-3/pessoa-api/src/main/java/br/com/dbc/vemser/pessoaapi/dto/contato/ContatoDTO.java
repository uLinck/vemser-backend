package br.com.dbc.vemser.pessoaapi.dto.contato;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ContatoDTO extends ContatoCreateDTO {

    @NotNull
    @Schema(description = "id do contato")
    private Integer idContato;
    @NotNull
    @Schema(description = "id da pessoa")
    private Integer IdPessoa;
}
