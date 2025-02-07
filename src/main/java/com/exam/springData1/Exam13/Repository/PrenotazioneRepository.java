package com.exam.springData1.Exam13.Repository;

import com.exam.springData1.Exam13.Models.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Integer> {

}
