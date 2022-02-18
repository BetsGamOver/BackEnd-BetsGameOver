package edu.eci.ieti.gameover.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Document(collection = "user")
public class Usuario {

    @Id
    public String userId;
    public String username;
    public String nombreCompleto;
    public String direccionResidencia;
    public String password;
    public String email;
    public String numero;
    public List<Partida> resultados;

    public Usuario(){}

        public Usuario(String username,String nombreCompleto,String password,String email,String direccionResidencia, String numero) {
            this.username = username;
            this.nombreCompleto = nombreCompleto;
            this.password = password;
            this.email = email;
            this.direccionResidencia = direccionResidencia;
            this.numero = numero;
            List<Partida> resultados = new ArrayList<Partida>();
        }

    public void addResultados(Partida p){
        resultados.add(p);
    }

    public List<Partida> getResultados() { return resultados; }

    public void setResultados(List<Partida> resultados) { this.resultados = resultados; }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDireccionResidencia() {
        return direccionResidencia;
    }

    public void setDireccionResidencia(String direccionResidencia) {
        this.direccionResidencia = direccionResidencia;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void changeValues(Usuario user){
        this.password = user.password;
        this.direccionResidencia = user.direccionResidencia;
        this.numero = user.numero;
        this.email = user.email;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "userId='" + userId + '\'' +
                ", username='" + username + '\'' +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", direccionResidencia='" + direccionResidencia + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", numero='" + numero + '\'' +
                '}';
    }
}
