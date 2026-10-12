package com.iset.Tp2ApiRest;

import com.iset.Tp2ApiRest.DAO.RoleRepository;
import com.iset.Tp2ApiRest.DAO.UserRepository;
import com.iset.Tp2ApiRest.entities.Role;
import com.iset.Tp2ApiRest.entities.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class Tp2ApiRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(Tp2ApiRestApplication.class, args);
	}
	@Component
	public class DataInitializer implements CommandLineRunner {

		private final RoleRepository roleRepo;
		private final UserRepository userRepo;

		// Injection par constructeur
		public DataInitializer(RoleRepository roleRepo, UserRepository userRepo) {
			this.roleRepo = roleRepo;
			this.userRepo = userRepo;
		}

		@Override
		public void run(String... args) {
			Role admin = roleRepo.save(new Role(null, "ADMIN"));
			Role user = roleRepo.save(new Role(null, "USER"));

			userRepo.save(new User(null, "Najla", "Najla@example.com", admin));
			userRepo.save(new User(null, "Sirine", "Sirine@example.com", user));
			userRepo.save(new User(null, "Nesrine", "Nesrine@example.com", user));
		}
	}
}
