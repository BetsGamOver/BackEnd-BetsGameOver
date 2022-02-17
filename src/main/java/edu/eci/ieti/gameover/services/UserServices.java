package edu.eci.ieti.gameover.services;

import edu.eci.ieti.gameover.model.Usuario;
import edu.eci.ieti.gameover.persistence.GameOverException;
import edu.eci.ieti.gameover.persistence.GameoverPersistence;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServices {
    @Autowired
    GameoverPersistence gameoverPersistence;

    public Usuario getUserByUsername(String username) throws GameOverException {
        return gameoverPersistence.getUserByUsername(username);
    }





}
