package com.example.Taller.controllers;

import com.example.Taller.entites.Pet;
import com.example.Taller.entites.Record;
import com.example.Taller.responses.ResponseHandler;
import com.example.Taller.services.PetService;
import com.example.Taller.services.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/records")
public class RecordController {

    @Autowired
    private RecordService recordService;

    @Autowired
    private PetService petService;

    @GetMapping
    public ResponseEntity<Object> findAll() {
        try {
            List<Record> result = recordService.findAll();
            return ResponseHandler.generateResponse("Success", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Integer id) {
        try {
            Record result = recordService.findById(id);
            if (result != null) {
                return ResponseHandler.generateResponse("Success", HttpStatus.OK, result);
            } else {
                return ResponseHandler.generateResponse("Record not found", HttpStatus.NOT_FOUND, null);
            }
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @PostMapping("/{petId}")
    public ResponseEntity<Object> save(@RequestBody Record record, @PathVariable Integer petId) {
        try {
            // Buscar la mascota correspondiente al ID proporcionado
            Pet pet = petService.findById(petId);
            if (pet == null) {
                return ResponseHandler.generateResponse("Pet not found", HttpStatus.NOT_FOUND, null);
            }

            // Establecer la mascota en el registro
            record.setPet(pet);

            // Guardar el registro
            Record savedRecord = recordService.save(record, petId);
            return ResponseHandler.generateResponse("Success", HttpStatus.CREATED, savedRecord);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable Integer id) {
        try {
            recordService.deleteById(id);
            return ResponseHandler.generateResponse("Record deleted successfully", HttpStatus.OK, null);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }
}
