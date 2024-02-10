package com.matthewbaiamonte.bookstore.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.matthewbaiamonte.bookstore.models.Book;
@Repository // tells java this is a repository 
//Declare it as a public interface that extends CRUD repository(write the query for us)
public interface BookRepository extends CrudRepository<Book,Long>{
	List<Book> findAll();//gets all books
	
	List<Book> findByDescriptionContaining(String search);//gets all with matching search description 
	
	List<Book> countByTitleContaining(String search);//returns a number for amount in Db that match the search string
	
	List<Book> deleteByTitleStartingWith(String search);//deletes an item by titles starting with the search string. 
}//end interface

