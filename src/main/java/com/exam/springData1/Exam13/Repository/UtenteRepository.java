package com.exam.springData1.Exam13.Repository;

import com.exam.springData1.Exam13.Models.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, Integer> {
    boolean existsByEmail(String email);

    Utente findByEmail(String email);
}
