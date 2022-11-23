package com.person2.model;

import java.util.List;


	public interface Person2DAO {
		
		//추가
		public void person_insert(PersonVO person);
		
		//전체보기
		public List<PersonVO> person_list();
		
		//상세보기
		public PersonVO person_view(String id);
		
		//수정
		public void person_update(PersonVO person);
		
		//삭제
		public void person_delete(String id);
		
		//개수
		public int person_count();

	}

