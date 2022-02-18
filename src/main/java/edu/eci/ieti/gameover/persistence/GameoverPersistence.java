package edu.eci.ieti.gameover.persistence;

import edu.eci.ieti.gameover.model.Partida;
import edu.eci.ieti.gameover.model.Usuario;

import java.util.HashMap;
import java.util.Date;
import java.util.List;

public interface GameoverPersistence {

    List<Partida> findPartidaByDateAndActivo(Date fecha);

    List<Partida> getAllPartidas();

    Usuario saveUser(Usuario usuario);

    Usuario getUserByUsername(String username) throws GameOverException;

    void updateUser(Usuario user) throws GameOverException;

    List<String> findResult(Usuario user) throws GameOverException;

}
