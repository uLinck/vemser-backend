package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.service.EnderecoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enderecos") // localhost:8080/enderecos
public class EnderecoController {

    private EnderecoService enderecoService;

    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @GetMapping() // retorna todos os endereços
    public List<Endereco> list() {
        return enderecoService.list();
    }

    @GetMapping("/{idEndereco}")
    public Endereco listByIdEndereco(@PathVariable("idEndereco") Integer idEndereco) throws Exception {
        return enderecoService.listByIdEndereco(idEndereco);
    }

    @GetMapping("/pessoa/{idPessoa}")
    public List<Endereco> listByIdPessoa(@PathVariable("idPessoa") Integer idPessoa) throws Exception {
        return enderecoService.listByIdPessoa(idPessoa);
    }

    @PostMapping("/{idPessoa}")
    public Endereco create (@PathVariable("idPessoa") Integer idPessoa,
                            @RequestBody Endereco endereco) {
        return enderecoService.create(idPessoa, endereco);
    }

    @PutMapping("/{idEndereco}")
    public Endereco update(@PathVariable("idEndereco") Integer idEndereco,
                           @RequestBody Endereco enderecoAtualizar) throws Exception {
        return enderecoService.update(idEndereco, enderecoAtualizar);
    }

    @DeleteMapping("/{idEndereco}")
    public void delete(@PathVariable("idEndereco") Integer id) throws Exception {
        enderecoService.delete(id);
    }

}
