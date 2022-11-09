package br.com.dbc.vemser.pessoaapi.dto.endereco;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoDTO extends EnderecoCreateDTO {

    @NotEmpty
    @Schema(description = "id do endereço")
    private Integer idEndereco;

}
