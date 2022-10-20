package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnderecoService {

    private EnderecoRepository enderecoRepository;

    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    public List<Endereco> list() {
        return enderecoRepository.list();
    }

    public Endereco listByIdEndereco(Integer id) throws Exception {
        return enderecoRepository.list().stream()
                .filter(endereco -> endereco.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Não encontrado"));
    }

    public List<Endereco> listByIdPessoa(Integer idPessoa) {
        return enderecoRepository.list().stream()
                .filter(endereco -> endereco.getIdPessoa().equals(idPessoa))
                .collect(Collectors.toList());
    }



    public Endereco create(Integer idPessoa, Endereco endereco) {
        return enderecoRepository.create(idPessoa, endereco);
    }

    public Endereco update(Integer idEndereco, Endereco enderecoAtualizar) throws Exception {
        Endereco enderecoRecuperado = enderecoRepository.list().stream()
                .filter(endereco -> endereco.getIdEndereco().equals(idEndereco))
                .findFirst()
                .orElseThrow(() -> new Exception("Endereco não encontrado"));
        enderecoRecuperado.setIdPessoa(enderecoAtualizar.getIdPessoa());
        enderecoRecuperado.setIdEndereco(enderecoAtualizar.getIdEndereco());
        enderecoRecuperado.setTipo(enderecoAtualizar.getTipo());
        enderecoRecuperado.setCep(enderecoAtualizar.getCep());
        enderecoRecuperado.setCidade(enderecoAtualizar.getCidade());
        enderecoRecuperado.setComplemento(enderecoAtualizar.getComplemento());
        enderecoRecuperado.setEstado(enderecoAtualizar.getEstado());
        enderecoRecuperado.setPais(enderecoAtualizar.getPais());
        enderecoRecuperado.setLogradouro(enderecoAtualizar.getLogradouro());
        enderecoRecuperado.setNumero(enderecoAtualizar.getNumero());
        return enderecoRecuperado;
    }

    public void delete(Integer idEndereco) throws Exception {
        enderecoRepository.delete(idEndereco);
    }
}


