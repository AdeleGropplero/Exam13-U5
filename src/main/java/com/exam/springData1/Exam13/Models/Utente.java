package com.exam.springData1.Exam13.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Random;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "utenti")
public class Utente {
    @Id
    @GeneratedValue
    private Long id;
    private String user_name;
    private String nome;
    private String cognome;
    private String email;
    @OneToMany(mappedBy = "utente", cascade = CascadeType.ALL)
    private List<Prenotazione> prenotazioni;

    private static final Random random = new Random();

    public Utente(String nome, String cognome, String email) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.user_name = (nome + "_" + cognome + random());
    }

    public int random() {
        return random.nextInt(1000);
    }
}
