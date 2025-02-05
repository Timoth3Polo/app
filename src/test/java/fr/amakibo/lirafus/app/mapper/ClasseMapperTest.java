package fr.amakibo.lirafus.app.mapper;

import fr.amakibo.lirafus.app.dto.ClasseDTO;
import fr.amakibo.lirafus.app.model.Classe;
import fr.amakibo.lirafus.app.model.ClasseType;
import fr.amakibo.lirafus.app.model.Type;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ClasseMapperTest {

    private Classe createMockClasse() {
        ClasseType classeType = new ClasseType();
        Type type = new Type();
        type.setName("Warrior");
        classeType.setType(type);

        Classe classe = new Classe();
        classe.setName("Mage");
        classe.setPrimaryColor("Blue");
        classe.setSecondaryColor("White");
        classe.setUrlProfilePicture("http://example.com/profile.png");
        classe.setUrlCharacterPicture("http://example.com/character.png");
        classe.setUrlBackgroundPicture("http://example.com/background.png");
        classe.setOverview("A powerful magic user.");
        classe.setNickname1("Spellcaster");
        classe.setNickname2("Sorcerer");
        classe.setClasseTypes(List.of(classeType));

        return classe;
    }

    @Test
    void toDTO_with_valid_classe_should_map_correctly() {
        Classe classe = createMockClasse();

        ClasseDTO result = ClasseMapper.toDTO(classe);

        assertNotNull(result, "Result should not be null for a valid Classe");
        assertEquals("Mage", result.getName());
        assertEquals("Blue", result.getPrimaryColor());
        assertEquals("White", result.getSecondaryColor());
        assertEquals("http://example.com/profile.png", result.getUrlProfilePicture());
        assertEquals("http://example.com/character.png", result.getUrlCharacterPicture());
        assertEquals("http://example.com/background.png", result.getUrlBackgroundPicture());
        assertEquals("A powerful magic user.", result.getOverview());
        assertEquals("Spellcaster", result.getNickname1());
        assertEquals("Sorcerer", result.getNickname2());
        assertNotNull(result.getTypes());
        assertEquals(1, result.getTypes().size());
        assertEquals("Warrior", result.getTypes().get(0));
    }

    @Test
    void toDTO_with_null_classe_should_return_null() {
        Classe classe = null;

        ClasseDTO result = ClasseMapper.toDTO(classe);

        assertNull(result, "Result should be null when Classe is null");
    }

    @Test
    void toDTO_with_empty_types_return_classeDTO_with_empty_types() {
        Classe classe = createMockClasse();
        classe.setClasseTypes(Collections.emptyList());

        ClasseDTO result = ClasseMapper.toDTO(classe);

        assertNotNull(result, "Result should not be null for a valid Classe");
        assertEquals("Mage", result.getName());
        assertNotNull(result.getTypes(), "Types should not be null");
        assertTrue(result.getTypes().isEmpty(), "Types should be empty");
    }
}
