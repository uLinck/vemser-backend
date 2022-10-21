package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.service.EnderecoService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/enderecos") // localhost:8080/enderecos
@Validated
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
    public Endereco listByIdEndereco(@PathVariable("idEndereco") Integer idEndereco) throws RegraDeNegocioException {
        return enderecoService.listByIdEndereco(idEndereco);
    }

    @GetMapping("/{idPessoa}/pessoa")
    public List<Endereco> listByIdPessoa(@PathVariable("idPessoa") Integer idPessoa) {
        return enderecoService.listByIdPessoa(idPessoa);
    }

    @PostMapping("/{idPessoa}")
    public Endereco create (@Valid @PathVariable("idPessoa") Integer idPessoa,
                            @Valid @RequestBody Endereco endereco) throws RegraDeNegocioException {

            if (enderecoService.verifyPessoa(idPessoa)) {
                return enderecoService.create(idPessoa, endereco);
            } else {
                throw new RegraDeNegocioException("Pessoa não encontrada");
            }
    }

    @PutMapping("/{idEndereco}")
    public Endereco update(@Valid @PathVariable("idEndereco") Integer idEndereco,
                           @Valid @RequestBody Endereco enderecoAtualizar) throws RegraDeNegocioException {
        return enderecoService.update(idEndereco, enderecoAtualizar);
    }

    @DeleteMapping("/{idEndereco}")
    public void delete(@Valid @PathVariable("idEndereco") Integer idEndereco) throws RegraDeNegocioException {
        enderecoService.delete(idEndereco);
    }

}
