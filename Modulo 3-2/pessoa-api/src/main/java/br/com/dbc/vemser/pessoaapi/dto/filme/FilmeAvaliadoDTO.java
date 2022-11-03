package br.com.dbc.vemser.pessoaapi.dto.filme;

import br.com.dbc.vemser.pessoaapi.entity.DescricaoEntity;
import br.com.dbc.vemser.pessoaapi.entity.pk.FilmePK;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.validation.constraints.NotBlank;
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
    @Embedded
    private DescricaoEntity descricao;
    @NotNull
    private LocalDate dtAssistido;
}
