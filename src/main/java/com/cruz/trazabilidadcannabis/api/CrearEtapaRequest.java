package com.cruz.trazabilidadcannabis.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public class CrearEtapaRequest {
    @NotBlank(message = "El nombre de la etapa es obligatorio")
    private String nombreEtapa;

    @NotNull(message = "La fecha de inicio es obligatoria")
    private LocalDate fechaInicio;

   private LocalDate fechaFin; // opcional

    // Getters y setters
    public String getNombreEtapa() { return nombreEtapa; }
    public void setNombreEtapa(String nombreEtapa) { this.nombreEtapa = nombreEtapa; }

    public LocalDate getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(LocalDate fechaInicio) { this.fechaInicio = fechaInicio; }

    public LocalDate getFechaFin() { return fechaFin; }
    public void setFechaFin(LocalDate fechaFin) { this.fechaFin = fechaFin; }
}