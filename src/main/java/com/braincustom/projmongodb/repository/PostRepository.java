package com.braincustom.projmongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.braincustom.projmongodb.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

	//essa declaração faz com que o SpringData monte a consulta
	//IgnoreCase - ignora se o texto tiver maiusc/minusc
	List<Post> findByTitleContainingIgnoreCase(String text);
}


