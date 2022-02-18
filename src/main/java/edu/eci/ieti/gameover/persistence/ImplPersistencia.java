package edu.eci.ieti.gameover.persistence;

import edu.eci.ieti.gameover.model.Partida;
import edu.eci.ieti.gameover.model.Usuario;
import edu.eci.ieti.gameover.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ImplPersistencia implements GameoverPersistence {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BetRepository betRepository;

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
