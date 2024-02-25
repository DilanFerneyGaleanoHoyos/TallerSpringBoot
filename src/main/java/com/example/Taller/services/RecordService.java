package com.example.Taller.services;

import com.example.Taller.entites.Pet;
import com.example.Taller.entites.Record;
import com.example.Taller.repositories.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecordService {

    @Autowired
    private RecordRepository recordRepository;
    @Autowired
    private PetService petService;
    public List<Record> findAll() {
        return recordRepository.findAll();
    }

    public Record save(Record record, Integer petId) {
        // Verificar si ya existe un registro para la mascota
        Optional<Record> existingRecord = recordRepository.findByPetId(petId);
        if (existingRecord.isPresent()) {
            throw new IllegalArgumentException("A record already exists for the specified pet.");
        }

        // Si no existe, guardar el nuevo registro
        return recordRepository.save(record);
    }
    public Record findById(Integer id) {
        Optional<Record> optional = recordRepository.findById(id);
        return optional.orElse(null);
    }

    public void deleteById(Integer id) {
        recordRepository.deleteById(id);
    }
}
