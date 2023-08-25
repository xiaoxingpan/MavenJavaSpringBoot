package com.concordia.springcrud.controller;

import com.concordia.springcrud.entity.Employee;
import com.concordia.springcrud.service.EmployeeService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	private EmployeeService employeeService;

	//@Autowire is optional since we have only 1 constructor
	public EmployeeController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}

//	// load employee data
//
//	private List<Employee> theEmployees;
//
//	@PostConstruct
//	private void loadData() {
//
//		// create employees
//		Employee emp1 = new Employee("Leslie", "Andrews", "leslie@concordia.com");
//		Employee emp2 = new Employee("Emma", "Baumgarten", "emma@concordia.com");
//		Employee emp3 = new Employee("Avani", "Gupta", "avani@concordia.com");
//
//		// create the list
//		theEmployees = new ArrayList<>();
//
//		// add to the list
//		theEmployees.add(emp1);
//		theEmployees.add(emp2);
//		theEmployees.add(emp3);
//	}

	// add mapping for "/list"

	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		// Get the employee from db
		List<Employee> theEmployee = employeeService.findAll();

		// add db data to the spring model, present data from db
		theModel.addAttribute("employees", theEmployee);

//		// add loadData() to the spring model, present only the data that we loaded
//		theModel.addAttribute("employees", theEmployees);


		return "employees/list-employees";
	}

	//	add new employee
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		Employee theEmployee = new Employee();
		theModel.addAttribute("employee", theEmployee);
		return "/employees/employee-form";
	}

	//	receives and saves the ModelAttribute Employee
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {
		employeeService.save(theEmployee);
		// redirects to /employees/list to avoid duplicate submission
		return "redirect:/employees/list";
	}

	// update employee
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int theId, Model theModel) {
		// get the employee from the service
		Employee theEmployee = employeeService.findById(theId);
		// set employee as a model attribute to pre-populate the form
		theModel.addAttribute("employee", theEmployee);
		// send over to the employee-form
		return "employees/employee-form";
	}

	// delete employee
	@GetMapping("/delete")
	public String delete(@RequestParam("employeeId") int theId) {
		employeeService.deleteById(theId);
		// redirects to /employees/list to avoid duplicate submission
		return "redirect:/employees/list";
	}

}









