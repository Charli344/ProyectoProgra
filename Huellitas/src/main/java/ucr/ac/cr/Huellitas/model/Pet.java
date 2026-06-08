package ucr.ac.cr.Huellitas.model;

import jakarta.persistence.*;

@Entity
@Table(name="tb_pets")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String species;
    private String breed;
    private Integer age;
    private String sex;
    private String description;
    @Enumerated(EnumType.STRING)
    private PetStatus adoptionStatus;
    private String photo;

    public Pet() {
    }

    public Pet(Integer id, String name, String species, String breed, Integer age, String sex, String description, PetStatus adoptionStatus, String photo) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.breed = breed;
        this.age = age;
        this.sex = sex;
        this.description = description;
        this.adoptionStatus = adoptionStatus;
        this.photo = photo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PetStatus getAdoptionStatus() {
        return adoptionStatus;
    }

    public void setAdoptionStatus(PetStatus adoptionStatus) {
        this.adoptionStatus = adoptionStatus;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
