package fr.amakibo.lirafus.app.service;

import fr.amakibo.lirafus.app.exception.TypeNotFoundException;
import fr.amakibo.lirafus.app.model.Type;
import fr.amakibo.lirafus.app.dto.TypeDTO;
import fr.amakibo.lirafus.app.mapper.TypeMapper;
import fr.amakibo.lirafus.app.repository.TypeRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TypeService {

    private final TypeRepository typeRepository;

    private static final Logger logger = LoggerFactory.getLogger(TypeService.class);

    @Autowired
    public TypeService(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    public List<TypeDTO> getAllTypes() throws TypeNotFoundException {
        List<TypeDTO> listTypeDTO = typeRepository.findAll().stream()
                .map(TypeMapper::toDTO)
                .collect(Collectors.toList());

        if(listTypeDTO == null || listTypeDTO.isEmpty()) {
            logger.error("All DTO Type could not be found.");
            throw new TypeNotFoundException("All DTO Type could not be found.");
        }

        return listTypeDTO;
    }

    public TypeDTO getTypeByName(String name) throws TypeNotFoundException {
        Optional<Type> typeOpt = typeRepository.findByName(name);
        TypeDTO typeDTO = TypeMapper.toDTO(typeOpt.orElse(null));

        if(typeDTO == null) {
            logger.error("DTO Type not found.");
            throw new TypeNotFoundException("DTO Type not found.");
        }

        return typeDTO;
    }
}
