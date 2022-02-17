package edu.eci.ieti.gameover.controllers;

import edu.eci.ieti.gameover.model.Partida;
import edu.eci.ieti.gameover.services.GameoverService;
import edu.eci.ieti.gameover.model.Usuario;
import edu.eci.ieti.gameover.persistence.GameOverException;
import edu.eci.ieti.gameover.services.GameoverServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/gameover")
public class GameOverController {

    @Autowired
    GameoverServices gameoverService;

    @RequestMapping("/helloworld")
    public String helloWorld() {
        return gameoverService.helloWorld();
    }

    @GetMapping
    public List<Partida> getAll(){
        return gameoverService.getAllPartidas();
    }

    @GetMapping()
    public List<Partida> findPartidaByDateAndActivo(@PathVariable Date fecha) {
        return gameoverService.findPartidaByDateAndActivo(fecha);
    }
}
