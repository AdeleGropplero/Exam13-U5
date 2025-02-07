package com.exam.springData1.Exam13.Service;

import com.exam.springData1.Exam13.Exceptions.ValidityException;
import com.exam.springData1.Exam13.Models.Edificio;
import com.exam.springData1.Exam13.Models.Postazione;
import com.exam.springData1.Exam13.Repository.PostazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class PostazioneService {
    @Autowired
    private PostazioneRepository postazioneRepository;

    //JPA Method:
    public void insertPostazione(Postazione postazione){
        if (postazioneRepository.existsByNome(postazione.getNome())){
            throw new ValidityException("La postazione " + postazione.getNome() + " è già presente in DataBase");
        }else {
            postazioneRepository.save(postazione);
            System.out.println("Postazione: " + postazione.getNome() + " aggiunta al database!");
        }
    }

}
