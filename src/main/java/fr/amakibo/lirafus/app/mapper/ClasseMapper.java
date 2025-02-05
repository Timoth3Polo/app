package fr.amakibo.lirafus.app.mapper;

import fr.amakibo.lirafus.app.dto.ClasseDTO;
import fr.amakibo.lirafus.app.model.Classe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ClasseMapper {

    private static final Logger logger = LoggerFactory.getLogger(ClasseMapper.class);

    public static ClasseDTO toDTO(Classe classe) {
        if (classe == null) {
            logger.error("Classe object is null.");
            return null;
        }
        
        ClasseDTO classeDTO = new ClasseDTO();
        classeDTO.setName(classe.getName());
        classeDTO.setPrimaryColor(classe.getPrimaryColor());
        classeDTO.setSecondaryColor(classe.getSecondaryColor());
        classeDTO.setUrlProfilePicture(classe.getUrlProfilePicture());
        classeDTO.setUrlCharacterPicture(classe.getUrlCharacterPicture());
        classeDTO.setUrlBackgroundPicture(classe.getUrlBackgroundPicture());
        classeDTO.setOverview(classe.getOverview());
        classeDTO.setNickname1(classe.getNickname1());
        classeDTO.setNickname2(classe.getNickname2());

        List<String> types = new ArrayList<>();

        if(classe.getClasseTypes() != null && !classe.getClasseTypes().isEmpty()) {
            types = classe.getClasseTypes().stream()
                    .map(classeType -> classeType.getType().getName())
                    .collect(Collectors.toList());
        }

        classeDTO.setTypes(types);

        return classeDTO;
    }
}
