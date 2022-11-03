package br.com.dbc.vemser.pessoaapi.entity.pk;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FilmePK implements Serializable {

    @Column(name = "id_filme")
    private Integer idFilme;
    @JsonIgnore
    @Column(name = "id_pessoa")
    private Integer idPessoa;
}
