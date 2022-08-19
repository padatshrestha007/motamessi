package com.webapi;

import org.springframework.beans.factory.annotation.Autowired;
import model.Player;
import Repositories.PlayerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerController {
    @Autowired
    PlayerRepository players;

//    public PlayerController(PlayerRepository players){
//        this.players = players;
//    }

    private static final String message = "hell world, from padat";

    @GetMapping("/message")
    public static String message() {
        Player p = new Player("padat","shrestha","m",40,"1231231231","gpadat@gmail.com");
        return p.toString();
    }
    @GetMapping(path="/all")
    public @ResponseBody Iterable<Player> getAllPlayers() {
        // This returns a JSON or XML with the users
        return players.findAll();
    }
}
