package edu.eci.ieti.gameover.persistence;

public class GameOverException extends Exception {
    public final static String USERNAME_NOT_FOUND = "The user that you want to enter is not available";
    public final static String TEAM_NOT_FOUND = "The team that you want to enter is not available";
    public final static String SPORT_NOT_FOUND = "The sport that you want to enter is not available";

    public GameOverException(String message){
        super(message);
    }
}
