package com.exam.springData1.Exam13.Service;

import com.exam.springData1.Exam13.Exceptions.ValidityException;
import com.exam.springData1.Exam13.Models.Prenotazione;
import com.exam.springData1.Exam13.Repository.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrenotazioneService {
    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    //JPA Method:

    public void insertPrenotazione(Prenotazione prenotazione) {
        if (prenotazioneRepository.existsByPostazioneIdAndDataPrenotazione(prenotazione.getPostazione().getId(), prenotazione.getDataPrenotazione())){
            throw new ValidityException("La postazione " + prenotazione.getPostazione().getNome() + " è già prenotata per la data selezionata: " + prenotazione.getDataPrenotazione());
        }else {
            prenotazioneRepository.save(prenotazione);
        }
        System.out.println("Nuova prenotazione con id " + prenotazione.getId() + " salvata con successo!");
    }
}
