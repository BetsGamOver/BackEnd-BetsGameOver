package edu.eci.ieti.gameover.controllers;

import edu.eci.ieti.gameover.dto.EquipoDto;
import edu.eci.ieti.gameover.model.Deporte;
import edu.eci.ieti.gameover.model.Equipo;
import edu.eci.ieti.gameover.persistence.GameOverException;
import edu.eci.ieti.gameover.services.DeporteService;
import edu.eci.ieti.gameover.services.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/team")
public class TeamController {
    @Autowired
    private EquipoService equipoService;

    @GetMapping
    public List<Equipo> all()
    {
        return equipoService.getAllTeams();
    }

    @GetMapping( "/{id}" )
    public Equipo findById( @PathVariable String id ) throws GameOverException {
        return equipoService.getTeamByID(id);
    }

    @PostMapping
    public ResponseEntity<Equipo> create(@RequestBody EquipoDto equipoDto ) throws GameOverException {
        return ResponseEntity.ok( equipoService.addTeam(equipoDto));
    }

    @PutMapping( "/{id}" )
    public ResponseEntity<Equipo> update( @RequestBody EquipoDto equipoDto, @PathVariable String id ) throws GameOverException {
        return ResponseEntity.ok( equipoService.updateTeam(equipoDto, id));
    }

    @DeleteMapping( "/{id}" )
    public ResponseEntity<Boolean> delete( @PathVariable String id ) throws GameOverException {
        return ResponseEntity.ok( equipoService.deleteTeam(id) );
    }

}
