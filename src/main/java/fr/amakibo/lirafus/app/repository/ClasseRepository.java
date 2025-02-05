package fr.amakibo.lirafus.app.repository;

import fr.amakibo.lirafus.app.model.Classe;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClasseRepository extends JpaRepository<Classe, String> {
    Optional<Classe> findByName(String name);
}
