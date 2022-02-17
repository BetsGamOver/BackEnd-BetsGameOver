package edu.eci.ieti.gameover.services;


import edu.eci.ieti.gameover.model.*;
import edu.eci.ieti.gameover.persistence.GameOverException;
import edu.eci.ieti.gameover.persistence.GameoverPersistence;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class GameoverServices extends UserServices{
<<<<<<< HEAD
=======
    GameoverPersistence gameoverPersistence;

    public String helloWorld(){

        return "Hello World Hola Mundo";
    }
>>>>>>> 1d8221f9c4c0540a6d242e91133cc27ddedb224b

    public void updateUser(Usuario user) throws GameOverException {
        gameoverPersistence.updateUser(user);
    }

    public List<Partida> findPartidaByDateAndActivo(Date fecha){
        return gameoverPersistence.findPartidaByDateAndActivo(fecha);
    }

    public List<Partida> getAllPartidas(){
        return gameoverPersistence.getAllPartidas();
    }
}
