package com.exam.springData1.Exam13.Repository;

import com.exam.springData1.Exam13.Models.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Integer> {

    //Questo metodo mi permette di gestire la logica delle date di prenotazione.
    boolean existsByPostazioneIdAndDataPrenotazione(Integer postazioneId, LocalDate dataPrenotazione);

}
