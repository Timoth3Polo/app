package fr.amakibo.lirafus.app.repository;

import fr.amakibo.lirafus.app.model.Type;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository extends JpaRepository<Type, String> {
    Optional<Type> findByName(String name);
}
