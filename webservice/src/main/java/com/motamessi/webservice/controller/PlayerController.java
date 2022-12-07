package com.motamessi.webservice.controller;

import com.motamessi.webservice.exception.ResourceNotFoundException;
import com.motamessi.webservice.model.Player;
import com.motamessi.webservice.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlayerController {
    @Autowired
    private PlayerRepository playerRepo;

    //create employee
    @PostMapping
    @RequestMapping("/api/v1/player/create")
    public ResponseEntity<String> createPlayer(@RequestBody Player newPlayer)
    {
        playerRepo.save(newPlayer);
        return  ResponseEntity.ok("Created!");
    }
    @GetMapping
    @RequestMapping("/api/v1/players/getall")
    public List<Player> getAllPlayers(){
        return playerRepo.findAll();
    }
    @GetMapping
    @RequestMapping("/api/v1/players/getbyid/{id}")
    public ResponseEntity<Player> getPlayerById(@PathVariable long id){
        Player player =  playerRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Player not found"+id));
        return ResponseEntity.ok(player);
    }

    @PostMapping
    @RequestMapping("/api/v1/player/update")
    public ResponseEntity<String> updatePlayer(@RequestBody Player playerDetails)
    {
        long id = playerDetails.getId();
        Player updatePlayer = playerRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found"+id));
        updatePlayer.setFirst(playerDetails.getFirst());
        updatePlayer.setLast(playerDetails.getLast());
        updatePlayer.setEmail(playerDetails.getEmail());
        playerRepo.save(updatePlayer);
        return ResponseEntity.ok("Updated!");
    }
}
