package br.com.dbc.vemser.pessoaapi.entity.classes;

import br.com.dbc.vemser.pessoaapi.entity.enums.TipoPet;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity(name = "PET")
public class PetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PET_SEQ")
    @SequenceGenerator(name = "PET_SEQ", sequenceName = "SEQ_PET", allocationSize = 1)
    @Column(name = "id_pet")
    private Integer idPet;

    @Column(name = "id_pessoa", insertable = false, updatable = false)
    private Integer idPessoa;

    @Column(name = "nome")
    private String nome;

    @Column(name = "tipo")
    @Enumerated(EnumType.ORDINAL)
    private TipoPet tipo;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_pessoa", referencedColumnName = "id_pessoa")
    private PessoaEntity pessoa;
}