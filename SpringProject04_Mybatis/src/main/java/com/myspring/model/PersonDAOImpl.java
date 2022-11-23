package com.myspring.model;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myspring.vo.PersonVO;

@Repository
public class PersonDAOImpl implements PersonDAO{
	@Autowired
	private SqlSession sqlMapper;
	//추가
	@Override
	public void dao_insert(String mid, PersonVO person) {
		sqlMapper.insert(mid, person);
		
	}

	//전체보기
	@Override
	public List<PersonVO> dao_list(String mid) {
		return sqlMapper.selectList(mid);
	}

	//상세보기
	@Override
	public PersonVO dao_view(String mid, String id) {
		return sqlMapper.selectOne(mid, id);
	}

	//수정
	@Override
	public void dao_update(String mid, PersonVO person) {
		sqlMapper.update(mid, person);
	}

	//삭제
	@Override
	public void dao_delete(String mid, String id) {
		sqlMapper.delete(mid,id);
		
	}

	//개수
	@Override
	public int dao_count(String mid) {
		return sqlMapper.selectOne(mid);
	}

	//검색 전체보기
	@Override
	public List<PersonVO> dao_searchlist(String mid, HashMap<String, String> hm) {
		return sqlMapper.selectList(mid, hm);  //string mid는 2개의 값밖에 못가져서 hashmap을 이용해 넣을 값을 계속 추가한것
	}

	//검색 개수
	@Override
	public int dao_searchcount(String mid, HashMap<String, String> hm) {
		return sqlMapper.selectOne(mid,hm);
	}

}
