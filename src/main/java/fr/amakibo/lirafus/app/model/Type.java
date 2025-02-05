package fr.amakibo.lirafus.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;

import java.util.List;

@Entity
@Table(name = "types")
public class Type {

    @Id
    @Column(name = "name", length = 20)
    private String name;

    @Column(name = "url_picture", nullable = false, length = 100)
    private String urlPicture;

    // Relation un à plusieurs avec 'ClasseType'
    @OneToMany(mappedBy = "type", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ClasseType> classeTypes;

    // Getters et Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrlPicture() {
        return urlPicture;
    }

    public void setUrlPicture(String urlPicture) {
        this.urlPicture = urlPicture;
    }

    public List<ClasseType> getClasseTypes() {
        return classeTypes;
    }

    public void setClasseTypes(List<ClasseType> classeTypes) {
        this.classeTypes = classeTypes;
    }
}
