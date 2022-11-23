package com.myspring.model;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myspring.vo.PersonVO;

@Service
public class PersonServiceImpl implements PersonService{
	@Autowired
	private PersonDAO dao;
	
	//추가
	@Override
	public void insert(PersonVO person) {
		dao.dao_insert("insertPerson",person);
		
	}

	//전체보기
	@Override
	public List<PersonVO> listAll() {
		dao.dao_list("listPerson");
		return dao.dao_list("listPerson");
	}

	//상세보기
	@Override
	public PersonVO view(String id) {
		dao.dao_view("viewPerson", id);
		return dao.dao_view("viewPerson", id);
	}

	//수정
	@Override
	public void update(PersonVO person) {
		dao.dao_update("updatePerson", person);
		
	}

	//삭제
	@Override
	public void delete(String id) {
		dao.dao_delete("deletePerson", id);
		
	}

	//개수
	@Override
	public int countAll() {
		return dao.dao_count("countPerson");
	}

	//검색 전체보기
	@Override
	public List<PersonVO> list(String field, String word) {
		HashMap<String, String> hm = new HashMap<String, String>();
		hm.put("field", field);
		hm.put("word", word);
		return dao.dao_searchlist("searchPerson",hm );
	}

	//검색 개수
	@Override
	public int count(String field, String word) {
		HashMap<String, String> hm = new HashMap<String, String>();
		hm.put("field", field);
		hm.put("word", word);
		return dao.dao_searchcount("searchCount", hm);
	}

}
