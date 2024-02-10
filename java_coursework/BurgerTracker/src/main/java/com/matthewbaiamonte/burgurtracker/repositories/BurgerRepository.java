package com.matthewbaiamonte.burgurtracker.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.matthewbaiamonte.burgurtracker.models.Burger;

@Repository
public interface BurgerRepository extends CrudRepository<Burger,Long> {
	List<Burger> findAll();
	//Could add more find by's but they should be included in the CRUD repository so no need to write them out.
}
