package edu.eci.ieti.gameover.repository;

import edu.eci.ieti.gameover.model.Equipo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EquipoRepository extends MongoRepository<Equipo, String> {
}
