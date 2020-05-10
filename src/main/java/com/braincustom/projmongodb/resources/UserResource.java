package com.braincustom.projmongodb.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.braincustom.projmongodb.domain.User;
import com.braincustom.projmongodb.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	
	//injetando o serviço
	@Autowired
	private UserService service;
	
	//método que retorna uma lista de usuários
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<User>> findAll(){
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
}
