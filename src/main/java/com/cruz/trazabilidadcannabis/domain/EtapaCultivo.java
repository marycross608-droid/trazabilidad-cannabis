package com.cruz.trazabilidadcannabis.domain;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "EtapaCultivo")
public class EtapaCultivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEtapa")
    private Integer idEtapa;

    @Column(name = "nombreEtapa", nullable = false, length = 100)
    private String nombreEtapa;

    @Column(name = "fechaInicio", nullable = false)
    private LocalDate fechaInicio;

    @Column(name = "fechaFin")
    private LocalDate fechaFin;

    @Column(name = "fechaRegistro", insertable = false, updatable = false)
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