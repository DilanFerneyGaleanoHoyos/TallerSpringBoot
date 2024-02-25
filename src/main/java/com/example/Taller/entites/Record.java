package com.example.Taller.entites;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table (name = "record")
public class Record implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false, length = 20)
    private String vaccinationCard;

    @Column(nullable = false, length = 20)
    private String testResults;
    @OneToOne
    @JoinColumn(name = "pet_id", referencedColumnName = "id")
    private Pet pet;

    public Record() {
    }

    public Record(int id, Pet pet, String vaccinationCard, String testResults) {
        this.id = id;
        this.pet = pet;
        this.vaccinationCard = vaccinationCard;
        this.testResults = testResults;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public String getVaccinationCard() {
        return vaccinationCard;
    }

    public void setVaccinationCard(String vaccinationCard) {
        this.vaccinationCard = vaccinationCard;
    }

    public String getTestResults() {
        return testResults;
    }

    public void setTestResults(String testResults) {
        this.testResults = testResults;
    }
}
