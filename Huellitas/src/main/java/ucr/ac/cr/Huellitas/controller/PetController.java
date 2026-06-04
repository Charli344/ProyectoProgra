package ucr.ac.cr.Huellitas.controller;

import org.springframework.web.bind.annotation.*;
import ucr.ac.cr.Huellitas.model.dto.PetDTO;
import ucr.ac.cr.Huellitas.service.PetService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/pets")
public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping
    public ResponseEntity<?> getAllPets() {
        return ResponseEntity.ok(petService.getAllPets());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPetById(@PathVariable Integer id) {
        return ResponseEntity.ok(petService.getPetById(id));
    }

    @PostMapping
    public ResponseEntity<?> createPet(@Valid @RequestBody PetDTO petDTO) {
        return ResponseEntity.ok(petService.createPet(petDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePet(@PathVariable Integer id, @Valid @RequestBody PetDTO petDTO) {
        return ResponseEntity.ok(petService.updatePet(id, petDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePet(@PathVariable Integer id) {
        petService.deletePet(id);
        return ResponseEntity.ok("Mascota eliminada correctamente");
    }
}
