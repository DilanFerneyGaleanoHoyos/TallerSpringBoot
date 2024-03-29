package com.example.Taller.repositories;

import com.example.Taller.entites.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RecordRepository extends JpaRepository<Record, Integer> {
    Optional<Record> findByPetId(Integer petId);
}
