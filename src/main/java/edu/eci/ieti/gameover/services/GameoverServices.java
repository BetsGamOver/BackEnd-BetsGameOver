package edu.eci.ieti.gameover.services;


import edu.eci.ieti.gameover.model.*;
import edu.eci.ieti.gameover.persistence.GameOverException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GameoverServices extends UserServices{


    public String helloWorld(){

        return "Hello World Hola Mundo";
    }

    public void updateUser(Usuario user) throws GameOverException {
        gameoverPersistence.updateUser(user);

    }
}
