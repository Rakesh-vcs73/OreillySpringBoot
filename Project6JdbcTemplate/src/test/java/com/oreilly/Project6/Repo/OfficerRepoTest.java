package com.oreilly.Project6.Repo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.oreilly.Project6.Model.Officer;
import com.oreilly.Project6.Model.Rank;

@SpringBootTest
@Transactional  //If this is not given test cases will fail if delete test is executed first, as it deletes all the records
public class OfficerRepoTest {
	
	@Autowired
	private OfficerRepo repo;
	
	//Instead of hard coding the IDs in test we can get the jdbcTemplate and get allIds, and use them inside the tests.
	
	@Test
	public void save() {
		Officer officer = new Officer(Rank.CAPTAIN,"Jack","Sparrow");
		officer = repo.save(officer);
		assertNotNull(officer.getId());
	}
	
	@Test
	public void findByIdThatExists() {
		Optional<Officer> officer = repo.findById(5);
		assertTrue(officer.isPresent());
		assertEquals(5,officer.get().getId().intValue());
		
	}
	
	@Test
	public void findByIdThatDoesnotExists() throws Exception{
		Optional<Officer> officer = repo.findById(99);
		assertFalse(officer.isPresent());
		
	}
	
	@Test
	public void count() {
		assertEquals(5,repo.count());
	}
	
	@Test
	public void findAll() {
		List<String> officerNames = repo.findAll().stream()
				.map(Officer::getLastname)
				.collect(Collectors.toList());
		assertThat(officerNames, containsInAnyOrder("Garp","Luffy","Law","Shanks","Ace"));
	}
	
	@Test
	public void delete() {
		IntStream.rangeClosed(1,5).forEach(id -> 
		{
			Optional<Officer> officer = repo.findById(id);
			assertTrue(officer.isPresent());
			repo.delete(id);
		});
		assertEquals(0,repo.count());
	}
	
	@Test
	public void exixtsById() {
		IntStream.rangeClosed(1, 5).forEach(id ->{
			assertTrue(repo.existsById(id));
		});
		
	}

}
