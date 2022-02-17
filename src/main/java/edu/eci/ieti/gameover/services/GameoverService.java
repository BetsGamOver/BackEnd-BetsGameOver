package edu.eci.ieti.gameover.services;

import edu.eci.ieti.gameover.model.Partida;
import edu.eci.ieti.gameover.persistence.GameoverPersistence;

import java.util.Date;
import java.util.List;

public class GameoverService {
    GameoverPersistence gameoverPersistence;
        public List<Partida> findPartidaByDateAndActivo(Date fecha){
            return gameoverPersistence.findPartidaByDateAndActivo(fecha);
        }

        public List<Partida> getAllPartidas(){
            return gameoverPersistence.getAllPartidas();
        }
}
