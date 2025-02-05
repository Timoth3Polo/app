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
@Table(name = "classes")
public class Classe {

    @Id
    @Column(name = "name", length = 20)
    private String name;

    @Column(name = "primary_col", nullable = false, length = 7)
    private String primaryColor;

    @Column(name = "secondary_col", nullable = false, length = 7)
    private String secondaryColor;

    @Column(name = "url_profile_picture", nullable = false, length = 100)
    private String urlProfilePicture;

    @Column(name = "url_character_picture", nullable = false, length = 100)
    private String urlCharacterPicture;

    @Column(name = "url_bg_picture", nullable = false, length = 100)
    private String urlBackgroundPicture;

    @Column(name = "overview", nullable = false, columnDefinition = "TEXT")
    private String overview;

    @Column(name = "nickname_1", nullable = false, length = 100)
    private String nickname1;

    @Column(name = "nickname_2", nullable = false, length = 100)
    private String nickname2;

    @OneToMany(mappedBy = "classe", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ClasseType> classeTypes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrimaryColor() {
        return primaryColor;
    }

    public void setPrimaryColor(String primaryColor) {
        this.primaryColor = primaryColor;
    }

    public String getSecondaryColor() {
        return secondaryColor;
    }

    public void setSecondaryColor(String secondaryColor) {
        this.secondaryColor = secondaryColor;
    }

    public String getUrlProfilePicture() {
        return urlProfilePicture;
    }

    public void setUrlProfilePicture(String urlProfilePicture) {
        this.urlProfilePicture = urlProfilePicture;
    }

    public String getUrlCharacterPicture() {
        return urlCharacterPicture;
    }

    public void setUrlCharacterPicture(String urlCharacterPicture) {
        this.urlCharacterPicture = urlCharacterPicture;
    }

    public String getUrlBackgroundPicture() {
        return urlBackgroundPicture;
    }

    public void setUrlBackgroundPicture(String urlBackgroundPicture) {
        this.urlBackgroundPicture = urlBackgroundPicture;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getNickname1() {
        return nickname1;
    }

    public void setNickname1(String nickname1) {
        this.nickname1 = nickname1;
    }

    public String getNickname2() {
        return nickname2;
    }

    public void setNickname2(String nickname2) {
        this.nickname2 = nickname2;
    }

    public List<ClasseType> getClasseTypes() {
        return classeTypes;
    }

    public void setClasseTypes(List<ClasseType> classeTypes) {
        this.classeTypes = classeTypes;
    }
}
