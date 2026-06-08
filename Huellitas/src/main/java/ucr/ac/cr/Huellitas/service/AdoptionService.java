package ucr.ac.cr.Huellitas.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucr.ac.cr.Huellitas.model.Adoption;
import ucr.ac.cr.Huellitas.model.AdoptionStatus;
import ucr.ac.cr.Huellitas.model.Pet;
import ucr.ac.cr.Huellitas.model.User;
import ucr.ac.cr.Huellitas.model.dto.AdoptionDTO;
import ucr.ac.cr.Huellitas.model.PetStatus;
import ucr.ac.cr.Huellitas.repository.AdoptionJpaRepository;
import ucr.ac.cr.Huellitas.repository.PetJpaRepository;
import ucr.ac.cr.Huellitas.repository.UserJpaRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class AdoptionService {
    @Autowired
    private AdoptionJpaRepository repository;
    @Autowired
    private UserJpaRepository userJpaRepository;
    @Autowired
    private PetJpaRepository petJpaRepository;

    public List<Adoption> getAll(){
        return repository.findAll();
    }

    public Adoption getById(Integer id){
        return repository.findById(id).orElse(null);
    }

    public List<Adoption> getUserHistory(Integer userId){
        return repository.findByUserId(userId);
    }

    public Adoption rejectAdoption(Integer id){
        Adoption adoption = repository.findById(id).orElse(null);
        if (adoption == null){
            return null;
        }
        if (adoption.getStatus() != AdoptionStatus.PENDIENTE){
            return null;
        }
        adoption.setStatus(AdoptionStatus.RECHAZADA);
        return repository.save(adoption);
    }

    @Transactional
    public Adoption approveAdoption(Integer id){
        Adoption adoption = repository.findById(id).orElse(null);
        if (adoption ==null){
            return null;
        }
        if (adoption.getStatus() != AdoptionStatus.PENDIENTE){
            return null;
        }
        adoption.setStatus(AdoptionStatus.APROBADA);
        repository.save(adoption);
        Pet pet = adoption.getPet();
        pet.setAdoptionStatus(PetStatus.ADOPTADA);
        petJpaRepository.save(pet);
        List<Adoption> requestsAdoption = repository.findByPetId(pet.getId());
        for (Adoption requests : requestsAdoption){
            if (!requests.getId().equals(adoption.getId())&& requests.getStatus()== AdoptionStatus.PENDIENTE){
                requests.setStatus(AdoptionStatus.RECHAZADA);
                repository.save(requests);
            }
        }
        return repository.save(adoption);
    }

    public Adoption requestAdoption(AdoptionDTO adoptionDTO){
        User user = userJpaRepository.findById(adoptionDTO.getUserId()).orElse(null);
        if (user == null){
            return null;
        }
        Pet pet = petJpaRepository.findById(adoptionDTO.getPetId()).orElse(null);
        if (pet == null){
            return null;
        }
        if (pet.getAdoptionStatus() == PetStatus.ADOPTADA){
            return null;
        }
        if (!repository.findByUserIdAndPetId(adoptionDTO.getUserId(), adoptionDTO.getPetId()).isEmpty()){
            return null;
        }
        Adoption adoption = new Adoption();
        adoption.setUser(user);
        adoption.setPet(pet);
        adoption.setDate(LocalDate.now());
        adoption.setStatus(AdoptionStatus.PENDIENTE);
        return repository.save(adoption);
    }
}
