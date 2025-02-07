package com.exam.springData1.Exam13.Service;

import com.exam.springData1.Exam13.Exceptions.ValidityException;
import com.exam.springData1.Exam13.Models.Edificio;
import com.exam.springData1.Exam13.Repository.EdificioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class EdificioService {
    @Autowired
    private EdificioRepository edificioRepository;


    //JPA Method:
    public void insertEdificio(Edificio edificio){
        if (edificioRepository.existsByNome(edificio.getNome())){
            throw new ValidityException("L'edificio " + edificio.getNome() + " è già presente in DataBase");
        }else {
            edificioRepository.save(edificio);
            System.out.println(edificio.getNome() + " aggiunto al database!");
        }
    }


}
