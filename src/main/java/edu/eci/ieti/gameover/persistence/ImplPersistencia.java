package edu.eci.ieti.gameover.persistence;

import edu.eci.ieti.gameover.dto.DeporteDto;
import edu.eci.ieti.gameover.dto.EquipoDto;
import edu.eci.ieti.gameover.model.Deporte;
import edu.eci.ieti.gameover.model.Equipo;
import edu.eci.ieti.gameover.model.Partida;
import edu.eci.ieti.gameover.model.Usuario;
import edu.eci.ieti.gameover.repository.BetRepository;
import edu.eci.ieti.gameover.repository.DeporteRepository;
import edu.eci.ieti.gameover.repository.EquipoRepository;
import edu.eci.ieti.gameover.repository.UserRepository;
import edu.eci.ieti.gameover.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ImplPersistencia implements GameoverPersistence {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BetRepository betRepository;

    @Autowired
    private EquipoRepository equipoRepository;

    @Autowired
    private DeporteRepository deporteRepository;

    @Autowired
    private PartidaRepository partidaRepository;

    @Override
    public Usuario saveUser(Usuario usuario){
        String pwd = usuario.getPassword();
        String encrypt = bCryptPasswordEncoder.encode(pwd);
        usuario.setPassword(encrypt);
        userRepository.save(usuario);
        return usuario;
    }

    @Override
    public Usuario getUserByUsername(String username) throws GameOverException {
        List<Usuario> allUsers = userRepository.findAll();
        System.out.println(username);
        Usuario usuario = null;
        for(int i =0;i<allUsers.size();i++){
            System.out.println(allUsers.get(i).toString());
            if(allUsers.get(i).username.equals(username)){
                System.out.println("Entre acá");
                usuario = allUsers.get(i);
            }
        }
        if(usuario == null){
            throw new GameOverException(GameOverException.USERNAME_NOT_FOUND);
        }

        return usuario;
    }


    @Override
    public void updateUser(Usuario user) throws GameOverException {
        Usuario oldUser = getUserByUsername(user.username);
        oldUser.changeValues(user);
        userRepository.save(oldUser);
    }

    @Override
    public Equipo addTeam(EquipoDto equipoDto) throws GameOverException {
        return equipoRepository.save(new Equipo(equipoDto));
    }

    @Override
    public Equipo getTeamByID(String id) throws GameOverException{
        Optional<Equipo> optionalEquipo = equipoRepository.findById(id);
        if(optionalEquipo.isPresent()){
            return optionalEquipo.get();
        }
        else {
            throw new GameOverException(GameOverException.TEAM_NOT_FOUND);
        }
    }

    @Override
    public List<Equipo> getAllTeams() {
        return equipoRepository.findAll();
    }

    @Override
    public Boolean deleteTeam(String id) throws GameOverException{
        if(equipoRepository.existsById(id))
        {
            equipoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Equipo updateTeam(EquipoDto equipoDto, String Id) throws GameOverException{
        if (equipoRepository.findById(Id).isPresent())
        {
            Equipo equipo = equipoRepository.findById(Id).get();
            equipo.update(equipoDto);
            equipoRepository.save(equipo);
            return equipo;
        }
        return null;
    }

    @Override
    public Deporte addSport(DeporteDto deporteDto) throws GameOverException {
        return deporteRepository.save(new Deporte(deporteDto));
    }

    @Override
    public Deporte getSportByID(String id) throws GameOverException {
        Optional<Deporte> optionalDeporte = deporteRepository.findById(id);
        if(optionalDeporte.isPresent()){
            return optionalDeporte.get();
        }
        else {
            throw new GameOverException(GameOverException.SPORT_NOT_FOUND);
        }
    }

    @Override
    public List<Deporte> getAllSports() {
        return deporteRepository.findAll();
    }

    @Override
    public Boolean deleteSport(String id) throws GameOverException {
        if(deporteRepository.existsById(id))
        {
            deporteRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<String> findResult(Usuario user) throws GameOverException {
        List<Partida> resultados = user.getResultados();
        List<String> marcadores = new ArrayList<String>();
        for(Partida p: resultados){
            marcadores.add(p.getMarcador());
        }
        return marcadores;
    }

    public List<Partida> findPartidaByDateAndActivo(Date fecha) {
        List<Partida> partidas = getAllPartidas();
        Date hoy = new Date();
        List<Partida> pActuales = new ArrayList<>();
        for (Partida partida : partidas) {
            if(partida.getFecha() == hoy && partida.isActivo() == true){
                pActuales.add(partida);
            }

        }
        return pActuales;
    }

    @Override
    public List<Partida> getAllPartidas() {
        return partidaRepository.findAll();
    }
}
