package com.oreilly.Project9.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oreilly.Project9.Model.Location;

public interface LocationRepo extends JpaRepository<Location,Integer>{

}
