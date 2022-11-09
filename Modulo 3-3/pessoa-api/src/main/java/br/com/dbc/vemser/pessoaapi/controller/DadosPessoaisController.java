package br.com.dbc.vemser.pessoaapi.controller;


import br.com.dbc.vemser.pessoaapi.client.DadosPessoaisClient;
import br.com.dbc.vemser.pessoaapi.dto.dadosPessoais.DadosPessoaisDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/dados-pessoais")
public class DadosPessoaisController {

    private final DadosPessoaisClient client;


    @GetMapping
    public List<DadosPessoaisDTO> getAll() {
        return client.getAll();
    }


    @GetMapping("/{cpf}")
    public DadosPessoaisDTO get(@PathVariable("cpf") String cpf) {
        return client.get(cpf);
    }


    @PostMapping
    public DadosPessoaisDTO post(@RequestBody DadosPessoaisDTO dadosPessoaisDTO) {
        return client.post(dadosPessoaisDTO);
    }


    @PutMapping("/{cpf}")
    public DadosPessoaisDTO put(@PathVariable("cpf") String cpf,
                                @RequestBody DadosPessoaisDTO dadosPessoaisDTO) {
        return client.put(cpf, dadosPessoaisDTO);
    }


    @DeleteMapping("/{cpf}")
    public void delete(@PathVariable("cpf") String cpf) {
        client.delete(cpf);
    }
}
