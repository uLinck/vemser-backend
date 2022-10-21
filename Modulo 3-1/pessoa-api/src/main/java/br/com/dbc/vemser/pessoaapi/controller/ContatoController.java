package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.service.ContatoService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/contato") // localhost:8080/contato
@Validated
public class ContatoController {

    private ContatoService contatoService;

    public ContatoController(ContatoService contatoService) {
        this.contatoService = contatoService;
    }

    @GetMapping()
    public List<Contato> list() {
        return contatoService.list();
    }

    @GetMapping("/{byIdPessoa}")
    public List<Contato> listByIdPessoa(@PathVariable("byIdPessoa") Integer byIdPessoa) {
        return contatoService.listByIdPessoa(byIdPessoa);
    }

    @PostMapping("/{idPessoa}")
    public Contato create (@Valid @PathVariable("idPessoa") Integer idPessoa,
                           @Valid @RequestBody Contato contato) throws RegraDeNegocioException {
        if (contatoService.verifyPessoa(idPessoa)) {
            return contatoService.create(idPessoa, contato);
        } else {
            throw new RegraDeNegocioException("Pessoa não encontrada");
        }
}
@PutMapping("/{idContato}")
    public Contato update(@PathVariable("idContato") Integer id,
                          @RequestBody Contato contatoAtualizar) throws RegraDeNegocioException {
        return contatoService.update(id, contatoAtualizar);
    }
    @DeleteMapping("/{idContato}")
    public void delete(@Valid @PathVariable ("idContato") Integer id) throws RegraDeNegocioException {
        contatoService.delete(id);
    }


}
