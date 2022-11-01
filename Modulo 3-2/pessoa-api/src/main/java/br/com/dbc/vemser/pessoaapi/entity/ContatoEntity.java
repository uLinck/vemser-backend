package br.com.dbc.vemser.pessoaapi.entity;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "CONTATO")
public class ContatoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CONTATO_SEQ")
    @SequenceGenerator(name = "CONTATO_SEQ", sequenceName = "seq_contato", allocationSize = 1)

    @Column(name = "id_contato")
    private Integer idContato;


    @Column(name = "tipo")
    private TipoContato tipoContato; //RESIDENCIAL(1)

    @Column(name = "numero")
    private String numero;

    @Column(name = "descricao")
    private String descricao;
}
