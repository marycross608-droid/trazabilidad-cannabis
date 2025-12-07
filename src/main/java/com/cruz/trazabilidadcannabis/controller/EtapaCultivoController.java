package com.cruz.trazabilidadcannabis.controller;

import com.cruz.trazabilidadcannabis.domain.EtapaCultivo;
import com.cruz.trazabilidadcannabis.service.EtapaCultivoService;
import jakarta.validation.Valid;
import com.cruz.trazabilidadcannabis.controller.dto.CrearEtapaRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/api/etapas")
public class EtapaCultivoController {

    private final EtapaCultivoService service;

    public EtapaCultivoController(EtapaCultivoService service) {
        this.service = service;
    }

    // Endpoint GET para listar todas las etapas
    @GetMapping
    public List<EtapaCultivo> listar() {
        return service.listarTodas();
    }

    // Endpoint POST para JSON (Postman, fetch)
    @PostMapping
    public ResponseEntity<EtapaCultivo> crear(@RequestBody @Valid CrearEtapaRequest request) {
        EtapaCultivo etapa = service.crear(
                request.getNombreEtapa(),
                request.getFechaInicio(),
                request.getFechaFin()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(etapa);
    }

    // Endpoint POST para formulario HTML (form-urlencoded)
    @PostMapping(consumes = "application/x-www-form-urlencoded")
    public ResponseEntity<EtapaCultivo> crearDesdeFormulario(
            @RequestParam String nombreEtapa,
            @RequestParam String fechaInicio,
            @RequestParam(required = false) String fechaFin) {

        // Convertir Strings a LocalDate
        LocalDate inicio = LocalDate.parse(fechaInicio, DateTimeFormatter.ISO_DATE);
        LocalDate fin = (fechaFin != null && !fechaFin.isEmpty())
                ? LocalDate.parse(fechaFin, DateTimeFormatter.ISO_DATE)
                : null;

        EtapaCultivo etapa = service.crear(
                nombreEtapa,
                inicio,
                fin
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(etapa);
    }
}