package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.dto.endereco.EnderecoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.endereco.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.service.EnderecoService;
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
@RequestMapping("/enderecos") // localhost:8080/enderecos
@Validated
public class EnderecoController {

    private final EnderecoService enderecoService;

    @Operation(summary = "listar endereços", description = "Lista todos os endereços do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de endereços"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )

    @GetMapping() // retorna todos os endereços
    public List<EnderecoDTO> list() {
        return enderecoService.list();
    }

    @Operation(summary = "recuperar endereço pelo id do endereço", description = "recupera o endereço selecionado")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de endereços"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )

    @GetMapping("/{idEndereco}")
    public EnderecoDTO listByIdEndereco(@PathVariable("idEndereco") Integer idEndereco) throws RegraDeNegocioException {
        return enderecoService.listByIdEndereco(idEndereco);
    }

    @Operation(summary = "listar endereços pelo id da pessoa", description = "Lista todos os endereços da pessoas selecionada")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna os endereços do id pessoas"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )

    @GetMapping("/{idPessoa}/pessoa")
    public List<EnderecoDTO> listByIdPessoa(@PathVariable("idPessoa") Integer idPessoa) {
        return enderecoService.listByIdPessoa(idPessoa);
    }

    @Operation(summary = "adicionar endereço", description = "Adiciona um endereço no banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Endereço adicionado com sucesso"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )

    @PostMapping("/{idPessoa}")
    public ResponseEntity<EnderecoDTO> create(@Valid @PathVariable("idPessoa") Integer idPessoa,
                                              @Valid @RequestBody EnderecoCreateDTO endereco) throws RegraDeNegocioException {
            return ResponseEntity.ok(enderecoService.create(idPessoa, endereco));
    }

    @Operation(summary = "atualizar endereço", description = "Atualiza um endereço do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Endereço atualizado com sucesso"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )

    @PutMapping("/{idEndereco}")
    public ResponseEntity<EnderecoDTO> update(@Valid @PathVariable("idEndereco") Integer idEndereco,
                                              @Valid @RequestBody EnderecoCreateDTO enderecoAtualizar) throws RegraDeNegocioException {
        return ResponseEntity.ok(enderecoService.update(idEndereco, enderecoAtualizar));
    }

    @Operation(summary = "deletar endereço", description = "Deleta um endereço do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Endereço deletado com sucesso"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )

    @DeleteMapping("/{idEndereco}")
    public void delete(@Valid @PathVariable("idEndereco") Integer idEndereco) throws RegraDeNegocioException {
        enderecoService.delete(idEndereco);
    }
}
