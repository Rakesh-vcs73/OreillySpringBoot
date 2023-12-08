package com.oreilly.Project7.Repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.oreilly.Project7.Model.Officer;
import com.oreilly.Project7.Model.Rank;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SpringBootTest
@Transactional
public class JPATest {
	
	@Autowired
	private OfficerRepo repo;
	
	
	@Test
	public void count() {
		assertEquals(5,repo.count());
	}
	
	@Test
	public void save() {
		Officer officer = new Officer(Rank.CAPTAIN, "JACK","SPARROW");
		officer = repo.save(officer);
		assertNotNull(officer.getId());
	}
	
	@Test
	public void findByIdThatExists() {
		
		Optional<Officer> officer = repo.findById(5);
		assertTrue(officer.isPresent());
		assertEquals(5,officer.get().getId());
		
	}
	
	@Test
	public void findByIdThatDoesNotExists() {
		
		Optional<Officer> officer = repo.findById(99);
		assertFalse(officer.isPresent());
	}
	
	@Test
	public void findAll() {
		List<String> officers = repo.findAll().stream().map(Officer::getLastname).collect(Collectors.toList());
		assertThat(officers,containsInAnyOrder("Luffy","Law","Shanks","Ace","Garp"));
	}
	
	@Test
	public void delete() {
		IntStream.rangeClosed(1,5).forEach(id -> {
			Optional<Officer> officer = repo.findById(id);
			assertTrue(officer.isPresent());
			repo.deleteById(id);
		});
		assertEquals(0,repo.count());
	}
	
	@Test
	public void exixtsById() {
		IntStream.rangeClosed(1,5).forEach(id -> {
			Optional<Officer> officer = repo.findById(id);
			assertTrue(officer.isPresent());
			repo.deleteById(id);
		});
	}

}
