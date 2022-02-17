package edu.eci.ieti.gameover.services.impl;

import edu.eci.ieti.gameover.model.Partida;
import edu.eci.ieti.gameover.repository.PartidaRepository;
import edu.eci.ieti.gameover.services.GameoverService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GameoverServiceImpl implements GameoverService {
    private PartidaRepository partidaRepository;
    @Override
    public List<Partida> findPartidaByDateAndActivo(Date fecha) {
        List<Partida> partidas = getAll();
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
    public List<Partida> getAll() {
        return partidaRepository.findAll();
    }

}
