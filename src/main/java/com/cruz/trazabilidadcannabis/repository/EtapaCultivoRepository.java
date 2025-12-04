package com.cruz.trazabilidadcannabis.repository;

import com.cruz.trazabilidadcannabis.domain.EtapaCultivo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtapaCultivoRepository extends JpaRepository<EtapaCultivo, Integer> {
    boolean existsByNombreEtapa(String nombreEtapa);
}