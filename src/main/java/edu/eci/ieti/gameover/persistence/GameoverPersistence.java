package edu.eci.ieti.gameover.persistence;

import edu.eci.ieti.gameover.dto.DeporteDto;
import edu.eci.ieti.gameover.dto.EquipoDto;
import edu.eci.ieti.gameover.model.Deporte;
import edu.eci.ieti.gameover.model.Equipo;
import edu.eci.ieti.gameover.model.Partida;
import edu.eci.ieti.gameover.model.Usuario;

import java.util.List;

import java.util.HashMap;
import java.util.Date;
import java.util.List;

public interface GameoverPersistence {

    List<Partida> findPartidaByDateAndActivo(Date fecha);

    List<Partida> getAllPartidas();

    Usuario saveUser(Usuario usuario);

    Usuario getUserByUsername(String username) throws GameOverException;

    void updateUser(Usuario user) throws GameOverException;

    Equipo addTeam(EquipoDto equipoDto) throws GameOverException;

    Equipo getTeamByID(String id) throws GameOverException;

    List<Equipo> getAllTeams();

    Boolean deleteTeam(String id) throws GameOverException;

    Equipo updateTeam(EquipoDto equipoDto, String Id) throws GameOverException;

    Deporte addSport(DeporteDto deporteDto) throws GameOverException;

    Deporte getSportByID(String id) throws GameOverException;

    List<Deporte> getAllSports();

    Boolean deleteSport(String id) throws  GameOverException;


    List<String> findResult(Usuario user) throws GameOverException;

}
