package com.oreilly.Project6.Repo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.oreilly.Project6.Model.Officer;
import com.oreilly.Project6.Model.Rank;


@Repository
public class OfficerRepoImpl implements OfficerRepo{
	
	private final JdbcTemplate jdbcTemplate;
	
	//used to autogenerate the id values
	private final SimpleJdbcInsert insertOfficer;
	
	
	private final RowMapper<Officer> officerMapper = (rs, rowNum) -> 
		new Officer(
				rs.getInt("id"),
				Rank.valueOf(rs.getString("rank")),
				rs.getString("firstname"),
				rs.getString("lastname")
				);
		
	
	
	@Autowired
	public OfficerRepoImpl (JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
		insertOfficer = new SimpleJdbcInsert(jdbcTemplate)
				.withTableName("officers")
				.usingGeneratedKeyColumns("id");
	}

	@Override
	public Officer save(Officer officer) {
		
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("rank", officer.getRank());
		parameters.put("firstname", officer.getFirstName());
		parameters.put("lastname",officer.getLastname());
		
		Integer newId = (Integer)insertOfficer.executeAndReturnKey(parameters);
		
		officer.setId(newId);
		
		return officer;
	}

	@Override
	public Optional<Officer> findById(Integer id) {
		if(!existsById(id)) return Optional.empty();
		return Optional.of(jdbcTemplate.queryForObject("SELECT * FROM OFFICERS WHERE ID=?", 
				new RowMapper<Officer>() { //Java 7 Anonymous Inner class
					
					@Override
					public Officer mapRow(ResultSet rs, int rowNum) throws SQLException{
						
						return new Officer(
								rs.getInt("id"),
								Rank.valueOf(rs.getString("rank")),
								rs.getString("firstname"),
								rs.getString("lastname")
								);
						
					}
					
				}// can just use officerMapper Java 8 instead of this whole code written in java 7
				, id));
	}

	@Override
	public List<Officer> findAll() {
		return jdbcTemplate.query("SELECT * FROM OFFICERS", officerMapper);
	}

	@Override
	public Long count() {
		return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM OFFICERS", Long.class);
	}

	@Override
	public void delete(Integer id) {
		jdbcTemplate.update("DELETE FROM OFFICERS WHERE ID=?", id);
	}

	@Override
	public Boolean existsById(Integer id) {
		return jdbcTemplate.queryForObject("SELECT 1 FROM OFFICERS WHERE ID=?", Boolean.class, id);
	}
	
	
	

}
