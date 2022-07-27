package tech.noetzold.pitacocode.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AlertaService extends JpaRepository<Alerta, Long> {
    @Query("select p from Alerta p where p.pcId = ?1")
    List<Alerta> findAllByPcId(String pcId);
}
