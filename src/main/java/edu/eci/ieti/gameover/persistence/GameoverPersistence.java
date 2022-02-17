package edu.eci.ieti.gameover.persistence;

import edu.eci.ieti.gameover.model.Partida;
import java.util.Date;
import java.util.List;


public interface GameoverPersistence {
    List<Partida> findPartidaByDateAndActivo(Date fecha);
    List<Partida> getAllPartidas();
}
