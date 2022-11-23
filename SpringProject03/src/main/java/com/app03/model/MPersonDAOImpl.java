package com.app03.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mysql.cj.protocol.a.NativeConstants.IntegerDataType;

@Repository
public class MPersonDAOImpl implements MPersonDAO{
	
	@Autowired
	private JdbcTemplate template;
	//추가
	@Override
	public void person_insert(PersonDTO person) {
		String sql = "insert into person values(?,?,?,?,?)";
		Object[] param = new Object[] {
				person.getId(), person.getName(),
				person.getPassword(), person.getGender(),
				person.getJob()
		};
		template.update(sql,param);
	}
	
	//전체보기
	@Override
	public List<PersonDTO> person_list() {
		String sql = "select * from person";
		List<PersonDTO> personlist=template.query(sql, new RowMapper<PersonDTO>() {

			@Override
			public PersonDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				PersonDTO user = new PersonDTO();
				user.setId(rs.getString("id"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setGender(rs.getString("gender"));
				user.setJob(rs.getString("job"));
				return user;
			}
			
		});
		return personlist;
	}

	//상세보기
	@Override
	public PersonDTO person_view(String id) {
		String sql = "select * from person where id='"+id+"'";
		PersonDTO person = template.queryForObject(sql, new RowMapper<PersonDTO>() {

			@Override
			public PersonDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				PersonDTO user = new PersonDTO();
				user.setId(rs.getString("id"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setGender(rs.getString("gender"));
				user.setJob(rs.getString("job"));
				return user;
			}
			
		});
		return person;
	}

	//수정
	@Override
	public void person_update(PersonDTO person) {
		String sql = "update person set name=?, password=?, gender=?, job=? where id=?";
		Object[] param = new Object[] {
				person.getName(), person.getPassword(),
				person.getGender(), person.getJob(),
				person.getId()
		};
		System.out.println(person.getId());
		template.update(sql,param);
	}

	//삭제
	@Override
	public void person_delete(String id) {
		String sql = "delete from person where id = '"+id+"'";
		template.update(sql);
		
	}

	//개수
	@Override
	public int person_count() {
		String sql = "select count(*) from person";
		int count = template.queryForObject(sql, Integer.class);
		return count;
	}

}
