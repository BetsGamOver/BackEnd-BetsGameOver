package edu.eci.ieti.gameover.services;


import edu.eci.ieti.gameover.model.Usuario;
import edu.eci.ieti.gameover.persistence.GameOverException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServices extends UserServices{

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;



    public void addUser(Usuario usuario) {

        gameoverPersistence.saveUser(usuario);
    }


    public boolean login(String username,String password) throws GameOverException {
        Usuario user = gameoverPersistence.getUserByUsername(username);
        return bCryptPasswordEncoder.matches(password,user.password);

    }


}

