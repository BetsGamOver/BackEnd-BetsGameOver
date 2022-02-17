package edu.eci.ieti.gameover.services;

import edu.eci.ieti.gameover.model.Partida;

import java.util.Date;
import java.util.List;

public interface GameoverService {

    List<Partida> findPartidaByDateAndActivo(Date fecha);
    List<Partida> getAll();
}
