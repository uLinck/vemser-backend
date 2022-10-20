package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.entity.TipoEndereco;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class EnderecoRepository {

    private static List<Endereco> listaEnderecos = new ArrayList<>();

    private AtomicInteger COUNTER = new AtomicInteger();

    public EnderecoRepository() {
    listaEnderecos.add(new Endereco(COUNTER.incrementAndGet(), 1, TipoEndereco.COMERCIAL, "Bloco B", 356, "Casa", "94175-460", "Gravataí", "RS", "Brasil" ));
    listaEnderecos.add(new Endereco(COUNTER.incrementAndGet() /*2*/,2, TipoEndereco.RESIDENCIAL, "Rua Amazonas", 212, "Campo", "99705-244", "Gravataí", "Rio grande do Sul", "Brasil"));
    listaEnderecos.add(new Endereco(COUNTER.incrementAndGet() /*3*/,3, TipoEndereco.COMERCIAL, "Rua Rio de Janeiro", 221, "Campo", "12280-238", "Canoas", "Rio grande do Sul", "Brasil"));
    listaEnderecos.add(new Endereco(COUNTER.incrementAndGet() /*4*/,4, TipoEndereco.RESIDENCIAL, "Rua Minas Gerais", 345, "Campo", "66033-810", "Cachoeirinha", "Rio grande do Sul", "Brasil"));
    listaEnderecos.add(new Endereco(COUNTER.incrementAndGet(), 5, TipoEndereco.COMERCIAL, "Rua Santa Catarina", 46, "Campo", "79002-165", "Porto Alegre", "Rio grande do Sul", "Brasil"));
    }

    public Endereco create(Integer idPessoa, Endereco endereco) {

    endereco.setIdEndereco(COUNTER.incrementAndGet());
    endereco.setIdPessoa(idPessoa);
    listaEnderecos.add(endereco);
    return endereco;
    }

    public List<Endereco> list() {
        return listaEnderecos;
}
    public void delete(Integer idEndereco) {
    listaEnderecos.remove(idEndereco);
    }
}
