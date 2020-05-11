package com.braincustom.projmongodb.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.braincustom.projmongodb.domain.Post;
import com.braincustom.projmongodb.domain.User;
import com.braincustom.projmongodb.dto.AuthorDTO;
import com.braincustom.projmongodb.dto.CommentDTO;
import com.braincustom.projmongodb.repository.PostRepository;
import com.braincustom.projmongodb.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired //mecanismo de injeção automática do spring
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		//esse comando limpa a coleção no MongoDB e insere novos dados
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		//craindo os usuários
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		//salvar os usuários no MongoDB para que ele um id próprio
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		//criando os posts
		Post post1 = new Post(null, sdf.parse("01/05/2020"), "Partiu viagem!!", "Vou voltar pra Goiânia", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("07/05/2020"), "Bom dia flor do dia!!", "Acordei feliz hoje!", new AuthorDTO(maria));
		
		//instanciando os comentários dos posts
		CommentDTO com1 = new CommentDTO("Boa viagem mano!", sdf.parse("01/05/2020"), new AuthorDTO(alex));
		CommentDTO com2 = new CommentDTO("Aproveite mano!", sdf.parse("01/05/2020"), new AuthorDTO(bob));
		CommentDTO com3 = new CommentDTO("Tenha um ótimo dia!", sdf.parse("05/05/2020"), new AuthorDTO(alex));
		
		post1.getComments().addAll(Arrays.asList(com1, com2));
		post2.getComments().addAll(Arrays.asList(com3));
		
		//instanciando os objetos e salvando no MongoDB
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(maria);
	}
}
