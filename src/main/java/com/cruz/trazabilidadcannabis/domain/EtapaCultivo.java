package com.cruz.trazabilidadcannabis.domain;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name = "EtapaCultivo")
@Schema(name = "EtapaCultivo", description = "Etapa de cultivo registrada en el sistema")
public class EtapaCultivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEtapa")
    @Schema(description = "Identificador único de la etapa", example = "1")
    private Integer idEtapa;

    @Column(name = "nombreEtapa", nullable = false, length = 100)
    @Schema(description = "Nombre de la etapa", example = "Siembra")
    private String nombreEtapa;

    @Column(name = "fechaInicio", nullable = false)
    @Schema(description = "Fecha de inicio en formato yyyy-MM-dd", example = "2025-12-04")
    private LocalDate fechaInicio;

    @Column(name = "fechaFin")
    @Schema(description = "Fecha de fin en formato yyyy-MM-dd", example = "2025-12-20")
    private LocalDate fechaFin;

    @Column(name = "fechaRegistro", insertable = false, updatable = false)
    @Schema(description = "Fecha de registro en el sistema", example = "2025-12-06T10:15:30")
    private LocalDateTime fechaRegistro;

    // Getters y setters
    public Integer getIdEtapa() { return idEtapa; }
    public void setIdEtapa(Integer idEtapa) { this.idEtapa = idEtapa; }

    public String getNombreEtapa() { return nombreEtapa; }
    public void setNombreEtapa(String nombreEtapa) { this.nombreEtapa = nombreEtapa; }

    public LocalDate getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(LocalDate fechaInicio) { this.fechaInicio = fechaInicio; }

    public LocalDate getFechaFin() { return fechaFin; }
    public void setFechaFin(LocalDate fechaFin) { this.fechaFin = fechaFin; }

    public LocalDateTime getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(LocalDateTime fechaRegistro) { this.fechaRegistro = fechaRegistro; }
}