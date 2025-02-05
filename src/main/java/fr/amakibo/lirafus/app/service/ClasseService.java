package fr.amakibo.lirafus.app.service;

import fr.amakibo.lirafus.app.exception.ClasseNotFoundException;
import fr.amakibo.lirafus.app.model.Classe;
import fr.amakibo.lirafus.app.dto.ClasseDTO;
import fr.amakibo.lirafus.app.mapper.ClasseMapper;
import fr.amakibo.lirafus.app.repository.ClasseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClasseService {

    private final ClasseRepository classeRepository;

    private static final Logger logger = LoggerFactory.getLogger(ClasseService.class);

    @Autowired
    public ClasseService(ClasseRepository classeRepository) {
        this.classeRepository = classeRepository;
    }

    public List<ClasseDTO> getAllClasses() throws ClasseNotFoundException {
        List<ClasseDTO> listClasseDTO = classeRepository.findAll().stream()
                .map(ClasseMapper::toDTO)
                .collect(Collectors.toList());

        if(listClasseDTO == null || listClasseDTO.isEmpty()) {
            logger.error("All DTO Classe could not be found.");
            throw new ClasseNotFoundException("All DTO Classe could not be found.");
        }

        return listClasseDTO;
    }

    public ClasseDTO getClasseByName(String name) throws ClasseNotFoundException {
        Optional<Classe> classeOpt = classeRepository.findByName(name);
        ClasseDTO classeDTO = ClasseMapper.toDTO(classeOpt.orElse(null));

        if(classeDTO == null) {
            logger.error("DTO Classe not found.");
            throw new ClasseNotFoundException("DTO Classe not found.");
        }

        return classeDTO;
    }
}
