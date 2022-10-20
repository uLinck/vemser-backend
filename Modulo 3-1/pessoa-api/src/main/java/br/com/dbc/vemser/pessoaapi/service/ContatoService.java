package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.repository.ContatoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContatoService {

    private ContatoRepository contatoRepository;

    public ContatoService(ContatoRepository contatoRepository){
        this.contatoRepository = contatoRepository;
    }

    public Contato create(Integer idPessoa, Contato contato){
        return contatoRepository.create(idPessoa, contato);
    }

    public List<Contato> list(){
        return contatoRepository.list();
    }

    public Contato update(Integer idContato, Contato contatoAtualizar) throws Exception {
        return contatoRepository.update(idContato, contatoAtualizar);
    }

    public void delete(Integer idContato) throws Exception {
        contatoRepository.delete(idContato);
    }

    public List<Contato> listByIdPessoa(Integer idPessoa) {
        return contatoRepository.listByIdPessoa(idPessoa);
    }

}
