package com.app03.model;

import java.util.List;


public interface MPersonDAO {
	
	//�߰�
	public void person_insert(PersonDTO person);
			
	//��ü����
	public List<PersonDTO> person_list();
			
	//�󼼺���
	public PersonDTO person_view(String id);
			
	//����
	public void person_update(PersonDTO person);
			
	//����
	public void person_delete(String id);
			
	//����
	public int person_count();
}
