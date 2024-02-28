package com.example.Taller.services;



import com.example.Taller.entites.Client;
import com.example.Taller.entites.Pet;
import com.example.Taller.repositories.ClientRepository;
import com.example.Taller.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private PetRepository petRepository;
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public Client save(Client client) {
        // Inicializa la lista de mascotas como vacía para evitar que se cree automáticamente una mascota
        client.setPets(new ArrayList<>());

        return clientRepository.save(client);
    }

    public Client findById(Integer id) {
        Optional<Client> optional = clientRepository.findById(id);
        return optional.orElse(null);
    }

    public void deleteById(Integer id) {
        // Buscar al cliente por su ID
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found with ID: " + id));

        // Eliminar las asociaciones de las mascotas con el cliente
        List<Pet> pets = client.getPets();
        for (Pet pet : pets) {
            pet.setClient(null); // Desvincular la mascota del cliente
            petRepository.save(pet); // Guardar la mascota actualizada
        }

        // Finalmente, eliminar al cliente
        clientRepository.deleteById(id);
    }
    public Client update(Integer id, Client updatedClient) {
        Client existingClient = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found with ID: " + id));

        existingClient.setName(updatedClient.getName());
        existingClient.setEmail(updatedClient.getEmail());
        existingClient.setPhone(updatedClient.getPhone());


        return clientRepository.save(existingClient);
    }
}
