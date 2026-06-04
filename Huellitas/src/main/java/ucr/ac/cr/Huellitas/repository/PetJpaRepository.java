package ucr.ac.cr.Huellitas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ucr.ac.cr.Huellitas.model.Pet;

public interface PetJpaRepository extends JpaRepository<Pet, Integer> {
}