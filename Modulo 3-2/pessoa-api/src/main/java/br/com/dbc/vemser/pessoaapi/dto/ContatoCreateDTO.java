package br.com.dbc.vemser.pessoaapi.dto;

import br.com.dbc.vemser.pessoaapi.entity.TipoContato;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
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
    private String descricao;
    @NotNull
    @Schema(description = "id da pessoa")
    private Integer idPessoa;

}
