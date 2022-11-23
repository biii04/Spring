package com.myspring.model;

import java.util.List;

import com.myspring.vo.PersonVO;

public interface PersonService {
	
	//추가
	public void insert(PersonVO person);
	
	//전체보기
	public List<PersonVO> listAll();
	public List<PersonVO> list(String field, String word);
	
	//상세보기
	public PersonVO view(String id);
	
	//수정
	public void update(PersonVO person);
	
	//삭제
	public void delete(String id);
	
	//개수
	public int countAll();
	public int count(String field, String word);
}
