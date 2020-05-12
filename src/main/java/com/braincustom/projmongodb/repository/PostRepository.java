package com.braincustom.projmongodb.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.braincustom.projmongodb.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

	//método personalizado
	@Query("{ 'title': { $regex: ?0, $options: 'i' } }")
	List<Post> searchTitleByHarlan(String text);
	
	//essa declaração faz com que o SpringData monte a consulta
	//IgnoreCase - ignora se o texto tiver maiusc/minusc
	List<Post> findByTitleContainingIgnoreCase(String text);
	
	//método de consulta
	@Query("{ $and: [ {date: {$gte: ?1} }, { date: { $lte: ?2} } , { $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }") //especificando a consulta com @Query
	List<Post> fullSearchBusca(String text, Date minDate, Date maxDate);
}


