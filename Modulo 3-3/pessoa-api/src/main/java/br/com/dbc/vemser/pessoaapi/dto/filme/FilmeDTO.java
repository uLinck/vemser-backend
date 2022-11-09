package br.com.dbc.vemser.pessoaapi.dto.filme;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FilmeDTO extends FilmeCreateDTO{
    @NotEmpty
    @NotNull
    @Schema(description = "id do filme")
    private int idFilme;

}
