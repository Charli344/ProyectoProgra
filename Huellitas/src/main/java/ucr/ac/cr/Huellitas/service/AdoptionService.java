package ucr.ac.cr.Huellitas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucr.ac.cr.Huellitas.repository.AdoptionJpaRepository;
import ucr.ac.cr.Huellitas.repository.PetJpaRepository;
import ucr.ac.cr.Huellitas.repository.UserJpaRepository;

@Service
public class AdoptionService {

    @Autowired
    private AdoptionJpaRepository repository;

    @Autowired
    private UserJpaRepository userJpaRepository;

    @Autowired
    private PetJpaRepository petJpaRepository;


}
