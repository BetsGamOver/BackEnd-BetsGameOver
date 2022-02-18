package edu.eci.ieti.gameover.controllers;

import edu.eci.ieti.gameover.model.Partida;
import edu.eci.ieti.gameover.model.Usuario;
import edu.eci.ieti.gameover.persistence.GameOverException;
import edu.eci.ieti.gameover.services.GameoverServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import java.util.Date;

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

    @GetMapping("/partidasRecientes")
    public List<Partida> findPartidaByDateAndActivo(@PathVariable Date fecha) {
        return gameoverService.findPartidaByDateAndActivo(fecha);
    }

    @GetMapping( "/{name}" )
    public Usuario findByName(@PathVariable String name) throws GameOverException {
        return gameoverService.getUserByUsername(name);
    }

    @PutMapping()
    public void update(@RequestBody Usuario usuario) throws GameOverException {
        gameoverService.updateUser(usuario);
    }


}
