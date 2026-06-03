package ucr.ac.cr.Huellitas.repository;

import ucr.ac.cr.Huellitas.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpaRepository extends JpaRepository <User, Integer> {
    boolean existsByEmail(String email);
}
