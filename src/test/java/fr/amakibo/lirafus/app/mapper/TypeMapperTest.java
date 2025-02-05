package fr.amakibo.lirafus.app.mapper;

import fr.amakibo.lirafus.app.dto.TypeDTO;
import fr.amakibo.lirafus.app.model.Classe;
import fr.amakibo.lirafus.app.model.ClasseType;
import fr.amakibo.lirafus.app.model.Type;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TypeMapperTest {

    private Type createMockType() {
        Classe classe1 = new Classe();
        classe1.setName("Mage");

        Classe classe2 = new Classe();
        classe2.setName("Warrior");

        ClasseType classeType1 = new ClasseType();
        classeType1.setClasse(classe1);

        ClasseType classeType2 = new ClasseType();
        classeType2.setClasse(classe2);

        Type type = new Type();
        type.setName("Magic");
        type.setUrlPicture("http://example.com/magic.png");
        type.setClasseTypes(List.of(classeType1, classeType2));

        return type;
    }

    @Test
    void toDTO_null_type_returns_null() {
        Type type = null;

        TypeDTO result = TypeMapper.toDTO(type);

        assertNull(result, "Result should be null when Type is null");
    }

    @Test
    void toDTO_valid_type_returns_typeDTO() {
        Type type = createMockType();

        TypeDTO result = TypeMapper.toDTO(type);

        assertNotNull(result, "Result should not be null for a valid Type");
        assertEquals("Magic", result.getName());
        assertEquals("http://example.com/magic.png", result.getUrlPicture());
        assertNotNull(result.getClasses(), "Classes should not be null");
        assertEquals(2, result.getClasses().size());
        assertTrue(result.getClasses().contains("Mage"));
        assertTrue(result.getClasses().contains("Warrior"));
    }

    @Test
    void toDTO_type_with_no_classe_types_returns_typeDTO_with_empty_classes() {
        Type type = createMockType();
        type.setClasseTypes(Collections.emptyList());

        TypeDTO result = TypeMapper.toDTO(type);

        assertNotNull(result, "Result should not be null for a valid Type");
        assertEquals("Magic", result.getName());
        assertNotNull(result.getClasses(), "Classes should not be null");
        assertTrue(result.getClasses().isEmpty(), "Classes should be empty");
    }

    @Test
    void toDTO_type_with_null_classe_types_returns_typeDTO_with_empty_classes() {
        Type type = createMockType();
        type.setClasseTypes(null);

        TypeDTO result = TypeMapper.toDTO(type);

        assertNotNull(result, "Result should not be null for a valid Type");
        assertEquals("Magic", result.getName());
        assertNotNull(result.getClasses(), "Classes should not be null");
        assertTrue(result.getClasses().isEmpty(), "Classes should be empty");
    }
}
