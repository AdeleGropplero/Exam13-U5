package com.exam.springData1.Exam13.Repository;

import com.exam.springData1.Exam13.Models.Postazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PostazioneRepository extends JpaRepository<Postazione, Integer> {
    boolean existsByNome(String nome);

    Postazione findByNome(String nome);
}
