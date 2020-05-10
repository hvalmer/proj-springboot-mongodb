package com.braincustom.projmongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.braincustom.projmongodb.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

	
}
