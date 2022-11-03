package br.com.dbc.vemser.pessoaapi.dto.pessoa;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PessoaDTO extends PessoaCreateDTO {

    @NotEmpty
    @Schema(description = "Id da pessoa")
    private Integer idPessoa;

}
