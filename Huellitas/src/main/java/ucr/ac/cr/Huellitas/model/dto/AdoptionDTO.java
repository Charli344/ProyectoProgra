package ucr.ac.cr.Huellitas.model.dto;

import jakarta.validation.constraints.NotNull;

public class AdoptionDTO {
    @NotNull(message = "Debe introducir un usuario")
    private Integer userId;
    @NotNull(message = "Debe introducir una mascota")
    private Integer petId;

    public AdoptionDTO() {
    }

    public AdoptionDTO(Integer userId, Integer petId) {
        this.userId = userId;
        this.petId = petId;
    }

    public Integer getPetId() {
        return petId;
    }

    public void setPetId(Integer petId) {
        this.petId = petId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
