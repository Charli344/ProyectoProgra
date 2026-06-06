package ucr.ac.cr.Huellitas.model.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;

public class PetDTO {

    @NotBlank(message = "El nombre de la mascota no puede quedar en blanco")
    private String name;

    @NotBlank(message = "La especie no puede quedar en blanco")
    private String species;

    @NotBlank(message = "La raza no puede quedar en blanco")
    private String breed;

    @NotNull(message = "La edad no puede quedar vacía")
    @Min(value = 0, message = "La edad no puede ser negativa")
    private Integer age;

    @NotBlank(message = "El sexo no puede quedar en blanco")
    private String sex;

    @NotBlank(message = "La descripción no puede quedar en blanco")
    private String description;

    @NotNull(message = "El estado de adopción no puede quedar en blanco")
    private PetStatus adoptionStatus;

    private String photo;

    public PetDTO() {
    }

    public PetDTO(String name, String species, String breed, Integer age, String sex,
                  String description, PetStatus adoptionStatus, String photo) {
        this.name = name;
        this.species = species;
        this.breed = breed;
        this.age = age;
        this.sex = sex;
        this.description = description;
        this.adoptionStatus = adoptionStatus;
        this.photo = photo;
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

