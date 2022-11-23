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
	@Autowired //생성되었던 외부객체가 자동으로 주입됨
	private Person2DAOImpl dao;
	
	//추가 폼
	@RequestMapping("person_insert.go")  //get방식 기본은 get방식
	public String person_insert() {
		return "personForm";
	}
	//추가
	@RequestMapping(value="person_insert.go", method=RequestMethod.POST)  //post방식
	public String person_insert(PersonVO person) {  //원래는 person.~~이런식으로 set get 다해줬는데
		//bean개체가 매개변수에 알아서 들어감_자동. 단, db의 이름과 jsp파일에 있는 name이 일치해야함
		dao.person_insert(person);
		return "redirect:person_list.go";
	}
	
	//전체보기
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
	
	//상세보기
//	@RequestMapping("person_view.go")
//	public ModelAndView view(String id) {
//		ModelAndView mv = new ModelAndView();
//	PersonVO person = dao.person_view(id);
//	mv.addObject("person", person);
//	mv.setViewName("personView");
//	return mv;
//}
	
	//상세보기
	@RequestMapping("person_view.go")
	public String view(String id, Model model) {
		model.addAttribute("person", dao.person_view(id));	
		return "personView";
	}
	
	
	//수정폼
	@RequestMapping("person_update.go")
	public String update(String id,Model model) {
		model.addAttribute("person", dao.person_view(id));
		return "personUpdate";
	}
	
	//수정
	@RequestMapping(value = "person_update.go", method=RequestMethod.POST)
	public String update(PersonVO person) {
		dao.person_update(person);
		return "redirect:person_list.go";
	}
	
	//삭제
	@RequestMapping("person_delete.go")
	public String delete(String id) {
		dao.person_delete(id);
		return "redirect:person_list.go";
	}
	
}
