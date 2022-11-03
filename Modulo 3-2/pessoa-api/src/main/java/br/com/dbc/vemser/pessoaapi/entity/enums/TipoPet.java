package br.com.dbc.vemser.pessoaapi.entity.enums;

public enum TipoPet {
    CACHORRO(1),
    GATO(2),
    GUAXINIM(3);
    private Integer tipo;
    TipoPet(Integer tipo) {
        this.tipo = tipo;
    }
}
