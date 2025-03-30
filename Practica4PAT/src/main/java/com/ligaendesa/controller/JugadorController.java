package com.ligaendesa.controller;

import com.ligaendesa.model.Jugador;
import com.ligaendesa.service.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jugadores")
@CrossOrigin(origins = "*")
public class JugadorController {

    @Autowired
    private JugadorService service;

    @GetMapping
    public List<Jugador> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jugador> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Jugador create(@RequestBody Jugador jugador) {
        return service.save(jugador);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Jugador> update(@PathVariable Long id, @RequestBody Jugador jugador) {
        return service.findById(id).map(j -> {
            j.setNombre(jugador.getNombre());
            j.setPosicion(jugador.getPosicion());
            j.setClub(jugador.getClub());
            j.setPuntos(jugador.getPuntos());
            return ResponseEntity.ok(service.save(j));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (service.findById(id).isPresent()) {
            service.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
