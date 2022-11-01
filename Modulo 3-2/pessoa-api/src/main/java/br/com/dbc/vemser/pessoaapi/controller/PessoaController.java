package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import br.com.dbc.vemser.pessoaapi.service.PessoaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/pessoa") // localhost:8080/pessoa
@Validated
public class PessoaController {
    private final PessoaService pessoaService;

    @Operation(summary = "criar pessoas", description = "cria uma nova pessoa no banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "pessoa criada com sucesso"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PostMapping // localhost:8080/pessoa
    public PessoaDTO create(@Valid @RequestBody PessoaCreateDTO pessoa) {
        return pessoaService.create(pessoa);
    }

    @Operation(summary = "listar pessoas", description = "Lista todas as pessoas do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de pessoas"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping // localhost:8080/pessoa
    public List<PessoaDTO> list() {
        return pessoaService.list();
    }

//    @GetMapping("/byname") // localhost:8080/pessoa/byname?nome=Rafa
//    public List<PessoaDTO> listByName(@RequestParam("nome") String nome) {
//        return pessoaService.listByName(nome);
//    }

    @Operation(summary = "atualizar pessoa", description = "Atualiza uma pessoa do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Pessoa atualizada com sucesso"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PutMapping("/{idPessoa}") // localhost:8080/pessoa/1000
    public PessoaDTO update(@Valid @PathVariable("idPessoa") Integer id,
                            @Valid @RequestBody PessoaDTO pessoaAtualizar) throws RegraDeNegocioException {
        return pessoaService.update(id, pessoaAtualizar);
    }

    @Operation(summary = "deletar pessoa", description = "deleta alguma pessoa do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Pessoa deletada com sucesso   "),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "400", description = "Pessoa não encontrada"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @DeleteMapping("/{idPessoa}") // localhost:8080/pessoa/10
    public void delete(@Valid @PathVariable("idPessoa") Integer id) throws RegraDeNegocioException {
        pessoaService.delete(id);
    }
}
