package fr.amakibo.lirafus.app.controller;

import fr.amakibo.lirafus.app.dto.TypeDTO;
import fr.amakibo.lirafus.app.exception.TypeNotFoundException;
import fr.amakibo.lirafus.app.exception.TypeNullException;
import fr.amakibo.lirafus.app.service.TypeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/types")
public class TypeController {

    @Autowired
    private TypeService typeService;

    @GetMapping
    public ResponseEntity<List<TypeDTO>> getAllType() {
        try {
            List<TypeDTO> listTypeDTO = typeService.getAllTypes();
            return new ResponseEntity<>(listTypeDTO, HttpStatus.OK);
        } catch(TypeNotFoundException typeNotFoundException) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{name}")
    public ResponseEntity<TypeDTO> getTypeByName(@PathVariable String name) {
        try {
            TypeDTO typeDTO = typeService.getTypeByName(name);
            return new ResponseEntity<>(typeDTO, HttpStatus.OK);
        } catch(TypeNotFoundException typeNotFoundException) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
