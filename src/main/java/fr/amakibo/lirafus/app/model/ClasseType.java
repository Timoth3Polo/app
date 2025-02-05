package fr.amakibo.lirafus.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name = "classes_types")
public class ClasseType {

    @Id
    @ManyToOne
    @JoinColumn(name = "classe_name", nullable = false)
    private Classe classe;

    @Id
    @ManyToOne
    @JoinColumn(name = "type_name", nullable = false)
    private Type type;

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
