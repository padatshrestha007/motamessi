package com.motamessi.webservice;

import com.motamessi.webservice.model.Employee;
import com.motamessi.webservice.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//the Commandline Runner will run the code defiren in run method when the app runs for the frist time
public class WebserviceApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(WebserviceApplication.class, args);
	}

	@Autowired
	private EmployeeRepository empRepo;

	@Override
	public void run(String... args) throws Exception{
		Employee employee = new Employee();
		employee.setFirstName("Hazel");
		employee.setLastName("balla");
		employee.setEmailId("hazel@gmail.com");
		empRepo.save(employee);

		Employee employee2 = new Employee();
		employee2.setFirstName("JUna");
		employee2.setLastName("balla");
		employee2.setEmailId("junaballa@gmail.com");
		empRepo.save(employee2);
	}
}
