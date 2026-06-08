package ucr.ac.cr.Huellitas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucr.ac.cr.Huellitas.model.Pet;
import ucr.ac.cr.Huellitas.model.dto.PetDTO;
import ucr.ac.cr.Huellitas.repository.PetJpaRepository;

import java.util.List;

@Service
public class PetService {
    @Autowired
    private final PetJpaRepository petJpaRepository;

    public PetService(PetJpaRepository petJpaRepository) {
        this.petJpaRepository = petJpaRepository;
    }

    public List<Pet> getAllPets() {
        return petJpaRepository.findAll();
    }

    public Pet getPetById(Integer id) {
        return petJpaRepository.findById(id).orElse(null);
    }

    public Pet createPet(PetDTO petDTO) {
        Pet pet = new Pet();
        pet.setName(petDTO.getName());
        pet.setSpecies(petDTO.getSpecies());
        pet.setBreed(petDTO.getBreed());
        pet.setAge(petDTO.getAge());
        pet.setSex(petDTO.getSex());
        pet.setDescription(petDTO.getDescription());
        pet.setAdoptionStatus(petDTO.getAdoptionStatus());
        pet.setPhoto(petDTO.getPhoto());
        return petJpaRepository.save(pet);
    }

    public Pet updatePet(Integer id, PetDTO petDTO) {
        Pet pet = getPetById(id);
        if (pet == null) {
            return null;
        }
        pet.setName(petDTO.getName());
        pet.setSpecies(petDTO.getSpecies());
        pet.setBreed(petDTO.getBreed());
        pet.setAge(petDTO.getAge());
        pet.setSex(petDTO.getSex());
        pet.setDescription(petDTO.getDescription());
        pet.setAdoptionStatus(petDTO.getAdoptionStatus());
        pet.setPhoto(petDTO.getPhoto());
        return petJpaRepository.save(pet);
    }

    public void deletePet(Integer id) {
        Pet pet = getPetById(id);
        if (pet != null) {
            petJpaRepository.delete(pet);
        }
    }
}