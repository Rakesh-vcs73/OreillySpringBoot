package com.oreilly.Project6.Repo;

import java.util.List;
import java.util.Optional;

import com.oreilly.Project6.Model.Officer;

public interface OfficerRepo {
	
	Officer save(Officer officer);
	Optional<Officer> findById(Integer id);
	List<Officer> findAll();
	
	long count();
	
	void delete(Integer id);
	
	boolean existsById(Integer id);
	

}
