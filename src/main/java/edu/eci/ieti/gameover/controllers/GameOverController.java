package edu.eci.ieti.gameover.controllers;

import edu.eci.ieti.gameover.model.Partida;
import edu.eci.ieti.gameover.services.GameoverService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/v1/partida")
public class GameOverController {
    GameoverService gameoverService;

    @GetMapping
    public List<Partida> getAll(){
        return gameoverService.getAll();
    }

    @GetMapping()
    public List<Partida> findPartidaByDateAndActivo(@PathVariable Date fecha){
        return gameoverService.findPartidaByDateAndActivo(fecha);
    }
}
