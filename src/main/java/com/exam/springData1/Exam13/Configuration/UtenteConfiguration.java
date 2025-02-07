package com.exam.springData1.Exam13.Configuration;


import com.exam.springData1.Exam13.Models.Utente;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class UtenteConfiguration {
    @Bean
    // @Scope("prototype") qui commento lo scope e lascio il default singleton perchè non istanzierò più oggetti di tipo e1
    public Utente u1() {
        return new Utente("Chiara Serena", "Di Maio", "nonosarechiamarmichiaretta@mail.com");
    }

    @Bean
    public Utente u2() {
        return new Utente("Nikolò", "Bitros", "skibidi@mail.com");
    }

    @Bean
    public Utente u3() {
        return new Utente("Andrea", "Azimonti", "hostudiatomedicinaperaprirelepersone@mail.com");
    }

    @Bean
    public Utente u4() {
        return new Utente("Claudia", "Paglialonga", "ibassiconquisterannoilmondo@mail.com");
    }

    @Bean
    public Utente u5() {
        return new Utente("Adele", "Gropplero", "ijustknoweverything@mail.com");
    }

    @Bean
    public Utente u6() {
        return new Utente("Anna", "Negro", "èclodlapiùsottona@mail.com");
    }

    @Bean
    public Utente u7() {
        return new Utente("Marta", "Maiocchi", "domaniconcentrate@mail.com");
    }

    @Bean
    @Scope("prototype")
    public Utente utente() {
        return new Utente();
    }
}
