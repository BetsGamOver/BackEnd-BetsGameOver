package edu.eci.ieti.gameover.controllers;

import edu.eci.ieti.gameover.model.Usuario;
import edu.eci.ieti.gameover.persistence.GameOverException;
import edu.eci.ieti.gameover.services.GameoverServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


@RestController
@RequestMapping("/gameover")
public class GameOverController extends BaseController{
    @Autowired
    GameoverServices gameoverServices = null;


    @RequestMapping("/helloworld")
    public String helloWorld(){
        return gameoverServices.helloWorld();
    }

    @GetMapping( "/{name}" )
    public Usuario findByName(@PathVariable String name) throws GameOverException {
        return gameoverServices.getUserByUsername(name);
    }

    @PutMapping()
    public void update(@RequestBody Usuario usuario) throws GameOverException {
        gameoverServices.updateUser(usuario);
    }


}
