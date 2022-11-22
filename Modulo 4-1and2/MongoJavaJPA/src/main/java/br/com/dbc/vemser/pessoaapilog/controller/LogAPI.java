//package br.com.pessoaapi.controller;
//
//
//import br.com.pessoaapi.dto.LogDTO;
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.responses.ApiResponse;
//import io.swagger.v3.oas.annotations.responses.ApiResponses;
//import org.springframework.validation.annotation.Validated;
//
//import java.util.List;
//
//@Validated
//public interface LogAPI {
//
//    @Operation(value = "Mostra uma lista de logs")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Retorna uma lista de logs"),
//            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
//            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),})
//    List<LogDTO> list();
//
//    @ApiOperation(value = "Retorna uma lista de logs por tipo")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Retorna uma lista de logs por tipo"),
//            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
//            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),})
//    List<LogDTO> listByTipoLog(TipoLog tipoLog);
//
//    @ApiOperation(value = "Agrupa os logs por tipo e mostra quantidade")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Retorna os logs contados"),
//            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
//            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),})
//    List<LogDTOContador> groupByTipoLogAndCount();
//
//
//    @Operation(value = "Agrupa o log por tipo e mostra quantidade")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Retorna o log contado"),
//            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
//            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),})
//    LogDTOContador getCountByTipoLog(TipoLog tipoLog);
//
//    @Operation(value = "Retorna os logs por data")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Retorna os logs por data"),
//            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
//            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),})
//    List<LogDTO> getByData(String data) throws Exception;
//}
