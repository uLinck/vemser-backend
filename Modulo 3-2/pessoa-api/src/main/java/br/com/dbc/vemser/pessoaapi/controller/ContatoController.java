package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.service.ContatoService;
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
@RequestMapping("/contato") // localhost:8080/contato
@Validated
public class ContatoController {


    private final ContatoService contatoService;

    @Operation(summary = "listar contatos", description = "Lista todas os contatos do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de contatos"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )

    @GetMapping()
    public List<ContatoDTO> list() {
        return contatoService.list();
    }

    @Operation(summary = "listar contatos pelo Id da Pessoa", description = "Lista todos os contatos da pessoas selecionada")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna os contatos do id escolhido"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )

//    @GetMapping("/{byIdPessoa}")
//    public List<ContatoDTO> listByIdPessoa(@PathVariable("byIdPessoa") Integer byIdPessoa) {
//        return contatoService.listByIdPessoa(byIdPessoa);
//    }
//
//    @Operation(summary = "adicionar Contato", description = "Adiciona um contato no banco")
//    @ApiResponses(
//            value = {
//                    @ApiResponse(responseCode = "200", description = "Contato adicionado com sucesso"),
//                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
//                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
//            }
//    )

    @PostMapping
    public ResponseEntity<ContatoDTO> create(@Valid @RequestBody ContatoCreateDTO contato) {
            return ResponseEntity.ok(contatoService.create(contato));
    }

    @Operation(summary = "atualizar Contato", description = "Atualiza um contato do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Contato atualizado com sucesso"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )

    @PutMapping("/{idContato}")
    public ResponseEntity<ContatoDTO> update(@PathVariable("idContato") Integer id,
                                             @RequestBody ContatoCreateDTO contatoAtualizar) throws RegraDeNegocioException {
        return ResponseEntity.ok(contatoService.update(id, contatoAtualizar));
    }

    @Operation(summary = "deletar Contato", description = "Deleta um contato do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Contato deletado com sucesso"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @DeleteMapping("/{idContato}")
    public void delete(@Valid @PathVariable("idContato") Integer id) throws RegraDeNegocioException {
        contatoService.delete(id);
    }
}
