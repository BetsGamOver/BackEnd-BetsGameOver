package edu.eci.ieti.gameover.controllers;

import edu.eci.ieti.gameover.model.Usuario;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

public class BaseController {
    public Usuario getCurrentUser(@AuthenticationPrincipal Usuario user) {
        return user;
    }
}
