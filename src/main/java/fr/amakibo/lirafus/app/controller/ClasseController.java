package fr.amakibo.lirafus.app.controller;

import fr.amakibo.lirafus.app.dto.ClasseDTO;
import fr.amakibo.lirafus.app.exception.ClasseNotFoundException;
import fr.amakibo.lirafus.app.service.ClasseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/classes")
public class ClasseController {

    private final ClasseService classeService;

    @Autowired
    public ClasseController(ClasseService classeService) {
        this.classeService = classeService;
    }

    @GetMapping
    public ResponseEntity<List<ClasseDTO>> getAllClasses() {
        try {
            List<ClasseDTO> listClasseDTO = classeService.getAllClasses();
            return new ResponseEntity<>(listClasseDTO, HttpStatus.OK);
        } catch(ClasseNotFoundException classeNotFoundException) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{name}")
    public ResponseEntity<ClasseDTO> getClasseByName(@PathVariable String name) {
        try {
            ClasseDTO classeDTO = classeService.getClasseByName(name);;
            return new ResponseEntity<>(classeDTO, HttpStatus.OK);
        } catch(ClasseNotFoundException classeNotFoundException) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
