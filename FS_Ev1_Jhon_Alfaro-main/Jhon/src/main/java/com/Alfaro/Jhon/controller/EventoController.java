package com.Alfaro.Jhon.controller;

import com.Alfaro.Jhon.model.Evento;
import com.Alfaro.Jhon.model.EventoDTO;
import com.Alfaro.Jhon.service.EventoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("api/v1/eventos")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @GetMapping
    public List<Evento> getEventos() {
        return eventoService.readAll();
    }

    @PostMapping
    public ResponseEntity<?> postEvento(@Valid @RequestBody Evento evento) {
        Evento nuevo = eventoService.create(evento);
        if(nuevo != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Evento creado con exito");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al registrar evento");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEvento(@PathVariable Long id) {
        eventoService.delete(id);
        return ResponseEntity.ok("Evento eliminado");
    }

    @GetMapping("seed")
    public void seed() {
        eventoService.seed();
    }

    @GetMapping("reporte")
    public List<EventoDTO> getReporte() {
        return eventoService.reporte();
    }
}