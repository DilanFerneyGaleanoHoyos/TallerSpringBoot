package com.example.Taller.services;

import com.example.Taller.entites.Client;
import com.example.Taller.entites.Pet;
import com.example.Taller.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;


    @Autowired
    private ClientService clientService;




    public List<Pet> findAll() {
        return petRepository.findAll();
    }

    public Pet save(Pet pet, Integer clientId) {

        Optional<Client> optionalClient = Optional.ofNullable(clientService.findById(clientId));
        if (!optionalClient.isPresent()) {
            throw new IllegalArgumentException("Client not found with ID: " + clientId);
        }

        pet.setClient(optionalClient.get());

        return petRepository.save(pet);
    }

    public Pet findById(Integer id) {
        Optional<Pet> optional = petRepository.findById(id);
        return optional.orElse(null);
    }

    public void deleteById(Integer id) {
        petRepository.deleteById(id);
    }

    public Pet update(Pet pet) {

        Pet existingPet = petRepository.findById(pet.getId())
                .orElseThrow(() -> new RuntimeException("Pet not found with ID: " + pet.getId()));

        existingPet.setName(pet.getName());
        existingPet.setSpecies(pet.getSpecies());

        return petRepository.save(existingPet);
    }

}
