package fr.amakibo.lirafus.app.mapper;

import fr.amakibo.lirafus.app.dto.TypeDTO;
import fr.amakibo.lirafus.app.model.Type;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TypeMapper {

    private static final Logger logger = LoggerFactory.getLogger(TypeMapper.class);

    public static TypeDTO toDTO(Type type) {
        if (type == null) {
            logger.error("Type object is null.");
            return null;
        }
            
        TypeDTO typeDTO = new TypeDTO();
        typeDTO.setName(type.getName());
        typeDTO.setUrlPicture(type.getUrlPicture());
        List<String> classes = new ArrayList<>();

        if(type.getClasseTypes() != null && !type.getClasseTypes().isEmpty()) {
            classes = type.getClasseTypes().stream()
                    .map(classeType -> classeType.getClasse().getName())
                    .collect(Collectors.toList());
        }

        typeDTO.setClasses(classes);

        return typeDTO;
    }
}
