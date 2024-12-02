package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;



@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService service;
	
	@GetMapping("/")
	public String viewHomePage(Model model) {
		List<Employee> listemp = service.listAll();
		model.addAttribute("listEmployee", listemp);
		return "index";
		
	}
	@GetMapping("/new")
	public String add(Model model) {
		model.addAttribute("employee",new Employee());
		return "new";
		
	}
	@RequestMapping(value="/save" , method=RequestMethod.POST)
	public String saveEmployee(@ModelAttribute("employee")Employee emp) {
		service.save(emp);
		return "redirect:/";
	}
	@RequestMapping("edit/{employeeId}")
	public ModelAndView editEmp(@PathVariable(name="employeeId") int id) 
	{
		ModelAndView mv = new ModelAndView("new"); // passing html to edit
		Employee e = service.get(id);
		mv.addObject("employee",e);
		return mv;
		
	}
	@RequestMapping("delete/{employeeId}")
	public String deleteEmp(@PathVariable(name="employeeId") int id) {
		service.delete(id);
		return "redirect:/";
	}
}
