package com.tanmaymone.cardatabase;
	
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tanmaymone.cardatabase.domain.Car;
import com.tanmaymone.cardatabase.domain.CarRepository;
import com.tanmaymone.cardatabase.domain.Owner;
import com.tanmaymone.cardatabase.domain.OwnerRepository;
import com.tanmaymone.cardatabase.domain.User;
import com.tanmaymone.cardatabase.domain.UserRepository;

@SpringBootApplication
public class CarDataBaseApplication implements CommandLineRunner {
	@Autowired
	private CarRepository repository;
	@Autowired
	private OwnerRepository ownerrepository;
	@Autowired
	private UserRepository userrepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CarDataBaseApplication.class, args);
	}
	public void run(String... args)throws Exception{
		Owner owner1 = new Owner("Jhon", "Jhonson");
		Owner owner2 = new Owner("Marry", "Robinnson");
		ownerrepository.saveAll(Arrays.asList(owner1, owner2));
		Car car1 = new Car("Ford","Mustang", "Red", "ADF-1121", 2021, 59000, owner1);
		Car car2 = new Car("Nissan","Kitao", "White", "AGG-1121", 2022, 99000, owner2);
		Car car3 = new Car("Tata","Desire", "Black", "TAT-1121", 2001, 5000, owner2);
		Car car4 = new Car("Honda","Katana", "Yellow", "JJJ-1121", 2023, 459000, owner1);
		repository.saveAll(Arrays.asList(car1, car2, car3, car4));
		// // Username: user, password: user
		userrepository.save(new User("user", "$2a$10$NVM0n8ElaRgg7zWO1CxUdei7vWoPg91Lz2aYavh9.f9q0e4bRadue","USER"));
		 // Username: admin, password: admin
		userrepository.save(new User("admin", "$2a$10$8cjz47bjbR4Mn8GMg9IZx.vyjhLXR/SKKMSZ9.mP9vpMu0ssKi8GW", "ADMIN"));
	}
}