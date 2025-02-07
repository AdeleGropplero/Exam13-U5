package com.exam.springData1.Exam13.Configuration;

import com.exam.springData1.Exam13.Models.Prenotazione;
import com.exam.springData1.Exam13.Repository.PostazioneRepository;
import com.exam.springData1.Exam13.Repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class PrenotazioneConfiguration {
    @Autowired
    private PostazioneRepository postazioneRepository;

    @Autowired
    private UtenteRepository utenteRepository;

    @Bean
    public Prenotazione p1() {
        return new Prenotazione(LocalDate.now(), utenteRepository.findByEmail("nonosarechiamarmichiaretta@mail.com"), postazioneRepository.findByNome("SALA_RIUNIONI_Palazzo Alto"));
    }

    @Bean
    public Prenotazione p2() {
        return new Prenotazione(LocalDate.now(), utenteRepository.findByEmail("ibassiconquisterannoilmondo@mail.com"), postazioneRepository.findByNome("PRIVATO_White Palace"));
    }

    @Bean
    public Prenotazione p3() {
        return new Prenotazione(LocalDate.now(), utenteRepository.findByEmail("ijustknoweverything@mail.com"), postazioneRepository.findByNome("OPENSPACE_White Palace"));
    }
}
