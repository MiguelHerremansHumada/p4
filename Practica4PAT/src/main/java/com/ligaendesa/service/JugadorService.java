package com.ligaendesa.service;

import com.ligaendesa.model.Jugador;
import com.ligaendesa.repository.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JugadorService {

    @Autowired
    private JugadorRepository repository;

    public List<Jugador> findAll() {
        return repository.findAll();
    }

    public Optional<Jugador> findById(Long id) {
        return repository.findById(id);
    }

    public Jugador save(Jugador jugador) {
        return repository.save(jugador);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
