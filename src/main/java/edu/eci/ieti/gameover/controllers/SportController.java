package edu.eci.ieti.gameover.controllers;

import edu.eci.ieti.gameover.dto.DeporteDto;
import edu.eci.ieti.gameover.dto.EquipoDto;
import edu.eci.ieti.gameover.model.Deporte;
import edu.eci.ieti.gameover.model.Equipo;
import edu.eci.ieti.gameover.persistence.GameOverException;
import edu.eci.ieti.gameover.services.DeporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sport")
public class SportController {
    @Autowired
    private DeporteService deporteService;

    @GetMapping
    public List<Deporte> all()
    {
        return deporteService.getAllSports();
    }

    @GetMapping( "/{id}" )
    public Deporte findById( @PathVariable String id ) throws GameOverException {
        return deporteService.getSportByID(id);
    }

    @PostMapping
    public ResponseEntity<Deporte> create(@RequestBody DeporteDto deporteDto ) throws GameOverException {
        return ResponseEntity.ok( deporteService.addSport(deporteDto));
    }

    @DeleteMapping( "/{id}" )
    public ResponseEntity<Boolean> delete( @PathVariable String id ) throws GameOverException {
        return ResponseEntity.ok( deporteService.deleteSport(id));
    }
}
