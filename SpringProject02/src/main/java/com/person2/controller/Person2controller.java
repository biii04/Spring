package com.person2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.person2.model.Person2DAOImpl;
import com.person2.model.PersonVO;

@Controller
public class Person2controller {
	@Autowired //�����Ǿ��� �ܺΰ�ü�� �ڵ����� ���Ե�
	private Person2DAOImpl dao;
	
	//�߰� ��
	@RequestMapping("person_insert.go")  //get��� �⺻�� get���
	public String person_insert() {
		return "personForm";
	}
	//�߰�
	@RequestMapping(value="person_insert.go", method=RequestMethod.POST)  //post���
	public String person_insert(PersonVO person) {  //������ person.~~�̷������� set get ������µ�
		//bean��ü�� �Ű������� �˾Ƽ� ��_�ڵ�. ��, db�� �̸��� jsp���Ͽ� �ִ� name�� ��ġ�ؾ���
		dao.person_insert(person);
		return "redirect:person_list.go";
	}
	
	//��ü����
	@RequestMapping("person_list.go")
	public String list(Model model) {
		List<PersonVO> arr=dao.person_list();
		model.addAttribute("personlist", arr);
		return "personList";
	}
	
//	@RequestMapping("person_list.go")
//	public ModelAndView list() {
//		java.util.List<PersonVO> arr =  dao.person_list();
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("personlist", arr);
//		mv.setViewName("WEB-INF/jsp/personList");
//		return mv;
//	}
	
	//�󼼺���
//	@RequestMapping("person_view.go")
//	public ModelAndView view(String id) {
//		ModelAndView mv = new ModelAndView();
//	PersonVO person = dao.person_view(id);
//	mv.addObject("person", person);
//	mv.setViewName("personView");
//	return mv;
//}
	
	//�󼼺���
	@RequestMapping("person_view.go")
	public String view(String id, Model model) {
		model.addAttribute("person", dao.person_view(id));	
		return "personView";
	}
	
	
	//������
	@RequestMapping("person_update.go")
	public String update(String id,Model model) {
		model.addAttribute("person", dao.person_view(id));
		return "personUpdate";
	}
	
	//����
	@RequestMapping(value = "person_update.go", method=RequestMethod.POST)
	public String update(PersonVO person) {
		dao.person_update(person);
		return "redirect:person_list.go";
	}
	
	//����
	@RequestMapping("person_delete.go")
	public String delete(String id) {
		dao.person_delete(id);
		return "redirect:person_list.go";
	}
	
}
