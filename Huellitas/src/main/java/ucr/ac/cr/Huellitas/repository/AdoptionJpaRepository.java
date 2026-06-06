package ucr.ac.cr.Huellitas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ucr.ac.cr.Huellitas.model.Adoption;

public interface AdoptionJpaRepository extends JpaRepository<Adoption, Integer> {
}
