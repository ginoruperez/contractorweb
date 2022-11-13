package com.gino.contractor.service;

import java.util.List;
import com.gino.contractor.entities.Contractor;

public interface ContractorService {

	Contractor saveContractor(Contractor contractor);

	Contractor updateContractor(Contractor contractor);

	void deleteContractor(Contractor contractor);

	Contractor getContractorById(int id);

	List<Contractor> getAllContractor();

//	List<Contractor> getContractorByLocation(int location);
	
}
