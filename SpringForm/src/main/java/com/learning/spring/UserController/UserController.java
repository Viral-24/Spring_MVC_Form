package com.learning.spring.UserController;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.learning.spring.IDAO.IDAO;
import com.learning.spring.UserModel.UserModel;

@Controller
public class UserController {

	@Autowired
	UserModel model;
	
	@Autowired
	IDAO ido;
	
	@RequestMapping("/")
	public String indexpage(ModelMap map) {
		List<UserModel> recevied = ido.getRecords();
		if(recevied.size()>0) {
			map.addAttribute("List", recevied);
		}
		else
		{
			System.out.println("not found");
		}
	   	
	   	return "index";
	}
	
	@RequestMapping(value = "/register",method = RequestMethod.GET)
	public ModelAndView detils() {
		return new ModelAndView("register", "command", new UserModel());
		
	}
	
	@RequestMapping(value = "/register",method = RequestMethod.POST)
	public String register(@ModelAttribute("UserModel") UserModel model,ModelMap map) {
		
		/*
		 * map.addAttribute("Id", model.getId()); map.addAttribute("Name",
		 * model.getName()); map.addAttribute("Email", model.getEmail());
		 * map.addAttribute("Addr",model.getAddr()); map.addAttribute("Phone",
		 * model.getPhone());
		 */
		 ido.insertingRecords(model);
		
	 	return "index";
	}
}
