package com.matthewbaiamonte.javaexam.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.matthewbaiamonte.javaexam.models.House;

@Repository
public interface HouseRepository extends CrudRepository<House,Long> {
	List<House> findAll();

}//end house repo
