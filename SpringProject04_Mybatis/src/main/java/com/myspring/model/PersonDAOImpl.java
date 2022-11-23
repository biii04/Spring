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
	//�߰�
	@Override
	public void dao_insert(String mid, PersonVO person) {
		sqlMapper.insert(mid, person);
		
	}

	//��ü����
	@Override
	public List<PersonVO> dao_list(String mid) {
		return sqlMapper.selectList(mid);
	}

	//�󼼺���
	@Override
	public PersonVO dao_view(String mid, String id) {
		return sqlMapper.selectOne(mid, id);
	}

	//����
	@Override
	public void dao_update(String mid, PersonVO person) {
		sqlMapper.update(mid, person);
	}

	//����
	@Override
	public void dao_delete(String mid, String id) {
		sqlMapper.delete(mid,id);
		
	}

	//����
	@Override
	public int dao_count(String mid) {
		return sqlMapper.selectOne(mid);
	}

	//�˻� ��ü����
	@Override
	public List<PersonVO> dao_searchlist(String mid, HashMap<String, String> hm) {
		return sqlMapper.selectList(mid, hm);  //string mid�� 2���� ���ۿ� �������� hashmap�� �̿��� ���� ���� ��� �߰��Ѱ�
	}

	//�˻� ����
	@Override
	public int dao_searchcount(String mid, HashMap<String, String> hm) {
		return sqlMapper.selectOne(mid,hm);
	}

}
