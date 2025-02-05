package fr.amakibo.lirafus.app.dto;

import java.util.List;

public class ClasseDTO {

    private String name;
    private String primaryColor;
    private String secondaryColor;
    private String urlProfilePicture;
    private String urlCharacterPicture;
    private String urlBackgroundPicture;
    private String overview;
    private String nickname1;
    private String nickname2;
    private List<String> types;

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

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }
}
