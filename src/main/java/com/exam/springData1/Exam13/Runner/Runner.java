package com.exam.springData1.Exam13.Runner;


import com.exam.springData1.Exam13.Exceptions.ValidityException;
import com.exam.springData1.Exam13.Models.Edificio;
import com.exam.springData1.Exam13.Models.Postazione;
import com.exam.springData1.Exam13.Models.Prenotazione;
import com.exam.springData1.Exam13.Models.Utente;
import com.exam.springData1.Exam13.Repository.EdificioRepository;
import com.exam.springData1.Exam13.Service.EdificioService;
import com.exam.springData1.Exam13.Service.PostazioneService;
import com.exam.springData1.Exam13.Service.PrenotazioneService;
import com.exam.springData1.Exam13.Service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component //I runners hanno l'annotation component DA NON DIMENTICARE ASSOLUTAMENTE
public class Runner implements CommandLineRunner {
    //----------------------------------------------------------------------------
    //Faccio l'autowired con le classi Service.

    @Autowired
    private EdificioService edificioService;
    @Autowired
    private PostazioneService postazioneService;
    @Autowired
    private UtenteService utenteService;
    @Autowired
    private PrenotazioneService prenotazioneService;


    //----------------------------------------------------------------------------
    //Iniezione Edifici
    @Autowired
    @Qualifier("e1")
    private Edificio e1;
    @Autowired
    @Qualifier("e2")
    private Edificio e2;
    @Autowired
    @Qualifier("e3")
    private Edificio e3;
    @Autowired
    @Qualifier("e4")
    private Edificio e4;
    //----------------------------------------------------------------------------
    //Iniezione Postazioni
    @Autowired
    @Qualifier("p1e1")
    private Postazione p1e1;
    @Autowired
    @Qualifier("p2e1")
    private Postazione p2e1;
    @Autowired
    @Qualifier("p3e1")
    private Postazione p3e1;
    @Autowired
    @Qualifier("p1e2")
    private Postazione p1e2;
    @Autowired
    @Qualifier("p2e2")
    private Postazione p2e2;
    @Autowired
    @Qualifier("p3e2")
    private Postazione p3e2;
    @Autowired
    @Qualifier("p1e3")
    private Postazione p1e3;
    @Autowired
    @Qualifier("p2e3")
    private Postazione p2e3;
    @Autowired
    @Qualifier("p3e3")
    private Postazione p3e3;
    @Autowired
    @Qualifier("p1e4")
    private Postazione p1e4;
    @Autowired
    @Qualifier("p2e4")
    private Postazione p2e4;
    @Autowired
    @Qualifier("p3e4")
    private Postazione p3e4;
    //----------------------------------------------------------------------------
    //Iniezione Utenti
    @Autowired
    @Qualifier("u1")
    private Utente u1;
    @Autowired
    @Qualifier("u2")
    private Utente u2;
    @Autowired
    @Qualifier("u3")
    private Utente u3;
    @Autowired
    @Qualifier("u4")
    private Utente u4;
    @Autowired
    @Qualifier("u5")
    private Utente u5;
    @Autowired
    @Qualifier("u6")
    private Utente u6;
    @Autowired
    @Qualifier("u7")
    private Utente u7;
    //----------------------------------------------------------------------------
    //Iniezione Prenotazioni
    @Autowired
    @Qualifier("p1")
    private Prenotazione p1;
    @Autowired
    @Qualifier("p2")
    private Prenotazione p2;
    @Autowired
    @Qualifier("p3")
    private Prenotazione p3;
    //----------------------------------------------------------------------------
    @Override
    public void run(String... args) throws Exception {

        //Aggiunta al database di edifici
        List<Edificio> listaEdifici = List.of(e1, e2, e3, e4);
        for (int i = 0; i < listaEdifici.size(); i++) { //ho scorporato il for in modo che faccia la verifica su
            System.out.println("------------------");   // tutti gli edifici in lista.
            try {
                edificioService.insertEdificio(listaEdifici.get(i));
            } catch (ValidityException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("------------------");
        //----------------------------------------------------

        //Aggiunta al database di postazioni
        List<Postazione> listaPostazioni = List.of(p1e1, p2e1, p3e1, p1e2, p2e2, p3e2, p1e3, p2e3, p3e3, p1e4, p2e4, p3e4);
        for (Postazione postazione : listaPostazioni) {
            System.out.println("------------------");
            try {
                // Verifico che la postazione abbia un Edificio associato
                if (postazione.getEdificio() == null) {
                    System.out.println("Errore: Edificio non trovato per la postazione.");
                } else {
                    postazioneService.insertPostazione(postazione);
                }
            } catch (ValidityException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("------------------");
        //----------------------------------------------------

        List<Utente> listaUtenti = List.of(u1, u2, u3, u4, u5, u6, u7);
        for (Utente utente : listaUtenti) {
            System.out.println("------------------");
            try {
                utenteService.insertUtente(utente);
            } catch (ValidityException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("------------------");

        //----------------------------------------------------

        List<Prenotazione> listaPrenotazioni = List.of(p1, p2, p3);
        for (Prenotazione prenotazione : listaPrenotazioni) {
            System.out.println("------------------");
            try {
                prenotazioneService.insertPrenotazione(prenotazione);
            } catch (ValidityException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("------------------");

    }
}
