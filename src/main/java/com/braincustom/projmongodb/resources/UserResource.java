package com.braincustom.projmongodb.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.braincustom.projmongodb.domain.User;
import com.braincustom.projmongodb.dto.UserDTO;
import com.braincustom.projmongodb.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	
	//injetando o serviço
	@Autowired
	private UserService service;
	
	//método que retorna uma lista de usuários
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> findAll(){
		List<User> list = service.findAll();
		//nesta linha, consigo converter da minha lista original para um DTO
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
}
