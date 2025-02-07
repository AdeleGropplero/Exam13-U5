package com.exam.springData1.Exam13.Runner;


import com.exam.springData1.Exam13.Exceptions.ValidityException;
import com.exam.springData1.Exam13.Models.Edificio;
import com.exam.springData1.Exam13.Repository.EdificioRepository;
import com.exam.springData1.Exam13.Service.EdificioService;
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
    //Iniezione Edifici


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




    }
}
