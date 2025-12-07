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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(
        name = "Etapas de cultivo",
        description = "Operaciones para gestionar las etapas de cultivo en el sistema"
)
@RestController
@RequestMapping("/api/etapas")
public class EtapaCultivoController {
    private final EtapaCultivoService service;

    public EtapaCultivoController(EtapaCultivoService service) {
        this.service = service;
    }

    // Endpoint GET para listar todas las etapas
    @Operation(
            summary = "Listar todas las etapas de cultivo",
            description = "Devuelve una lista completa de etapas registradas en la base de datos"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Lista obtenida exitosamente",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = EtapaCultivo.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Error en la solicitud"
            )
    })
    @GetMapping
    public List<EtapaCultivo> listar() {
        return service.listarTodas();
    }

    // Endpoint POST para JSON (Postman, fetch)
    @Operation(
            summary = "Crear nueva etapa (JSON)",
            description = "Registra una etapa usando un cuerpo JSON con nombre y fechas"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "Etapa creada exitosamente",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = EtapaCultivo.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Datos inválidos"
            )
    })
    @PostMapping
    public ResponseEntity<EtapaCultivo> crear(@Valid @RequestBody CrearEtapaRequest request) {
        EtapaCultivo etapa = service.crear(
                request.getNombreEtapa(),
                request.getFechaInicio(),
                request.getFechaFin()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(etapa);
    }

    // Endpoint POST para formulario HTML (form-urlencoded)
    @Operation(
            summary = "Crear nueva etapa (formulario)",
            description = "Registra una etapa usando parámetros enviados por formulario HTML"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "Etapa creada exitosamente",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = EtapaCultivo.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Datos inválidos"
            )
    })
    @PostMapping(consumes = "application/x-www-form-urlencoded")
    public ResponseEntity<EtapaCultivo> crearDesdeFormulario(
            @RequestParam String nombreEtapa,
            @RequestParam String fechaInicio,
            @RequestParam(required = false) String fechaFin
    ) {
        LocalDate inicio = LocalDate.parse(fechaInicio, DateTimeFormatter.ISO_DATE);
        LocalDate fin = (fechaFin != null && !fechaFin.isEmpty())
                ? LocalDate.parse(fechaFin, DateTimeFormatter.ISO_DATE)
                : null;

        EtapaCultivo etapa = service.crear(nombreEtapa, inicio, fin);
        return ResponseEntity.status(HttpStatus.CREATED).body(etapa);
    }
}