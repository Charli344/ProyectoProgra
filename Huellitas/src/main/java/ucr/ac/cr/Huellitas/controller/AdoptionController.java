package ucr.ac.cr.Huellitas.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import ucr.ac.cr.Huellitas.model.Adoption;
import ucr.ac.cr.Huellitas.model.dto.AdoptionDTO;
import ucr.ac.cr.Huellitas.service.AdoptionService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/adoptions")
public class AdoptionController {

    @Autowired
    private AdoptionService service;

    @GetMapping("/getAll")
    public ResponseEntity<List<Adoption>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id){
        Adoption adoption = service.getById(id);
        if (adoption == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("La solicitud no existe");
        }
        return ResponseEntity.ok(adoption);
    }

    @GetMapping("/history/{userId}")
    public ResponseEntity<List<Adoption>> getUserHistory(@PathVariable Integer userId){
        return ResponseEntity.ok(service.getUserHistory(userId));
    }

    @PostMapping("/request")
    public ResponseEntity<?> requestAdoption(@Valid @RequestBody AdoptionDTO adoptionDTO, BindingResult result){
        if (result.hasErrors()){
            List<String> errors = new ArrayList<>();
            for (ObjectError error : result.getAllErrors()) {
                errors.add(error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errors);
        }
        Adoption adoption = service.requestAdoption(adoptionDTO);
        if (adoption == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No fue posible registrar la solicitud");
        }
        return ResponseEntity.ok("Solicitud enviada con exito");
    }

    @PatchMapping("/approve/{id}")
    public ResponseEntity<?> approveAdoption(@PathVariable Integer id) {
        Adoption adoption = service.approveAdoption(id);
        if (adoption == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("La solicitud no existe o ya fue procesada");
        }
        return ResponseEntity.ok("Solicitud aprobada exitosamente");
    }

    @PatchMapping("/reject/{id}")
    public ResponseEntity<?> rejectAdoption(@PathVariable Integer id) {
        Adoption adoption = service.rejectAdoption(id);
        if (adoption == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("La solicitud no existe o ya fue procesada");
        }
        return ResponseEntity.ok("Solicitud rechazada exitosamente");
    }
}
