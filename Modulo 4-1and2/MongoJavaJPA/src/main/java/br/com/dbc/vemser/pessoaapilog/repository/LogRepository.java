package br.com.dbc.vemser.pessoaapilog.repository;

import br.com.dbc.vemser.pessoaapilog.entity.LogByTipo;
import br.com.dbc.vemser.pessoaapilog.entity.LogEntity;
import br.com.dbc.vemser.pessoaapilog.enums.TipoLog;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogRepository extends MongoRepository<LogEntity, String> {

    List<LogEntity> findAllByTipoLog(TipoLog tipoLog);

    @Aggregation(pipeline = {
            "{ '$unwind' : '$tipoLog' }",
            "{'$group':{ '_id': '$tipoLog', 'quantidade' : {'$sum': 1} }}"
    })
    List<LogByTipo> groupByTipoLogAndCount();

    List<LogEntity> findAllByDataContains(String data);

    Long countAllByDataContains(String data);

    Integer countByTipoLog(TipoLog tipoLog);

}
