package com.motamessi.webservice;

import com.motamessi.webservice.model.Player;
import com.motamessi.webservice.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Random;

@SpringBootApplication
//the Commandline Runner will run the code defiren in run method when the app runs for the frist time
public class WebserviceApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(WebserviceApplication.class, args);
	}

	@Autowired
	private PlayerRepository playerRepository;

	@Override
	public void run(String... args) throws Exception{
		Random rand = new Random();
		int randomGoal = rand.nextInt(10) + 1;
		Player player = new Player();
		player.setFirst("Padat");
		player.setLast("Shrestha");
		player.setAge(40);
		player.setGender("male");
		player.setCell("2141555666");
		player.setEmail("gpadat@gmail.com");
		player.setNumberOfGoals(randomGoal);
		playerRepository.save(player);

	}
}
