package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.dto.filme.FilmeAvaliadoDTO;
import br.com.dbc.vemser.pessoaapi.dto.filme.FilmeCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.filme.FilmeDTO;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.service.FilmeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Listar filmes", description = "Lista todos os filmes do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de filmes"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping()
    public List<FilmeDTO> list() {
        return filmeService.list();
    }

    @Operation(summary = "Criar filme", description = "Cria um filme no banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Filme criado com sucesso"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )

    @PostMapping("/{idPessoa}")
    public ResponseEntity<FilmeDTO> create(@Valid @RequestBody FilmeCreateDTO filme) {
        return ResponseEntity.ok(filmeService.create(filme));
    }

    @Operation(summary = "Adicionar uma avaliação a um filme", description = "Adiciona uma avaliação no banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Avaliação adicionada com sucesso"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )

    @PostMapping("/avaliar-filme/{idPessoa}")
    public ResponseEntity<FilmeAvaliadoDTO> avaliarFilme(@Valid @RequestParam("idPessoa") Integer idPessoa,
                                                         @Valid @RequestBody FilmeAvaliadoDTO filme) throws RegraDeNegocioException {
        return ResponseEntity.ok(filmeService.avaliarFilme(idPessoa, filme));
    }

    @Operation(summary = "Atualizar Filme", description = "Atualiza um filme do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Filme atualizado com sucesso"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )

    @PutMapping("/{idFilme}")
    public ResponseEntity<FilmeDTO> update(@Valid @PathVariable("idFilme") Integer idFilme,
                                           @Valid @RequestBody FilmeCreateDTO filmeUpdate) throws RegraDeNegocioException {
        return ResponseEntity.ok(filmeService.update(idFilme, filmeUpdate));
    }

    @Operation(summary = "deletar um filme", description = "Deleta um filme do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Filme deletado com sucesso"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )

    public void delete(@Valid @PathVariable("idFilme") Integer idFilme) throws RegraDeNegocioException {
        filmeService.delete(idFilme);
    }
}
