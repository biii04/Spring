package com.app03.model;

import java.util.List;


public interface MPersonDAO {
	
	//추가
	public void person_insert(PersonDTO person);
			
	//전체보기
	public List<PersonDTO> person_list();
			
	//상세보기
	public PersonDTO person_view(String id);
			
	//수정
	public void person_update(PersonDTO person);
			
	//삭제
	public void person_delete(String id);
			
	//개수
	public int person_count();
}
