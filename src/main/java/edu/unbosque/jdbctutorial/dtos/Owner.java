package edu.unbosque.jdbctutorial.dtos;

public class Owner {

    private Integer idNumer;
    private String email;
    private String fullName;

    public Owner(Integer idNumer, String email, String fullName) {
        this.idNumer = idNumer;
        this.email = email;
        this.fullName = fullName;
    }

    public Integer getIdNumer() {
        return idNumer;
    }

    public void setIdNumer(Integer idNumer) {
        this.idNumer = idNumer;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
