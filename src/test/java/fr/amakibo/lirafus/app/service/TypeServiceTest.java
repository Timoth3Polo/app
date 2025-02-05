package fr.amakibo.lirafus.app.service;

import fr.amakibo.lirafus.app.model.Type;
import fr.amakibo.lirafus.app.exception.TypeNotFoundException;
import fr.amakibo.lirafus.app.repository.TypeRepository;
import fr.amakibo.lirafus.app.dto.TypeDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TypeServiceTest {

    private TypeRepository typeRepository;
    private TypeService typeService;

    @BeforeEach
    void setUp() {
        typeRepository = Mockito.mock(TypeRepository.class);
        typeService = new TypeService(typeRepository);
    }

    private Type createMockType(String name) {
        Type type = new Type();
        type.setName(name);
        type.setUrlPicture("http://example.com/picture.png");
        return type;
    }

    @Test
    void getAllTypes_returns_typeDTO_list() throws TypeNotFoundException {
        Type type1 = createMockType("Fire");
        Type type2 = createMockType("Water");
        when(typeRepository.findAll()).thenReturn(List.of(type1, type2));

        List<TypeDTO> result = typeService.getAllTypes();

        assertNotNull(result, "Result should not be null");
        assertEquals(2, result.size(), "Result size should match the number of types");
        assertEquals("Fire", result.get(0).getName());
        assertEquals("Water", result.get(1).getName());
        verify(typeRepository, times(1)).findAll();
    }

    @Test
    void getAllTypes_empty_list_throws_TypeNotFoundException() {
        when(typeRepository.findAll()).thenReturn(Collections.emptyList());

        TypeNotFoundException exception = assertThrows(TypeNotFoundException.class, typeService::getAllTypes);
        assertEquals("All DTO Type could not be found.", exception.getMessage());
        verify(typeRepository, times(1)).findAll();
    }

    @Test
    void getTypeByName_valid_name_returns_typeDTO() throws TypeNotFoundException {
        Type type = createMockType("Fire");
        when(typeRepository.findByName("Fire")).thenReturn(Optional.of(type));

        TypeDTO result = typeService.getTypeByName("Fire");

        assertNotNull(result, "Result should not be null");
        assertEquals("Fire", result.getName());
        verify(typeRepository, times(1)).findByName("Fire");
    }

    @Test
    void getTypeByName_invalid_name_throws_TypeNotFoundException() {
        when(typeRepository.findByName("Unknown")).thenReturn(Optional.empty());

        TypeNotFoundException exception = assertThrows(TypeNotFoundException.class, () -> typeService.getTypeByName("Unknown"));
        assertEquals("DTO Type not found.", exception.getMessage());
        verify(typeRepository, times(1)).findByName("Unknown");
    }
}
