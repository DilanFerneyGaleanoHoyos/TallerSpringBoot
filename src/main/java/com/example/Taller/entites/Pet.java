package com.example.Taller.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;

import java.util.List;

@Entity
@Table(name = "pet")
public class Pet implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;




    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false, length = 20)
    private String species;


    @Column(nullable = false)
    private String dateOfBirth;

    @OneToOne(mappedBy = "pet")
    @JsonIgnore
    private Record record;


    @ManyToMany(mappedBy = "pets")
    @JsonIgnore
    private List<Veterinarian> veterinarians;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    @JsonIgnore
    private Client client;


    public Pet() {
    }

    public Pet(int id, String name, String species, String dateOfBirth, Record record, Client client) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.dateOfBirth = dateOfBirth;
        this.record = record;

        this.client = client;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }



    public Record getRecord() {
        return record;
    }

    public void setRecord(Record record) {
        this.record = record;
    }



    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<Veterinarian> getVeterinarians() {
        return veterinarians;
    }

    public void setVeterinarians(List<Veterinarian> veterinarians) {
        this.veterinarians = veterinarians;
    }


}
