package com.exam.springData1.Exam13.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "prenotazioni")
public class Prenotazione {
    @Id
    @GeneratedValue
    private Long id;
    private LocalDate data_prenotazione;
    private LocalDate scadenza_prenotazione;
    @ManyToOne
    @JoinColumn(name = "utente_id", nullable = false)
    private Utente utente;
    @ManyToOne
    @JoinColumn(name = "postazione_id", nullable = false)
    private Postazione postazione;

    public Prenotazione(LocalDate data_prenotazione, Utente utente, Postazione postazione) {
        this.data_prenotazione = data_prenotazione;
        this.utente = utente;
        this.postazione = postazione;
        this.scadenza_prenotazione = data_prenotazione.plusDays(1);
    }
}
