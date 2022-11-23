package com.gino.contractor.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gino.contractor.entities.Contractor;
import com.gino.contractor.repos.ContractorRepository;

@Service
public class ContractorServiceImpl implements ContractorService {

	@Autowired
	private ContractorRepository repository;
	
	@Override
	public Contractor saveContractor(Contractor contractor) {
		return repository.save(contractor);
	
	}

	@Override
	public Contractor updateContractor(Contractor contractor) {
		return repository.save(contractor);
	}

	@Override
	public void deleteContractor(Contractor contractor) {
		repository.delete(contractor);

	}

	

	@Override
	public List<Contractor> getAllContractor() {
		return repository.findAll();
	}

	@Override
	public Contractor getContractorById(int id) {
		return repository.findById(id).get();

	}

}
