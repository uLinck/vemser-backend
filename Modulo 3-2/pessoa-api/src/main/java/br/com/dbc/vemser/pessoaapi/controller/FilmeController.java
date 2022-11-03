package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.dto.filme.FilmeAvaliadoDTO;
import br.com.dbc.vemser.pessoaapi.dto.filme.FilmeCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.filme.FilmeDTO;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.service.FilmeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/filme")
@Validated
public class FilmeController {

    private final FilmeService filmeService;

    @GetMapping()
    public List<FilmeDTO> list() {
        return filmeService.list();
    }

    @PostMapping("/{idPessoa}")
    public ResponseEntity<FilmeDTO> create(@Valid @RequestBody FilmeCreateDTO filme) {
        return ResponseEntity.ok(filmeService.create(filme));
    }

    @PostMapping("/avaliar-filme/{idPessoa}")
    public ResponseEntity<FilmeAvaliadoDTO> avaliarFilme(@Valid @RequestParam("idPessoa") Integer idPessoa,
                                                         @Valid @RequestBody FilmeAvaliadoDTO filme) throws RegraDeNegocioException {
        return ResponseEntity.ok(filmeService.avaliarFilme(idPessoa, filme));
    }

    @PutMapping("/{idFilme}")
    public ResponseEntity<FilmeDTO> update(@Valid @PathVariable("idFilme") Integer idFilme,
                                           @Valid @RequestBody FilmeCreateDTO filmeUpdate) throws RegraDeNegocioException {
        return ResponseEntity.ok(filmeService.update(idFilme, filmeUpdate));
    }

    public void delete(@Valid @PathVariable("idFilme") Integer idFilme) throws RegraDeNegocioException {
        filmeService.delete(idFilme);
    }
}
