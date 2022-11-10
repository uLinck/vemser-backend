package br.com.dbc.vemser.pessoaapi.dto.filme;

import br.com.dbc.vemser.pessoaapi.entity.pk.FilmePK;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class FilmeAvaliadoDTO {
    @NotNull
    private FilmePK filmePK;
    @NotNull
    private Integer notaPessoa;
    @NotNull
    private String descricao;
    @NotNull
    private LocalDate dtAssistido;
}
