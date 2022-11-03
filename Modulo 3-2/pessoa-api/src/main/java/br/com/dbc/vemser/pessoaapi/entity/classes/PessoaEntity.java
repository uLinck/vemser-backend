package br.com.dbc.vemser.pessoaapi.entity.classes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity(name = "pessoa")
public class PessoaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PESSOA_SEQ")
    @SequenceGenerator(name = "PESSOA_SEQ", sequenceName = "seq_pessoa2", allocationSize = 1)
    @Column(name = "id_pessoa")
    private Integer idPessoa;

    @Column(name = "nome")
    private String nome;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "email")
    private String email;

    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "pessoa",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<ContatoEntity> contatos;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "Pessoa_x_Pessoa_Endereco",
            joinColumns = @JoinColumn(name = "id_pessoa"),
            inverseJoinColumns = @JoinColumn(name = "id_endereco"))
    private Set<EnderecoEntity> enderecos;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pessoa")
    private Set<PessoaFilmeEntity> filmes;

    @JsonIgnore
    @OneToMany(mappedBy = "pessoa", fetch = FetchType.LAZY)
    private Set<PetEntity> pet;
}
