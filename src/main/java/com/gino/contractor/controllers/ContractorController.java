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
import com.gino.contractor.util.EmailUtil;
import com.gino.contractor.util.PDFGenerator;
import com.gino.contractor.util.ReportUtil;

@Controller
public class ContractorController {

	@Autowired
	ContractorService service;

	@Autowired
	ContractorRepository repository;

	@Autowired
	ReportUtil reportUtil;

	/**
	 * this is responsible for creation of user in contractor database
	 */
	@Autowired
	UserRepository userRepository;

	/**
	 * responsible for the path of the chart to be read by jsp
	 */
	@Autowired
	ServletContext sc;
	
	@Autowired
	PDFGenerator pdfGenerator;

	@Autowired
	EmailUtil emailUtil;
	
	
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
	 * @return
	 */
	@RequestMapping("/saveCon")
	public String saveContractor(@ModelAttribute("contractor") Contractor contractor, ModelMap modelMap) {
		Contractor contractorSaved = service.saveContractor(contractor);
		
		//call the pdfGenerator
		pdfGenerator.generateContractor(contractorSaved, "contractor"+contractorSaved.getId());
		
		//initiate the email call
		String msg = "Contractor saved with id: " + contractorSaved.getId();
		modelMap.addAttribute("msg", msg);
		emailUtil.sendEmail("grsharedemail@gmail.com", "Contractor Saved",
				"Contractor Saved Successfully and about to return a response");
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
	 * the @RequestParam is used to get the value of id from the el on
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

	// this section is for creation and login page

	// @RequestMapping(value = "createUser", method = RequestMethod.POST)

	@RequestMapping("/createUser")
	public String showCreateUserPage() {
		LOGGER.info("Inside CreateUser shwoCreateUserPage");
		return "login/createUser";
	}

	@RequestMapping("/registerUser")
	public String showCreateUserPage(@ModelAttribute("user") User user) {
		userRepository.save(user);
		LOGGER.info("Inside RegisterUser "+user);
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

	// Modelmap is responsible for sending values to be used by jsp, the value=login
	// is action in login.jsp
	// @RequestMapping(value="login", method=RequestMethod.POST)
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
