package edu.unbosque.jdbctutorial.dtos;

public class Pet {

    private Integer petId;
    private String name;
    private String species;
    private Integer ownerId;

    public Pet(Integer petId, String name, String species, Integer ownerId) {
        this.petId = petId;
        this.name = name;
        this.species = species;
        this.ownerId = ownerId;
    }

    public Integer getPetId() {
        return petId;
    }

    public void setPetId(Integer petId) {
        this.petId = petId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }
}
