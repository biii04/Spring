package com.person2.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository  //sql�� ���� ��(dao) repository��°� ���� ��ü �ڵ�����, autowired��� �� �κп� �ڵ�����
public class Person2DAOImpl implements Person2DAO {
	@Autowired
	private JdbcTemplate template;
	
	//�߰�
	@Override
	public void person_insert(PersonVO person) {
		String sql = "insert into person values(?,?,?,?,?)";
		Object[] param = new Object[] {
				person.getId(), person.getName(),
				person.getPassword(), person.getGender(),
				person.getJob()
		};  //������� �ֱ�
		
		template.update(sql,param);
		
	}

	//��ü����
	@Override
	public List<PersonVO> person_list() {
		String sql = "select * from person";
		List<PersonVO> personlist=template.query(sql, new RowMapper<PersonVO>() {

			@Override
			public PersonVO mapRow(ResultSet rs, int arg1) throws SQLException {
				PersonVO user = new PersonVO();
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

	//�󼼺���
	@Override
	public PersonVO person_view(String id) {
		String sql = "select * from person where id='"+id+"'";
		PersonVO person = template.queryForObject(sql, new RowMapper<PersonVO>() {

			@Override
			public PersonVO mapRow(ResultSet rs, int arg1) throws SQLException {
				PersonVO user = new PersonVO();
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

	//����
	@Override
	public void person_update(PersonVO person) {
		String sql = "update person set name=?, password=?, gender=?, job=? where id=?";
		Object[] param= new Object[] {
				person.getName(), person.getPassword(),
				person.getGender(), person.getJob(),
				person.getId()
		};
		template.update(sql,param);
	}

	//����
	@Override
	public void person_delete(String id) {
		String sql= "delete from person where id='"+id+"'";
		template.update(sql);
		
	}

	//����
	@Override
	public int person_count() {
		String sql = "select count(*) from person";
		int count = template.queryForObject(sql, Integer.class);
		return count;
	}
	
}
