package com.example.Taller.controllers;

import com.example.Taller.entites.Pet;
import com.example.Taller.entites.Veterinarian;
import com.example.Taller.services.PetService;
import com.example.Taller.services.VeterinarianService;
import com.example.Taller.responses.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veterinarians")
public class VeterinarianController {

    @Autowired
    private VeterinarianService veterinarianService;
    @Autowired
    private PetService petService;
    @GetMapping
    public ResponseEntity<Object> findAll() {
        try {
            List<Veterinarian> result = veterinarianService.findAll();
            return ResponseHandler.generateResponse("Success", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Integer id) {
        try {
            Veterinarian result = veterinarianService.findById(id);
            if (result != null) {
                return ResponseHandler.generateResponse("Success", HttpStatus.OK, result);
            } else {
                return ResponseHandler.generateResponse("Veterinarian not found", HttpStatus.NOT_FOUND, null);
            }
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody Veterinarian veterinarian) {
        try {
            Veterinarian savedVeterinarian = veterinarianService.save(veterinarian);
            return ResponseHandler.generateResponse("Success", HttpStatus.CREATED, savedVeterinarian);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }
    @PutMapping("/addPet/{veterinarianId}/{petId}")
    public ResponseEntity<Object> addPet(@PathVariable Integer veterinarianId, @PathVariable Integer petId) {
        try{
            Veterinarian veterinarian = veterinarianService.findById(veterinarianId);
            Pet  pet = petService.findById(petId);
            if(veterinarian != null && pet != null){
                Veterinarian result = veterinarianService.addPet(veterinarianId,petId);
                return ResponseHandler.generateResponse("Success", HttpStatus.OK, result);
            }else{
                return ResponseHandler.generateResponse("Not found elements", HttpStatus.NOT_FOUND, null );
            }
        }catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null );
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable Integer id) {
        try {
            veterinarianService.deleteById(id);
            return ResponseHandler.generateResponse("Veterinarian deleted successfully", HttpStatus.OK, null);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Veterinarian> updateVeterinarian(@PathVariable Integer id, @RequestBody Veterinarian updatedVeterinarian) {
        Veterinarian veterinarian = veterinarianService.update(id, updatedVeterinarian);
        return ResponseEntity.ok().body(veterinarian);
    }
}
