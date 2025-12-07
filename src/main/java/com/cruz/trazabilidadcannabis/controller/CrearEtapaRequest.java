package com.cruz.trazabilidadcannabis.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "CrearEtapaRequest", description = "Datos necesarios para crear una etapa de cultivo")
public class CrearEtapaRequest {

    @NotBlank(message = "El nombre de la etapa es obligatorio")
    @Schema(description = "Nombre de la etapa", example = "Siembra", required = true)
    private String nombreEtapa;

    @NotNull(message = "La fecha de inicio es obligatoria")
    @Schema(description = "Fecha de inicio en formato yyyy-MM-dd", example = "2025-12-04", required = true)
    private LocalDate fechaInicio;

    @Schema(description = "Fecha de fin en formato yyyy-MM-dd (opcional)", example = "2025-12-20")
    private LocalDate fechaFin; // opcional

    // Getters y setters
    public String getNombreEtapa() { return nombreEtapa; }
    public void setNombreEtapa(String nombreEtapa) { this.nombreEtapa = nombreEtapa; }

    public LocalDate getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(LocalDate fechaInicio) { this.fechaInicio = fechaInicio; }

    public LocalDate getFechaFin() { return fechaFin; }
    public void setFechaFin(LocalDate fechaFin) { this.fechaFin = fechaFin; }
}