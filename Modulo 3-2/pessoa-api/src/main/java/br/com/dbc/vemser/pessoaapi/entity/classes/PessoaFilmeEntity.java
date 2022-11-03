package br.com.dbc.vemser.pessoaapi.entity.classes;

import br.com.dbc.vemser.pessoaapi.entity.DescricaoEntity;
import br.com.dbc.vemser.pessoaapi.entity.pk.FilmePK;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "pessoa_x_filme")
public class PessoaFilmeEntity {

    @EmbeddedId
    private FilmePK filmePK;

    @Column(name = "dt_assistido")
    private LocalDate dtAssistido;
    @Embedded
    @Column(name = "descricao")
    private DescricaoEntity descricao;
    @Column(name = "nota_pessoa")
    private int notaPessoa;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idPessoa")
    @JoinColumn(name = "id_pessoa")
    private PessoaEntity pessoa;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idFilme")
    @JoinColumn(name = "id_filme")
    private FilmeEntity filme;
}
