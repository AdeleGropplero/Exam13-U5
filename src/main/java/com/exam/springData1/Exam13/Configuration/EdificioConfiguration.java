package com.exam.springData1.Exam13.Configuration;

import com.exam.springData1.Exam13.Models.Edificio;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class EdificioConfiguration {

    @Bean
    // @Scope("prototype") qui commento lo scope e lascio il default singleton perchè non istanzierò più oggetti di tipo e1
    public Edificio e1(){
        return new Edificio("Palazzo Alto", "Via dei papaveri 6", "Milano");
    }

    @Bean
    public Edificio e2(){
        return new Edificio("White Palace", "Viale Antico Testamento 8", "Roma");
    }

    @Bean
    public Edificio e3(){
        return new Edificio("Bosco Invernale", "Viale degli illusi 43", "Padova");
    }

    @Bean
    public Edificio e4(){
        return new Edificio("Adelaide Bonvicini", "Corso delle Regine 25", "Bologna");
    }

    @Bean
    @Scope("prototype") //qui invece lascio prototype perchè così avrò la possibilità di istanziare più oggetti edificio.
    public Edificio edificio(){
        return new Edificio();
    }//mi creo un bean con costruttore vuoto così da poterlo
    // usare all'occasione qual'ora volessi istanziarmi un nuovo oggetto Edificio.

}
