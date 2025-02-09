package com.exam.springData1.Exam13.Models;

import com.exam.springData1.Exam13.Enum.TipoPostazione;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "postazioni")
public class Postazione {
    @Id
    @GeneratedValue
    private Integer id;
    private String nome;
    private String description;
    private TipoPostazione tipoPostazione;
    private Integer num_max_partecipanti;
    @ManyToOne
    @JoinColumn(name = "edificio_id", nullable = false)
    private Edificio edificio;
    @OneToMany(mappedBy = "postazione", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Prenotazione> prenotazioni;

    public Postazione(String description, TipoPostazione tipoPostazione, Integer num_max_partecipanti, Edificio edificio) {
        this.description = description;
        this.tipoPostazione = tipoPostazione;
        this.num_max_partecipanti = num_max_partecipanti;
        this.edificio = edificio;
        this.nome= tipoPostazione + "_" + edificio.getNome();
    }
}
