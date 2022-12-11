package com.motamessi.webservice.controller;

import com.motamessi.webservice.exception.ResourceNotFoundException;
import com.motamessi.webservice.model.Player;
import com.motamessi.webservice.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class PlayerController {
    @Autowired
    private PlayerRepository playerRepo;

    //create employee
    @PostMapping
    @RequestMapping("/api/v1/player/create")
    public ResponseEntity<String> createPlayer(@RequestBody Player newPlayer)
    {

        Player player = new Player();
        if(newPlayer.getFirst()==null)
            player.setFirst(getRandomString());
        else
            player.setFirst(newPlayer.getFirst());
        if(newPlayer.getLast()==null)
            player.setLast(getRandomString());
        else
            player.setLast(newPlayer.getLast());
        if(newPlayer.getAge()==0)
            player.setAge(40);
        else
            player.setAge(newPlayer.getAge());

        if(newPlayer.getGender()==null)
            player.setGender(newPlayer.getGender());
        else
            player.setGender(newPlayer.getGender());

        if(newPlayer.getCell()==null)
            player.setCell("2141555666");
        else
            player.setCell(newPlayer.getCell());

        if(newPlayer.getEmail()==null)
            player.setEmail(getRandomString()+"@gmail.com");
        else
            player.setEmail(newPlayer.getEmail());

        if(newPlayer.getNumberOfGoals()==0)
            player.setNumberOfGoals(getRandomNumber());
        else
            player.setNumberOfGoals(newPlayer.getNumberOfGoals() );

        playerRepo.save(player);
        return  ResponseEntity.ok("Created!");
    }
    @GetMapping
    @RequestMapping("/api/v1/players/getall")
    public List<Player> getAllPlayers(){
        return playerRepo.findAll();
    }
    @GetMapping
    @RequestMapping("/api/v1/player/getbyid/{id}")
    public ResponseEntity<Player> getPlayerById(@PathVariable long id){
        Player player =  playerRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Player not found"+id));
        return ResponseEntity.ok(player);
    }

    @GetMapping
    @RequestMapping("/api/v2/ramdom/getrandom")
    public ResponseEntity<Integer> GetRamdomNum(){
        int ramdomNum= getRandomNumber();
        return ResponseEntity.ok(ramdomNum);
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
    private int getRandomNumber(){
        Random rand = new Random();
        int randNum = rand.nextInt(10) + 1;
        return  randNum;
    }
    private String getRandomString(){
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();
        return  generatedString;
    }
}
