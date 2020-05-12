package com.braincustom.projmongodb.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.braincustom.projmongodb.domain.Post;
import com.braincustom.projmongodb.resources.util.URL;
import com.braincustom.projmongodb.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

	// injetando o serviço
	@Autowired
	private PostService service;

	// método que retorna um usuário por id
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	// método que retorna um usuário por id
	@RequestMapping(value = "/titlesearch", method = RequestMethod.GET)
	public ResponseEntity<List<Post>> findBTitle(@RequestParam(value = "text", defaultValue="") String text) {
		text = URL.decodeParam(text);//decodifica o texto
		List<Post> list = service.findByTitle(text);
		return ResponseEntity.ok().body(list);
	}
}
