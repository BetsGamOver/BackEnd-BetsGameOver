package edu.eci.ieti.gameover.persistence;

import edu.eci.ieti.gameover.model.Usuario;

import java.util.HashMap;

public interface GameoverPersistence {

    void saveUser(Usuario usuario);

    Usuario getUserByUsername(String username) throws GameOverException;

    void updateUser(Usuario user) throws GameOverException;

    HashMap<String, String> findResult(Usuario user) throws GameOverException;
}
