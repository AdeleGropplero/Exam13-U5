package com.exam.springData1.Exam13.Service;

import com.exam.springData1.Exam13.Models.Prenotazione;
import com.exam.springData1.Exam13.Repository.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrenotazioneService {
    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    //JPA Method:

    public void insertPrenotazione(Prenotazione prenotazione){

        prenotazioneRepository.save(prenotazione);

        System.out.println("Nuova prenotazione con id " + prenotazione.getId() + " salvata con successo!");
    }


}
