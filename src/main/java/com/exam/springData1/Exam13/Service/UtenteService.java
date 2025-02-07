package com.exam.springData1.Exam13.Service;

import com.exam.springData1.Exam13.Exceptions.ValidityException;
import com.exam.springData1.Exam13.Models.Utente;
import com.exam.springData1.Exam13.Repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtenteService {
    @Autowired
    private UtenteRepository utenteRepository;

    //JPA Method:
    public void insertUtente(Utente utente){
        if (utenteRepository.existsByEmail(utente.getEmail())){
            throw new ValidityException("La mail " + utente.getEmail() + " ha già un account associato nel DataBase");
        }else {
            utenteRepository.save(utente);
            System.out.println("Utente: " + utente.getNome() + " " + utente.getCognome() +" aggiunto al database!");
        }
    }
}
