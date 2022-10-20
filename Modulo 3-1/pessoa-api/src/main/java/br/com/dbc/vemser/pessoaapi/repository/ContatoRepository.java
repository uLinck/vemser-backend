package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.entity.TipoContato;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class ContatoRepository {

    private static List<Contato> listaContatos = new ArrayList<>();

    private AtomicInteger COUNTER = new AtomicInteger();

    public ContatoRepository() {
        listaContatos.add(new Contato(COUNTER.incrementAndGet(), 1, TipoContato.COMERCIAL, "51995505706", "estou aprendendo"));

    }

    public Contato create(Integer idPessoa, Contato contato) {

        contato.setIdContato(COUNTER.incrementAndGet());
        contato.setIdPessoa(idPessoa);
        listaContatos.add(contato);
        return contato;
    }

    public List<Contato> list() {
        return listaContatos;
    }

    public Contato update(Integer id,
                          Contato contatoAtualizar) throws Exception {
        Contato contatoRecuperada = listaContatos.stream()
                .filter(contato -> contato.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Contato não encontrado"));
        contatoRecuperada.setTipoContato(contatoAtualizar.getTipoContato());
        contatoRecuperada.setNumero(contatoAtualizar.getNumero());
        contatoRecuperada.setDescricao(contatoAtualizar.getDescricao());
        return contatoRecuperada;

    }

    public void delete(Integer idContato) throws Exception {
        Contato contatoRecuperado = listaContatos.stream()
                .filter(contato -> contato.getIdContato().equals(idContato))
                .findFirst()
                .orElseThrow(() -> new Exception("Contato não encontrado"));
        listaContatos.remove(contatoRecuperado);
    }

    public List<Contato> listByIdPessoa(Integer idPessoa) {
        return listaContatos.stream()
                .filter(contato -> contato.getIdPessoa().equals(idPessoa))
                .collect(Collectors.toList());
    }

}