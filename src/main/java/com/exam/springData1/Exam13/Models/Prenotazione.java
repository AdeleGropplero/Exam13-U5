package com.exam.springData1.Exam13.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
    @Column(name = "data_prenotazione")
    private LocalDate dataPrenotazione;
    @Column(name = "scadenza_prenotazione")
    private LocalDate scadenzaPrenotazione;
    @ManyToOne
    @JoinColumn(name = "utente_id", nullable = false)
    @ToString.Exclude
    private Utente utente;
    @ManyToOne
    @JoinColumn(name = "postazione_id", nullable = false)
    @ToString.Exclude
    private Postazione postazione;

    public Prenotazione(LocalDate dataPrenotazione, Utente utente, Postazione postazione) {
        this.dataPrenotazione = dataPrenotazione;
        this.utente = utente;
        this.postazione = postazione;
        this.scadenzaPrenotazione = dataPrenotazione.plusDays(1);
    }
}
