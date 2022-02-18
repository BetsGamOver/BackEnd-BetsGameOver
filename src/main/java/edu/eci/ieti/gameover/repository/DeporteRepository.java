package edu.eci.ieti.gameover.repository;

import edu.eci.ieti.gameover.model.Deporte;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DeporteRepository extends MongoRepository<Deporte, String> {
}
