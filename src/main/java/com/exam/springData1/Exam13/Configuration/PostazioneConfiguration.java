package com.exam.springData1.Exam13.Configuration;

import com.exam.springData1.Exam13.Enum.TipoPostazione;
import com.exam.springData1.Exam13.Models.Edificio;
import com.exam.springData1.Exam13.Models.Postazione;
import com.exam.springData1.Exam13.Repository.EdificioRepository;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class PostazioneConfiguration {

    @Autowired
    private EdificioRepository edificioRepository;


    //----------------------------------------------------------------------------
    // Postazioni in Edificio 1

    @Bean
    public Postazione p1e1() {
        return new Postazione("La sala riunioni più in alto d'Italia, " +
                "goditi una vista incredibile su tutta Milano",
                TipoPostazione.SALA_RIUNIONI, 25, edificioRepository.findByNome("Palazzo Alto"));
    }

    @Bean
    public Postazione p2e1() {
        return new Postazione("Il locale perfetto nel palazzo più In di Milano",
                TipoPostazione.PRIVATO, 5, edificioRepository.findByNome("Palazzo Alto"));
    }

    @Bean

    public Postazione p3e1() {
        return new Postazione("Una sala ideale per eventi, teamworking o presentazioni di rilievo",
                TipoPostazione.OPENSPACE, 40, edificioRepository.findByNome("Palazzo Alto"));
    }

    //----------------------------------------------------------------------------
    // Postazioni in Edificio 2

    @Bean

    public Postazione p1e2() {
        return new Postazione("Ideale per riunioni ecclesiastiche o di stampo politico in questo palazzo dall'aspetto etereo",
                TipoPostazione.SALA_RIUNIONI, 25, edificioRepository.findByNome("White Palace"));
    }

    @Bean

    public Postazione p2e2() {
        return new Postazione("Ufficio all white per gli amanti del minimal, no i suprematisti non sono i benvenuti.",
                TipoPostazione.PRIVATO, 5, edificioRepository.findByNome("White Palace"));
    }

    @Bean

    public Postazione p3e2() {
        return new Postazione("Ospitiamo concerti privati, ed eventi di gusto, una delle sale private più grandi della capitale",
                TipoPostazione.OPENSPACE, 100, edificioRepository.findByNome("White Palace"));
    }

    //----------------------------------------------------------------------------
    // Postazioni in Edificio 3

    @Bean

    public Postazione p1e3() {
        return new Postazione("Stanza un po' tropicale, arricchita da meravigliose piante è perfetta per sentirsi sempre in contatto con la natura",
                TipoPostazione.SALA_RIUNIONI, 15, edificioRepository.findByNome("Bosco Invernale"));
    }

    @Bean

    public Postazione p2e3() {
        return new Postazione("Ufficio immersivo per chi ama la natura ma è costretto a lavorare",
                TipoPostazione.PRIVATO, 5, edificioRepository.findByNome("Bosco Invernale"));
    }

    @Bean

    public Postazione p3e3() {
        return new Postazione("Luogo perfetto per più o meno qualsiasi cosa",
                TipoPostazione.OPENSPACE, 40, edificioRepository.findByNome("Bosco Invernale"));
    }

    //----------------------------------------------------------------------------
    // Postazioni in Edificio 4

    @Bean

    public Postazione p1e4() {
        return new Postazione("Difficilmente troverete una sala dalla simile eleganza, in uno dei palazzi storici e più antichi di Bologna",
                TipoPostazione.SALA_RIUNIONI, 35, edificioRepository.findByNome("Adelaide Bonvicini"));
    }

    @Bean

    public Postazione p2e4() {
        return new Postazione("L'ufficio ideale per chi cerca un look nobile e alto locato",
                TipoPostazione.PRIVATO, 5, edificioRepository.findByNome("Adelaide Bonvicini"));
    }

    @Bean

    public Postazione p3e4() {
        return new Postazione("Perfetto per Balli in maschera della tua azienda oppure un ufficio condiviso dove il cliente sarà sicuramente felice di essere accolto",
                TipoPostazione.OPENSPACE, 80, edificioRepository.findByNome("Adelaide Bonvicini"));
    }

    //----------------------------------------------------------------------------

    @Bean
    @Scope("prototype")
    public Postazione postazione() {
        return new Postazione();
    }//mi creo un bean con costruttore vuoto così da poterlo
    // usare all'occasione qual'ora volessi istanziarmi un nuovo oggetto Postazione.

}
