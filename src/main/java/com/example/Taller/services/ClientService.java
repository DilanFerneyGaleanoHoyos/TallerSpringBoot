package com.example.Taller.services;



import com.example.Taller.entites.Client;
import com.example.Taller.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

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
        clientRepository.deleteById(id);
    }
}
