package com.oreilly.Project8.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oreilly.Project8.Model.Location;

public interface LocationRepo extends JpaRepository<Location,Integer>{

}
