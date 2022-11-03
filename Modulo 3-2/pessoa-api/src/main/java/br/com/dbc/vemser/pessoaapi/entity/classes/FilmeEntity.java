package br.com.dbc.vemser.pessoaapi.entity.classes;

import br.com.dbc.vemser.pessoaapi.entity.DescricaoEntity;
import br.com.dbc.vemser.pessoaapi.entity.enums.TipoFilme;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity(name = "Filme")
public class FilmeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FILME_SEQ")
    @SequenceGenerator(name = "FILME_SEQ", sequenceName = "seq_filme", allocationSize = 1)
    @Column(name = "id_filme")
    private int idFilme;
    @Embedded
    @Column(name = "descricao")
    private DescricaoEntity descricao;
    @Column(name = "nota")
    private int nota;
    @Column(name = "tipo")
    @Enumerated(EnumType.ORDINAL)
    private TipoFilme tipoFilme;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "filme")
    private Set<PessoaFilmeEntity> filme;

}
