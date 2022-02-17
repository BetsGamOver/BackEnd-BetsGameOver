package edu.eci.ieti.gameover.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import edu.eci.ieti.gameover.model.Partida;

import java.util.Date;
import java.util.List;

public interface PartidaRepository extends MongoRepository<Partida, String>{
    List<Partida> findPartidaByDate(Date fecha);

}
