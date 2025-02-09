package com.exam.springData1.Exam13.Repository;

import com.exam.springData1.Exam13.Enum.TipoPostazione;
import com.exam.springData1.Exam13.Models.Postazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PostazioneRepository extends JpaRepository<Postazione, Integer> {
    boolean existsByNome(String nome);

    Postazione findByNome(String nome);
    @Query("SELECT p FROM Postazione p WHERE p.edificio.citta = :citta AND p.tipoPostazione = :tipoPostazione")
    Postazione findByCittaAndTipoPostazione(@Param("citta") String citta, @Param("tipoPostazione") TipoPostazione tipoPostazione);
}
