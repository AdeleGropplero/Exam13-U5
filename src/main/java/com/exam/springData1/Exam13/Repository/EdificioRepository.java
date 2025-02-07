package com.exam.springData1.Exam13.Repository;

import com.exam.springData1.Exam13.Models.Edificio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EdificioRepository extends JpaRepository<Edificio, Integer> {

    boolean existsByNome(String nome);

    Edificio findByNome(String nome);
}
