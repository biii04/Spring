package com.test2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller  //���� ��ӹ��� �ʾƵ� ��
public class TestController {
	@RequestMapping("test.go")
	public String test() {
		return "result";  //index.js ���Ͽ��� test.go�� ������ ����� �ͼ� result ���Ϸ� ���Ͻ�Ű�� �;���
	}
	
	@RequestMapping("test22.go")
	public void test22() {
	//void�� return�� �����	
	}
}
