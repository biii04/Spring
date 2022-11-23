package com.test2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller  //굳이 상속받지 않아도 됨
public class TestController {
	@RequestMapping("test.go")
	public String test() {
		return "result";  //index.js 파일에서 test.go를 누르면 여기로 와서 result 파일로 리턴시키고 싶어함
	}
	
	@RequestMapping("test22.go")
	public void test22() {
	//void라 return값 없어도됨	
	}
}
