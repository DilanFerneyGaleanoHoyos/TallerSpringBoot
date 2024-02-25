package com.example.Taller.controllers;
import com.example.Taller.entites.Pet;
import com.example.Taller.services.PetService;
import com.example.Taller.responses.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private PetService petService;

    @GetMapping
    public ResponseEntity<Object> findAll() {
        try {
            List<Pet> pets = petService.findAll();
            return ResponseHandler.generateResponse("Success", HttpStatus.OK, pets);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }



    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Integer id) {
        try {
            Pet pet = petService.findById(id);
            if (pet != null) {
                return ResponseHandler.generateResponse("Success", HttpStatus.OK, pet);
            } else {
                return ResponseHandler.generateResponse("Pet not found", HttpStatus.NOT_FOUND, null);
            }
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody Pet pet, @RequestParam Integer idCliente) {
        try {
            Pet savedPet = petService.save(pet, idCliente);
            return ResponseHandler.generateResponse("Success", HttpStatus.CREATED, savedPet);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable Integer id) {
        try {
            petService.deleteById(id);
            return ResponseHandler.generateResponse("Pet deleted successfully", HttpStatus.OK, null);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }
}
