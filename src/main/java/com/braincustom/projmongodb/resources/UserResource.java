package com.braincustom.projmongodb.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.braincustom.projmongodb.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	//método que retorna uma lista de usuários
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<User>> findAll(){
		User harlan = new User("1", "Harlan Valmer", "hvalmer@gmail.com");
		User vanessa = new User("2", "Vanessa Lima", "nessali@gmail.com");
		User meg = new User("3", "Meg Cat", "megcat@gmail.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(harlan, vanessa, meg));
		return ResponseEntity.ok().body(list);
	}
}
