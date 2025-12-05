package com.cruz.trazabilidadcannabis.api;

import com.cruz.trazabilidadcannabis.domain.EtapaCultivo;
import com.cruz.trazabilidadcannabis.service.EtapaCultivoService;
import jakarta.validation.Valid;
import com.cruz.trazabilidadcannabis.api.dto.CrearEtapaRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.List;

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
    @PostMapping
    public ResponseEntity<EtapaCultivo> crear(@RequestBody @Valid CrearEtapaRequest request) {
        EtapaCultivo etapa = service.crear(
                request.getNombreEtapa(),
                request.getFechaInicio(),
                request.getFechaFin()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(etapa);
    }
}