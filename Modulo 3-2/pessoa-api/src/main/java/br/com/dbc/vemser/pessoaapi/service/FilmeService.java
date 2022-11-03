package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.filme.FilmeAvaliadoDTO;
import br.com.dbc.vemser.pessoaapi.dto.filme.FilmeCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.filme.FilmeDTO;
import br.com.dbc.vemser.pessoaapi.entity.classes.FilmeEntity;
import br.com.dbc.vemser.pessoaapi.entity.classes.PessoaEntity;
import br.com.dbc.vemser.pessoaapi.entity.classes.PessoaFilmeEntity;
import br.com.dbc.vemser.pessoaapi.entity.pk.FilmePK;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.FilmeRepository;
import br.com.dbc.vemser.pessoaapi.repository.PessoaFilmeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FilmeService {

    private final FilmeRepository filmeRepository;
    private final PessoaFilmeRepository pessoaFilmeRepository;
    private final PessoaService pessoaService;
    private final ObjectMapper objectMapper;

    public List<FilmeDTO> list() {
        return filmeRepository.findAll().stream()
                .map(filme -> objectMapper.convertValue(filme, FilmeDTO.class))
                .toList();
    }

    public FilmeDTO create(FilmeCreateDTO filme) {
        FilmeEntity filmeEntityConvertion = objectMapper.convertValue(filme, FilmeEntity.class);
        filmeRepository.save(filmeEntityConvertion);
        return objectMapper.convertValue(filmeEntityConvertion, FilmeDTO.class);
    }

    public FilmeDTO update(Integer idFilme, FilmeCreateDTO filmeUpdate) throws RegraDeNegocioException {
        FilmeEntity filmeEntityDTO = findById(idFilme);
        filmeEntityDTO.setTipoFilme(filmeUpdate.getTipoFilme());
        filmeEntityDTO.setNota(filmeUpdate.getNota());
        filmeEntityDTO.setDescricao(filmeUpdate.getDescricao());
        filmeRepository.save(filmeEntityDTO);
        return objectMapper.convertValue(filmeEntityDTO, FilmeDTO.class);
    }

    public void delete(Integer idFilme) throws RegraDeNegocioException {
        FilmeEntity filmeEntityDTO = findById(idFilme);
        filmeRepository.delete(filmeEntityDTO);
    }


    public FilmeAvaliadoDTO avaliarFilme(Integer idPessoa, FilmeAvaliadoDTO filme) throws RegraDeNegocioException {
        PessoaFilmeEntity pessoaFilmeEntity = objectMapper.convertValue(filme, PessoaFilmeEntity.class);
        PessoaEntity pessoaEntity = pessoaService.findById(idPessoa);
        FilmeEntity filmeEntity = findById(filme.getFilmePK().getIdFilme());
        pessoaFilmeEntity.setFilmePK(new FilmePK(pessoaEntity.getIdPessoa(), filmeEntity.getIdFilme()));
        pessoaFilmeEntity.setPessoa(pessoaEntity);
        pessoaFilmeEntity.setFilme(filmeEntity);
        pessoaFilmeRepository.save(pessoaFilmeEntity);
        FilmeAvaliadoDTO filmeAvaliadoDTO = objectMapper.convertValue(pessoaFilmeEntity, FilmeAvaliadoDTO.class);
        filmeAvaliadoDTO.setNotaPessoa(filme.getNotaPessoa());
        filmeAvaliadoDTO.setFilmePK(filme.getFilmePK());
        return filmeAvaliadoDTO;
    }

    public FilmeEntity findById(Integer idFilme) throws RegraDeNegocioException {
        return filmeRepository.findById(idFilme)
                .orElseThrow(() -> new RegraDeNegocioException("Filme não encontrado"));
    }

}
