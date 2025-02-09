package com.exam.springData1.Exam13.Runner;


import com.exam.springData1.Exam13.Enum.TipoPostazione;
import com.exam.springData1.Exam13.Exceptions.ValidityException;
import com.exam.springData1.Exam13.Models.Edificio;
import com.exam.springData1.Exam13.Models.Postazione;
import com.exam.springData1.Exam13.Models.Prenotazione;
import com.exam.springData1.Exam13.Models.Utente;
import com.exam.springData1.Exam13.Repository.EdificioRepository;
import com.exam.springData1.Exam13.Repository.PostazioneRepository;
import com.exam.springData1.Exam13.Service.EdificioService;
import com.exam.springData1.Exam13.Service.PostazioneService;
import com.exam.springData1.Exam13.Service.PrenotazioneService;
import com.exam.springData1.Exam13.Service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component //I runners hanno l'annotation component DA NON DIMENTICARE ASSOLUTAMENTE
public class Runner implements CommandLineRunner {
    Scanner sc = new Scanner(System.in);
    //----------------------------------------------------------------------------
    // 🛑IN CASO DI ERRORI ALLA COMPILAZIONE DEL DATABASE LEGGERE QUI🛑
    //----------------------------------------------------------------------------
    // Buongiorno prof, per ricreare il db sul suo pc le consiglio di procedere in questo modo:
    // Dal momento che molti oggetti dipendono da altri, così come i bean, quando manda in run
    // il programma ovviamente da errori. Bisogna Prima di tutto commentare tutto il Runner +
    // le classi Configuration di Postazione e Prenotazione (che sono quelle che danno problemi).
    // Dopo di che tornare nel runner e scommentare i metodi legati a Edificio e Utente e lanciare
    // il runner.
    // Poi scommentare Postazione e lanciare, e infine Prenotazione e lanciare.
    // In questo modo il database si ricompila senza problemi o errori.
    // Sono certa che lo sapeva già come fare ma così sono più tranquilla e se mai un giorno
    // mi riapro il programma ho un HowTo che mi rispiega come fare, visto che sicuro tra
    // qualche giorno già mi sarò scordata.
    //----------------------------------------------------------------------------
    //Faccio l'autowired con le classi Service.

    @Autowired
    private EdificioService edificioService;
    @Autowired
    private PostazioneService postazioneService;
    @Autowired
    private PostazioneRepository postazioneRepository;
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
    @Autowired
    @Qualifier("admin")
    private Utente umberto;
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
    //----------------------------------------------------------------------------
    //Override del run
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Runner...");

        System.out.println("Benvenuto sei: ");
        System.out.println("1- Utente");
        System.out.println("2- Amministratore");
        String scelta = sc.nextLine();

        switch (scelta) {
            case "1":
                ricercaUtente();
                break;

            case "2":
                System.out.println("Inserisci email dell'utente amministratore");
                String email = sc.nextLine();
                if (email.equals("umberto.emanuele@mail.com")) {
                    System.out.println("Ecco i recenti movimenti dell'app");
                    //Movimenti.
                    metodiApp();
                }
        }
    }

    public void ricercaUtente() {
        System.out.println("\nPer che città desideri prenotare?");
        System.out.println("Milano");
        System.out.println("Roma");
        System.out.println("Padova");
        System.out.println("Bologna");
        String sceltaCitta = sc.nextLine();
        System.out.println("\nChe tipo di postazione desideri prenotare?");
        System.out.println("PRIVATO");
        System.out.println("OPENSPACE");
        System.out.println("SALA_RIUNONI");
        TipoPostazione sceltaPostazione = TipoPostazione.valueOf(sc.nextLine().toUpperCase());
        if ((sceltaCitta.equals("Milano") || sceltaCitta.equals("Roma")
             || sceltaCitta.equals("Padova") || sceltaCitta.equals("Bologna")) &&
             (sceltaPostazione == TipoPostazione.PRIVATO
               || sceltaPostazione == TipoPostazione.OPENSPACE
               || sceltaPostazione == TipoPostazione.SALA_RIUNIONI)) {
            Postazione postazioneTrovata = postazioneRepository.findByCittaAndTipoPostazione(sceltaCitta, sceltaPostazione);
            System.out.println("\nEcco la postazione desiderata: ");
            System.out.println(postazioneTrovata);
        }
        //con più tempo si poteva verificare disponibilità per data o far fare la prenotazione all'utente.
    }

    public void metodiApp() {
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
        //Aggiunta al database di Utenti
        List<Utente> listaUtenti = List.of(u1, u2, u3, u4, u5, u6, u7, umberto);
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
        //Aggiunta al database di Prenotazioni
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

        //----------------------------------------------------
        //Ora provo a istanziare e salvare nel DB nuovi oggetti con i costruttori vuoti.

        try {
            edificioService.insertEdificio(edificioService.createEdificio(
                    "Tulips", "Via dei Tulipani", "Roma"));
        } catch (ValidityException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("------------------");

        try {
            postazioneService.insertPostazione(postazioneService.createPostazione(
                    "Pieno zeppo di tulipani freschi olandesi, profumatissimo!",
                    TipoPostazione.OPENSPACE, 30,
                    "Tulips")
            );
        } catch (ValidityException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("------------------");

/*        try {
            prenotazioneService.insertPrenotazione(prenotazioneService.createPrenotazione(
                    LocalDate.of(2025, 2, 19), "ijustknoweverything@mail.com", "PRIVATO_White Palace"));
        }catch (ValidityException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("------------------");*/

        try {
            prenotazioneService.insertPrenotazione(prenotazioneService.createPrenotazione(
                    LocalDate.of(2025, 2, 19), "ijustknoweverything@mail.com", "PRIVATO_Adelaide Bonvicini"));
        } catch (ValidityException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("------------------");

        try {
            prenotazioneService.insertPrenotazione(prenotazioneService.createPrenotazione(
                    LocalDate.of(2025, 2, 19), "mailNonEsistentePerVerificaErrori@mail.com", "PRIVATO_Adelaide Bonvicini"));
        } catch (ValidityException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("------------------");
    }
}
