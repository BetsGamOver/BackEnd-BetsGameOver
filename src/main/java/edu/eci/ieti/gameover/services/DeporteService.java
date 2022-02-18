package edu.eci.ieti.gameover.services;

import edu.eci.ieti.gameover.dto.DeporteDto;
import edu.eci.ieti.gameover.model.Deporte;
import edu.eci.ieti.gameover.persistence.GameOverException;
import edu.eci.ieti.gameover.persistence.GameoverPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeporteService {
    @Autowired
    GameoverPersistence gameoverPersistence;

    public Deporte addSport(DeporteDto deporteDto) throws GameOverException{
        return gameoverPersistence.addSport(deporteDto);
    }

    public Deporte getSportByID(String id) throws  GameOverException{
        return gameoverPersistence.getSportByID(id);
    }

    public List<Deporte> getAllSports(){
        return gameoverPersistence.getAllSports();
    }

    public Boolean deleteSport(String id) throws GameOverException{
        return gameoverPersistence.deleteSport(id);
    }

}
