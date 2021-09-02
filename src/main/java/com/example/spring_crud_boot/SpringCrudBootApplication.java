package com.example.spring_crud_boot;

import com.example.spring_crud_boot.model.Role;
import com.example.spring_crud_boot.model.User;
import com.example.spring_crud_boot.repositories.RoleRepository;
import com.example.spring_crud_boot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;

@SpringBootApplication
public class SpringCrudBootApplication implements CommandLineRunner {

	private final RoleRepository roleRepository;
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	@Autowired
	public SpringCrudBootApplication(RoleRepository roleRepository,
									 UserRepository userRepository,
									 PasswordEncoder passwordEncoder) {
		this.roleRepository = roleRepository;
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringCrudBootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Role admin = new Role("ROLE_ADMIN");
		Role user = new Role("ROLE_USER");
		roleRepository.save(admin);
		roleRepository.save(user);

		userRepository.save(new User("tom", "chaplin", 43, "admin@mail.ru",
				passwordEncoder.encode("admin"),
				new HashSet<>() {{
					add(admin);
				}}));
		userRepository.save(new User("jack", "white", 37, "user@mail.ru",
				passwordEncoder.encode("user"),
				new HashSet<>() {{
					add(user);
				}}));
	}
}
