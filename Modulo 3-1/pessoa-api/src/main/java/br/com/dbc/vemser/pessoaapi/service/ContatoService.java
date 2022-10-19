package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.repository.ContatoRepository;

import java.util.List;

public class ContatoService {

    private ContatoRepository contatoRepository;

    public ContatoService(){
        contatoRepository = new ContatoRepository();
    }

    public Contato create(Integer idPessoa, Contato contato){
        return contatoRepository.create(idPessoa, contato);
    }

    public List<Contato> list(){
        return contatoRepository.list();
    }

    public Contato update(Integer idContato,
                          Contato contatoAtualizar) throws Exception {
        return contatoRepository.update(idContato, contatoAtualizar);
    }

    public void delete(Integer idContato) throws Exception {
        contatoRepository.delete(idContato);
    }

    public List<Contato> listByIdPessoa(Integer idPessoa) {
        return contatoRepository.listByIdPessoa(idPessoa);
    }

}
