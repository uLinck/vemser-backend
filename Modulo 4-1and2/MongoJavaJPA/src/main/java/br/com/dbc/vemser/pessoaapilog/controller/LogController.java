package br.com.dbc.vemser.pessoaapilog.controller;

import br.com.dbc.vemser.pessoaapilog.service.LogService;
import br.com.dbc.vemser.pessoaapilog.dto.LogDTO;
import br.com.dbc.vemser.pessoaapilog.dto.LogDTOContador;
import br.com.dbc.vemser.pessoaapilog.enums.TipoLog;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/log")
//@Api(value = "Log API", produces = MediaType.APPLICATION_JSON_VALUE, tags = {"Log API"})
public class LogController { //implements LogAPI{

    private final LogService logService;

    @GetMapping("/list")
    public List<LogDTO> list() {
        return logService.listAllLogs();
    }

    @GetMapping("/list-by-tipo-log")
    public List<LogDTO> listByTipoLog(TipoLog tipoLog) {
        return logService.listLogsByTipoLog(tipoLog);
    }

    @GetMapping("/group-by-tipo-and-count")
    public List<LogDTOContador> groupByTipoLogAndCount() {
        return logService.groupByTipoLogAndCount();
    }

    @GetMapping("/count-logs-by-tipo")
    public LogDTOContador getCountByTipoLog(TipoLog tipoLog){
        return logService.countLogsByTipo(tipoLog);
    }

    @GetMapping("/find-all-by-data")
    public List<LogDTO> getByData(String data) throws Exception {
        return logService.listAllByData(data);
    }

    @GetMapping("count-all-by-data")
    public Long countLogsToday() throws Exception {
        return logService.countLogsByData();
    }

}
