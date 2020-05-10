package com.braincustom.projmongodb.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.braincustom.projmongodb.domain.User;
import com.braincustom.projmongodb.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired //mecanismo de injeção automática do spring
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		//esse comando limpa a coleção no MongoDB e insere novos dados
		userRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		//instanciando os objetos e salvando no MongoDB
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
	}

}
