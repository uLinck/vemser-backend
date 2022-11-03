package br.com.dbc.vemser.pessoaapi.dto.contato;

import br.com.dbc.vemser.pessoaapi.entity.DescricaoEntity;
import br.com.dbc.vemser.pessoaapi.entity.enums.TipoContato;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.persistence.Embedded;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ContatoCreateDTO {
    @NotNull
    @Schema(description = "Tipo de contato")
    private TipoContato tipoContato;
    @NotNull
    @Size(max=13)
    @Schema(description = "Número do telefone")
    private String numero;
    @NotNull
    @NotBlank
    @Schema(description = "Descrição")
    @Embedded
    private DescricaoEntity descricao;

}
