package edu.eci.ieti.gameover.persistence;

import edu.eci.ieti.gameover.model.Partida;
import edu.eci.ieti.gameover.repository.PartidaRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ImplPersistence implements GameoverPersistence {
    private PartidaRepository partidaRepository;
    @Override
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
