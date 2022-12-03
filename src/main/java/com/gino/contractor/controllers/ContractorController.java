package com.gino.contractor.controllers;

import java.util.List;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gino.contractor.entities.Contractor;
import com.gino.contractor.entities.User;
import com.gino.contractor.repos.ContractorRepository;
import com.gino.contractor.repos.UserRepository;
import com.gino.contractor.service.ContractorService;
import com.gino.contractor.util.PDFGenerator;
import com.gino.contractor.util.ReportUtil;

/**
 * This is the main class that provides access to database.  It inherits the Service, Repository and Utility classes
 * 
 * @author Gino Ruperez
 *
 */

@Controller
public class ContractorController {

	@Autowired
	ContractorService service;

	@Autowired
	ContractorRepository repository;

	@Autowired
	ReportUtil reportUtil;

	/**
	 * This is responsible for creation of user in contractor database
	 */
	@Autowired
	UserRepository userRepository;

	/**
	 * Responsible for the path of the chart to be read by jsp
	 */
	@Autowired
	ServletContext sc;
	
	/**
	 * Responsible for generating the pdf file
	 */
	@Autowired
	PDFGenerator pdfGenerator;

	
	private static final Logger LOGGER  = LoggerFactory.getLogger(ContractorController.class);

	@RequestMapping("/showCreate")
	public String showCreate() {
		LOGGER.info("Inside showCreate");
		return "createContractor";
	}

	/**
	 * the ModelAttribute is used to capture the inputs from jsp and convert them
	 * into an object. the RequestMapping is used to map to jsp file to be used as
	 * url input, but the actual jsp should be the return string.
	 * 
	 * @param contractor
	 * @param modelMap
	 * @return String value that corresponds to the name of jsp  
	 */
	@RequestMapping("/saveCon")
	public String saveContractor(@ModelAttribute("contractor") Contractor contractor, ModelMap modelMap) {
		service.saveContractor(contractor);
		LOGGER.info("Inside saveContractor");
		return "createContractor";
	}
	
	

	@RequestMapping("/displayContractors")
	public String displayContractors(ModelMap modelMap) {
		List<Contractor> contractors = service.getAllContractor();
		modelMap.addAttribute("contractors", contractors);
		LOGGER.info("Inside displayContractors");
		return "displayContractors";
	}

	/**
	 * the @RequestParam is used to get the value of id from the el
	 * displayContractor.jsp the ModelMap is responsible for sending the response to
	 * jsp file to be consumed using el
	 * 
	 * @param id
	 * @param modelMap
	 * @return
	 */
	@RequestMapping("/deleteContractor")
	public String deleteContractor(@RequestParam("id") int id, ModelMap modelMap) {
		// Contractor contractor= service.getContractorById(id);
		Contractor contractor = new Contractor();
		contractor.setId(id);
		service.deleteContractor(contractor);
		List<Contractor> contractors = service.getAllContractor();
		modelMap.addAttribute("contractors", contractors);
		LOGGER.info("Inside deleteContractor");
		return "displayContractors";

	}
	
	
	@RequestMapping("/showUpdate")
	public String showUpdate(@RequestParam("id") int id, ModelMap modelMap) {
		Contractor contractor = service.getContractorById(id);
		modelMap.addAttribute("contractor", contractor);
		LOGGER.info("Inside showUpdate page");
		return "updateContractor";
	}
	
	
	@RequestMapping("/generatePdf")
	public String generatePdf(@RequestParam("id") int id, ModelMap modelMap) {
		Contractor contractor = service.getContractorById(id);
		modelMap.addAttribute("contractor", contractor);
		
		//call the pdfGenerator
		pdfGenerator.generateContractor(contractor, "contractor_"+contractor.getId()+".pdf");
				
		LOGGER.info("Inside generatePdf page");
		return "reportContractor";
	}
	
	
	@RequestMapping("/updateContractor")
	public String updateContractor(@ModelAttribute("contractor") Contractor contractor, ModelMap modelMap) {
		service.updateContractor(contractor);
		List<Contractor> contractors = service.getAllContractor();
		modelMap.addAttribute("contractors", contractors);
		LOGGER.info("Inside updateContractor");
		return "displayContractors";
	}

	@RequestMapping("/generateReport")
	public String generateReport() {
		String path = sc.getRealPath("/");
		List<Object[]> data = repository.findLocationAndLocationCount();
		reportUtil.generatePieChart(path, data);
		LOGGER.info("Inside generateReport.");

		return "report";
	}

	@RequestMapping("/createUser")
	public String showCreateUserPage() {
		LOGGER.info("Inside CreateUser shwoCreateUserPage");
		return "login/createUser";
	}

	@RequestMapping("/registerUser")
	public String showCreateUserPage(@ModelAttribute("user") User user,ModelMap modelMap) {
		User userSaved= userRepository.save(user);
		String msg = "User saved with id: " + userSaved.getId();
		
		LOGGER.info("Inside RegisterUser "+user + " "+msg);
		return "login/login";
	}
		
	
	/**
	 * in Requestmapping value should be equal to the action in login.jsp
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping("/login")
	public String register() {
		LOGGER.info("Inside login page.");
		return "login/login";
	}


	@RequestMapping("/loginResult")
	public String login(@RequestParam("email") String email, @RequestParam("password") String password,
			ModelMap modelMap) {

		try {
			User user = userRepository.findByEmail(email);
			
			if (user.getPassword().equals(password)){
				this.displayContractors(modelMap);
				return "displayContractors";
			} else {
				modelMap.addAttribute("msg", "Invalid password. Please try again");
				LOGGER.warn("Inside loginResult - Invalid Password");

			}
		}catch(Exception e) {
			modelMap.addAttribute("msg", "Invalid User. Please try again");
			LOGGER.error("Exception inside ContractorController login "+ e);
		}
		
		

		return "login/login";

	}

}
