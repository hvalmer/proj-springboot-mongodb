package com.braincustom.projmongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.braincustom.projmongodb.domain.User;
import com.braincustom.projmongodb.dto.UserDTO;
import com.braincustom.projmongodb.repository.UserRepository;
import com.braincustom.projmongodb.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired //mecanismo de injeção automática do spring
	private UserRepository repo; 
	
	//findAll() método responsável por retornar todos os usuários do BD
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);//tratando a exceção caso id não exista
		repo.deleteById(id);
	}
	
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
}
