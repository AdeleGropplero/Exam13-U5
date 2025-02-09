package com.exam.springData1.Exam13.Service;

import com.exam.springData1.Exam13.Enum.TipoPostazione;
import com.exam.springData1.Exam13.Exceptions.ValidityException;
import com.exam.springData1.Exam13.Models.Edificio;
import com.exam.springData1.Exam13.Models.Postazione;
import com.exam.springData1.Exam13.Models.Prenotazione;
import com.exam.springData1.Exam13.Models.Utente;
import com.exam.springData1.Exam13.Repository.PostazioneRepository;
import com.exam.springData1.Exam13.Repository.PrenotazioneRepository;
import com.exam.springData1.Exam13.Repository.UtenteRepository;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PrenotazioneService {
    @Autowired
    private PrenotazioneRepository prenotazioneRepository;
    @Autowired
    private PostazioneRepository postazioneRepository;
    @Autowired
    private UtenteRepository utenteRepository;

    //JPA Method:
    public void insertPrenotazione(Prenotazione prenotazione) {
        // Verifico se la postazione è già prenotata per la data
        if (prenotazioneRepository.existsByPostazioneIdAndDataPrenotazione(
                prenotazione.getPostazione().getId(), prenotazione.getDataPrenotazione())) {
            throw new ValidityException("La postazione " + prenotazione.getPostazione().getNome() + " è già prenotata per la data selezionata: " + prenotazione.getDataPrenotazione());
        }

        // Verifico se l'utente ha già una prenotazione per la stessa data
        if (prenotazioneRepository.existsByUtenteIdAndDataPrenotazione(
                prenotazione.getUtente().getId(), prenotazione.getDataPrenotazione())) {
            throw new ValidityException("L'utente con email: " + prenotazione.getUtente().getEmail() + " ha già una prenotazione per la data selezionata: " + prenotazione.getDataPrenotazione());
        }

        // Se non ci sono conflitti, salva la prenotazione
        prenotazioneRepository.save(prenotazione);
        System.out.println("Nuova prenotazione con id " + prenotazione.getId() + " salvata con successo!");
    }

    //----------------------------------------------------
    //Ora provo a istanziare e salvare nel DB nuovi oggetti con i costruttori vuoti.
    @Autowired
    @Qualifier("prenotazione")
    ObjectProvider<Prenotazione> prenotazioneProvider;

    public Prenotazione createPrenotazione(LocalDate dataPrenotazione, String email, String nomePostazione){
        Prenotazione p = prenotazioneProvider.getObject();
        p.setDataPrenotazione(dataPrenotazione);
        p.setScadenzaPrenotazione(dataPrenotazione.plusDays(1));

        Utente utente = utenteRepository.findByEmail(email);
        if (utente != null) {
            p.setUtente(utente);
        }else {
            throw new ValidityException("Utente non trovato per la presente email: " + email);
        }

        Postazione postazione = postazioneRepository.findByNome(nomePostazione);
        if (postazione != null) {
            p.setPostazione(postazione);
        }else {
            throw new ValidityException("Postazione non trovata con il seguente nome: " + nomePostazione);
        }
        return p;
    }
}
