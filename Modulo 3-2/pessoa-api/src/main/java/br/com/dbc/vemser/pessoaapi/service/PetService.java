package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.pet.PetCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.pet.PetDTO;
import br.com.dbc.vemser.pessoaapi.dto.pet.PetInformacoesDTO;
import br.com.dbc.vemser.pessoaapi.entity.classes.PessoaEntity;
import br.com.dbc.vemser.pessoaapi.entity.classes.PetEntity;
import br.com.dbc.vemser.pessoaapi.entity.classes.PetInformacoes;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import br.com.dbc.vemser.pessoaapi.repository.PetRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Slf4j
@Service
public class PetService {
    private final PetRepository petRepository;
    private final PessoaService pessoaService;
    private final PessoaRepository pessoaRepository;
    private final ObjectMapper objectMapper;

    //listar todos
    public List<PetDTO> list() {
        return petRepository.findAll().stream()
                .map(pet -> objectMapper.convertValue(pet, PetDTO.class))
                .toList();
    }
    // create
    public PetDTO create(Integer idPessoa, PetCreateDTO petDTO) throws RegraDeNegocioException {

        PessoaEntity pessoaRecuperada = pessoaService.findById(idPessoa); // recuperando pai/mãe do pet

        PetEntity petEntity = objectMapper.convertValue(petDTO, PetEntity.class); // set agora é pelo relacionamento
        petEntity.setPessoa(pessoaRecuperada);

        PetEntity petCriado = petRepository.save(petEntity);
        log.info("Adicionando pet...");

        PetDTO petDto = objectMapper.convertValue(petCriado, PetDTO.class); // retorno pro controller após operação
        return petDto;

    }

    //UPDATE / PUT
    public PetDTO update(Integer id,
                         PetCreateDTO pet) throws RegraDeNegocioException {

        PetEntity petEntityResgatado = findPetById(id); //Busca dados do pet a ser alterado
        PessoaEntity pessoaEntity = petEntityResgatado.getPessoa();
        pessoaEntity.setPet(null);
        PessoaEntity pessoaRecuperada = pessoaService.findById(pet.getIdPessoa());
        log.info("Atualizando pet...");

        // Chamando o update (passando objeto convertido na linha anterior)
        petEntityResgatado.setPetInformacoes(objectMapper.convertValue(pet.getPetInformacoes(), PetInformacoes.class));
        petEntityResgatado.setPessoa(pessoaRecuperada);
        Set<PetEntity> petList = new HashSet<>();
        petList.add(petEntityResgatado);
        pessoaRecuperada.setPet(petList);
        pessoaRepository.save(pessoaRecuperada);

        if (!pessoaRecuperada.getIdPessoa().equals(pessoaEntity.getIdPessoa())) {
            pessoaRepository.save(pessoaEntity);
        }
        PetEntity petEntity = petRepository.save(petEntityResgatado);
        return objectMapper.convertValue(petEntity, PetDTO.class);
    }

    //DELETE
    public void delete(Integer id) throws RegraDeNegocioException {

        PetEntity petEntityResgatado = findPetById(id);
        PessoaEntity pessoaRecuperada = pessoaService.findById(petEntityResgatado.getIdPessoa());//Checa se existe

        log.info("Excluindo pet");

        petRepository.delete(petEntityResgatado);

    }

    //ENCONTRA PET PELO ID
    private PetEntity findPetById(Integer id) throws RegraDeNegocioException {
        return petRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("Pet não encontrado"));
    }


}
