package jp.co.opst.spring.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MenuController {

	@RequestMapping("/menu")
	public String menu() {
		System.out.println("menuControllerd#menu()");
		return "menu";
	}
}