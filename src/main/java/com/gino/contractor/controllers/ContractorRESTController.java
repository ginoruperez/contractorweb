/**
 * 
 */
package com.gino.contractor.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gino.contractor.entities.Contractor;
import com.gino.contractor.repos.ContractorRepository;
import com.gino.contractor.service.ContractorService;

/**
 * @author gino.ruperez
 *
 */
@RestController
@RequestMapping("/contractors")
@CrossOrigin
public class ContractorRESTController {

	@Autowired
	ContractorService service;
	
	@Autowired
	ContractorRepository contractorRepository;
	/**
	 * To test this in postman , select GET then type http://localhost:8080/locations
	 * Then in Headers key=Accept value=json
	 * click SEND and will list json data of records from contractor table
	 * @return
	 */
	@GetMapping
	public List<Contractor> getContractors(){
		return contractorRepository.findAll();
	}
	
	/**
	 * RequestBody is use by Spring to serialize or deserialize data into object
	 * When testing in POSTMAN,  in Headers key=Accept value=json
	 * select Body->raw-> then select json application
	 * type the json data similar to contractor record fields
	 * 
	 * this method is a rest for creating a record.
	 * 
	 * @param contractor
	 * @return
	 */
	@PostMapping
	public Contractor createContractor(@RequestBody Contractor contractor) {
		return contractorRepository.save(contractor);
	}
	

	/**
	 * This is REST for updating records in table
	 * 
	 * follow the way you test the POST but instead use PUT when testing on POSTMAN
	 * 
	 * @param contractor
	 * @return
	 */
	@PutMapping
	public Contractor updateContractor(@RequestBody Contractor contractor) {
		return contractorRepository.save(contractor);
	}
	
	
	/**
	 * REST for delete record, 
	 * 
	 * when testing in postman just appen to uri /id  to be deleted 
	 * then check in mysql. 
	 * 
	 * the PathVariable will put the /id value into int id
	 * 
	 * @param id
	 */
	@DeleteMapping("/{id}")
	public void deleteContractor(@PathVariable("id") int id) {
		contractorRepository.delete(id);
	}
	
	
	/**
	 * Retrieve one contractor only 
	 * Just pass the /id to search for one record
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public Contractor getContractor(@PathVariable("id") int id) {
		return contractorRepository.findOne(id);
	}
	
	/**
	 * Search by Location 
	 * 
	 * @param location
	 * @return
	 */
//	@RequestMapping("/{location}")
//	public List<Contractor> getContractorByLocation(@RequestParam("location") String location, ModelMap modelMap) {
//		List<Contractor> contractor = service.getContractorByLocation(location);
//		modelMap.addAttribute("contractor", contractor);
//		return contractor;
//	}
	

	}
