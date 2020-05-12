package com.braincustom.projmongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.braincustom.projmongodb.domain.Post;
import com.braincustom.projmongodb.repository.PostRepository;
import com.braincustom.projmongodb.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired //mecanismo de injeção automática do spring
	private PostRepository repo; 
	
	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
	}
	
	//criando um método de busca
	public List<Post> findByTitle(String test){
		return repo.findByTitleContainingIgnoreCase(test);
	}
}
