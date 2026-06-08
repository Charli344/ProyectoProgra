package ucr.ac.cr.Huellitas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ucr.ac.cr.Huellitas.model.Adoption;
import ucr.ac.cr.Huellitas.model.AdoptionStatus;

import java.util.List;

@Repository
public interface AdoptionJpaRepository extends JpaRepository<Adoption, Integer> {
    List<Adoption> findByUserId(Integer userId);
    List<Adoption> findByStatus(AdoptionStatus status);
    List<Adoption> findByUserIdAndPetId(Integer userId, Integer petId);
    List<Adoption> findByPetId(Integer petId);
}
