package edu.eci.ieti.gameover.services;

import edu.eci.ieti.gameover.dto.EquipoDto;
import edu.eci.ieti.gameover.model.Equipo;
import edu.eci.ieti.gameover.persistence.GameOverException;
import edu.eci.ieti.gameover.persistence.GameoverPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipoService {

    @Autowired
    GameoverPersistence gameoverPersistence;

    public Equipo addTeam(EquipoDto equipoDto) throws GameOverException{
        return gameoverPersistence.addTeam(equipoDto);
    }

    public Equipo getTeamByID(String id) throws  GameOverException{
        return gameoverPersistence.getTeamByID(id);
    }

    public List<Equipo> getAllTeams(){
        return gameoverPersistence.getAllTeams();
    }

    public Boolean deleteTeam(String id) throws  GameOverException{
        return gameoverPersistence.deleteTeam(id);
    }

    public Equipo updateTeam(EquipoDto equipoDto, String Id) throws GameOverException{
        return gameoverPersistence.updateTeam(equipoDto,Id);
    }


}
