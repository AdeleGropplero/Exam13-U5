package com.exam.springData1.Exam13.Service;

import com.exam.springData1.Exam13.Enum.TipoPostazione;
import com.exam.springData1.Exam13.Exceptions.ValidityException;
import com.exam.springData1.Exam13.Models.Edificio;
import com.exam.springData1.Exam13.Models.Postazione;
import com.exam.springData1.Exam13.Repository.EdificioRepository;
import com.exam.springData1.Exam13.Repository.PostazioneRepository;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class PostazioneService {
    @Autowired
    private PostazioneRepository postazioneRepository;
    @Autowired
    private EdificioRepository edificioRepository;

    //JPA Method:
    public void insertPostazione(Postazione postazione){
        if (postazioneRepository.existsByNome(postazione.getNome())){
            throw new ValidityException("La postazione " + postazione.getNome() + " è già presente in DataBase");
        }else {
            postazioneRepository.save(postazione);
            System.out.println("Postazione: " + postazione.getNome() + " aggiunta al database!");
        }
    }

    //----------------------------------------------------
    //Ora provo a istanziare e salvare nel DB nuovi oggetti con i costruttori vuoti.
    @Autowired
    @Qualifier("postazione")
    ObjectProvider<Postazione> postazioneProvider;

    public Postazione createPostazione(String description, TipoPostazione tipo, int nMaxPartecipanti, String nomeEdificio){
        Postazione p = postazioneProvider.getObject();
        p.setDescription(description);
        p.setTipo_postazione(tipo);
        p.setNum_max_partecipanti(nMaxPartecipanti);

        Edificio edificio = edificioRepository.findByNome(nomeEdificio);
        // Associo l'edificio a postazione come necessario
        if (edificio != null) {
            p.setEdificio(edificio);
        }
        p.setNome(tipo + "_" + nomeEdificio);
        return p;
    }
    //Teniamo valido l'insert edificio di prima

}
