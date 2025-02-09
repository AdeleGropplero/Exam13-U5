package com.exam.springData1.Exam13.Service;

import com.exam.springData1.Exam13.Exceptions.ValidityException;
import com.exam.springData1.Exam13.Models.Edificio;
import com.exam.springData1.Exam13.Repository.EdificioRepository;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.Query;
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

    //----------------------------------------------------
    //Ora provo a istanziare e salvare nel DB nuovi oggetti con i costruttori vuoti.
    @Autowired
    @Qualifier ("edificio")
    ObjectProvider<Edificio> edificioProvider;

    public Edificio createEdificio(String nome, String indirizzo, String citta){
        Edificio e = edificioProvider.getObject();
        e.setNome(nome);
        e.setIndirizzo(indirizzo);
        e.setCitta(citta);
        return e;
    }
    //Teniamo valido l'insert edificio di prima


}
