package com.example.Taller.services;

import com.example.Taller.entites.Pet;
import com.example.Taller.entites.Veterinarian;
import com.example.Taller.repositories.VeterinarianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VeterinarianService {

    @Autowired
    private VeterinarianRepository veterinarianRepository;
    @Autowired
    private PetService petService;

    public List<Veterinarian> findAll() {
        return veterinarianRepository.findAll();
    }

    public Veterinarian save(Veterinarian veterinarian) {
        // Inicializa la lista de mascotas como vacía para evitar que se cree automáticamente una mascota
        veterinarian.setPets(new ArrayList<>());

        return veterinarianRepository.save(veterinarian);
    }
    public Veterinarian findById(Integer id) {
        Optional<Veterinarian> optional = veterinarianRepository.findById(id);
        return optional.orElse(null);
    }
    public Veterinarian addPet(Integer idVeterinarian, Integer idPet) {
        Pet pet = petService.findById(idPet);
        Veterinarian veterinarian = veterinarianRepository.findById(idVeterinarian)
                .orElseThrow(() -> new RuntimeException("Veterinarian not found with ID: " + idVeterinarian));

        List<Pet> pets = veterinarian.getPets();
        pets.add(pet);
        veterinarian.setPets(pets);

        // Guardar el veterinario actualizado
        return veterinarianRepository.save(veterinarian);
    }

    public void deleteById(Integer id) {
        veterinarianRepository.deleteById(id);
    }
}
