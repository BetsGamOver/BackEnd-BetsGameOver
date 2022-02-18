package edu.eci.ieti.gameover.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import edu.eci.ieti.gameover.model.Partida;


public interface PartidaRepository extends MongoRepository<Partida, String>{

}
