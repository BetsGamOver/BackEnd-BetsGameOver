package edu.eci.ieti.gameover.persistence;

import edu.eci.ieti.gameover.model.Usuario;

public interface GameoverPersistence {

    void saveUser(Usuario usuario);

    Usuario getUserByUsername(String username) throws GameOverException;

    void updateUser(Usuario user) throws GameOverException;
}
