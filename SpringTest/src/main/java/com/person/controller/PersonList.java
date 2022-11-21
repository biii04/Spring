package com.person.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.person.model.Person;
import com.person.model.PersonDAOImpl;

public class PersonList  extends AbstractController{
  private PersonDAOImpl dao;
  
  public void setDao(PersonDAOImpl dao) {
	  this.dao = dao;
  }
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		List<Person> arr =  dao.personList();
		ModelAndView mv = new ModelAndView();
		mv.addObject("personlist", arr);
		mv.setViewName("WEB-INF/jsp/personList.jsp");
		return mv;
	}

}
