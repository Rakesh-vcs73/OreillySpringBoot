package com.oreilly.Project7.Repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.oreilly.Project7.Model.Officer;

public interface OfficerRepo extends JpaRepository<Officer,Integer> {

}
