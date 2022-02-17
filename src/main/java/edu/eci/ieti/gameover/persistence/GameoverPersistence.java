package edu.eci.ieti.gameover.persistence;

import edu.eci.ieti.gameover.model.Partida;
import edu.eci.ieti.gameover.model.Usuario;

<<<<<<< HEAD
import java.util.HashMap;
=======
import java.util.Date;
import java.util.List;

>>>>>>> 1d8221f9c4c0540a6d242e91133cc27ddedb224b

public interface GameoverPersistence {
    List<Partida> findPartidaByDateAndActivo(Date fecha);

    List<Partida> getAllPartidas();

    void saveUser(Usuario usuario);

    Usuario getUserByUsername(String username) throws GameOverException;

    void updateUser(Usuario user) throws GameOverException;

<<<<<<< HEAD
    HashMap<String, String> findResult(Usuario user) throws GameOverException;
=======
>>>>>>> 1d8221f9c4c0540a6d242e91133cc27ddedb224b
}
