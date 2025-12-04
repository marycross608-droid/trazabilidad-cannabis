package com.cruz.trazabilidadcannabis.service;

import com.cruz.trazabilidadcannabis.domain.EtapaCultivo;
import com.cruz.trazabilidadcannabis.repository.EtapaCultivoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EtapaCultivoService {

    private final EtapaCultivoRepository repository;

    public EtapaCultivoService(EtapaCultivoRepository repository) {
        this.repository = repository;
    }

    // Método para listar todas las etapas
    public List<EtapaCultivo> listarTodas() {
        return repository.findAll();
    }

    // Método para crear una nueva etapa
    public EtapaCultivo crear(String nombreEtapa, LocalDate fechaInicio, LocalDate fechaFin) {
        if (nombreEtapa == null || nombreEtapa.isBlank()) {
            throw new IllegalArgumentException("El nombre de la etapa es obligatorio");
        }
        if (repository.existsByNombreEtapa(nombreEtapa)) {
            throw new IllegalArgumentException("Ya existe una etapa con el mismo nombre");
        }
        EtapaCultivo etapa = new EtapaCultivo();
        etapa.setNombreEtapa(nombreEtapa);
        etapa.setFechaInicio(fechaInicio);
        etapa.setFechaFin(fechaFin);
        return repository.save(etapa);
    }
}