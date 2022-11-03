package br.com.dbc.vemser.pessoaapi.entity.enums;


public enum TipoFilme {
    TERROR(1),
    ANIMACAO(2),
    DRAMA(3),
    COMEDIA(4);

    private Integer tipo;
    TipoFilme(Integer tipo) {
        this.tipo = tipo;
    }
}
