package fr.amakibo.lirafus.app.service;

import fr.amakibo.lirafus.app.dto.ClasseDTO;
import fr.amakibo.lirafus.app.exception.ClasseNotFoundException;
import fr.amakibo.lirafus.app.model.Classe;
import fr.amakibo.lirafus.app.repository.ClasseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ClasseServiceTest {

    private ClasseRepository classeRepository;
    private ClasseService classeService;

    @BeforeEach
    void setUp() {
        classeRepository = Mockito.mock(ClasseRepository.class);
        classeService = new ClasseService(classeRepository);
    }

    private Classe createMockClasse(String name) {
        Classe classe = new Classe();
        classe.setName(name);
        classe.setPrimaryColor("Red");
        classe.setSecondaryColor("Blue");
        classe.setUrlProfilePicture("http://example.com/profile.png");
        return classe;
    }

    @Test
    void getAllClasses_returns_classeDTO_list() throws ClasseNotFoundException {
        Classe classe1 = createMockClasse("Mage");
        Classe classe2 = createMockClasse("Warrior");
        when(classeRepository.findAll()).thenReturn(List.of(classe1, classe2));

        List<ClasseDTO> result = classeService.getAllClasses();

        assertNotNull(result, "Result should not be null");
        assertEquals(2, result.size(), "Result size should match the number of classes");
        assertEquals("Mage", result.get(0).getName());
        assertEquals("Warrior", result.get(1).getName());
        verify(classeRepository, times(1)).findAll();
    }

    @Test
    void getAllClasses_empty_list_throws_ClasseNotFoundException() {
        when(classeRepository.findAll()).thenReturn(Collections.emptyList());

        ClasseNotFoundException exception = assertThrows(ClasseNotFoundException.class, classeService::getAllClasses);
        assertEquals("All DTO Classe could not be found.", exception.getMessage());
        verify(classeRepository, times(1)).findAll();
    }

    @Test
    void getClasseByName_valid_name_returns_classeDTO() throws ClasseNotFoundException {
        Classe classe = createMockClasse("Mage");
        when(classeRepository.findByName("Mage")).thenReturn(Optional.of(classe));

        ClasseDTO result = classeService.getClasseByName("Mage");

        assertNotNull(result, "Result should not be null");
        assertEquals("Mage", result.getName());
        verify(classeRepository, times(1)).findByName("Mage");
    }

    @Test
    void getClasseByName_invalid_name_throws_ClasseNotFoundException() {
        when(classeRepository.findByName("Unknown")).thenReturn(Optional.empty());

        ClasseNotFoundException exception = assertThrows(ClasseNotFoundException.class, () -> classeService.getClasseByName("Unknown"));
        assertEquals("DTO Classe not found.", exception.getMessage());
        verify(classeRepository, times(1)).findByName("Unknown");
    }
}
