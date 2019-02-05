package com.hcl.spring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {

	static List<Employee> list = new ArrayList<Employee>();
	static int i =1;

	public EmployeeController() {

		list.add(new Employee(i++, "Peter", "Jerry", "Senior Director."));
		list.add(new Employee(i++, "Bob", "Cruse", "IT Manager"));
		list.add(new Employee(i++, "James", "Gosley", "Tech Tester"));
	}

	@RequestMapping("/empform")
	public ModelAndView showform() {
		// command is a reserved request attribute name, now use <form> tag to show
		// object data
		return new ModelAndView("empform", "command", new Employee());
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("emp") Employee emp) {
		// write code to save emp object
		// here, we are displaying emp object to prove emp has data
		System.out.println(emp.getFirstName() + " " + emp.getLastName() + " " + emp.getDesignation());
		list.add(new Employee(i++, emp.getFirstName(), emp.getLastName(), emp.getDesignation()));

		// return new ModelAndView("empform","command",emp);//will display object data
		return new ModelAndView("redirect:/viewemp");// will redirect to viewemp request mapping
	}

	@RequestMapping("/viewemp")
	public ModelAndView viewemp() {
		// write the code to get all employees from DAO
		// here, we are writing manual code of list for easy understanding
		// List<Emp> list=new ArrayList<Emp>();

		return new ModelAndView("viewemp", "list", list);
	}
}
