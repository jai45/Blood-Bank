package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Donor;
import com.example.demo.exception.IdNotFoundException;
import com.example.demo.repositories.DonorRepository;

@Service
public class DonorService {
	
	@Autowired
	private DonorRepository repo;
	
	public List<Donor> findAll(){
		return this.repo.findAll();
	}
	
	public Donor addDonor(Donor entity) {
		return this.repo.save(entity);
	}
	
	public Donor findByID(Integer id) throws IdNotFoundException {
		return this.repo.findById(id).
				orElseThrow(()->new IdNotFoundException("Id not found"));
	}
	public List<Donor> findByLocation(String location){
		return this.repo.findByLocation(location);
	}
	public List<Donor> findByBloodGroup(String group){
		return this.repo.findByBloodGroup(group);
	}
	public int remove(int id) {
		int rowDeleted=0;
		if(this.repo.existsById(id)) {
			rowDeleted=1;
			this.repo.deleteById(id);
		}
		return rowDeleted;
	}
	public List<Integer> getIds(){
		return this.repo.getIds();
	}

	public Object updateDonor(Donor entity) {
		
		return this.repo.updateDonor(entity.getId(),entity.getDonorName(),entity.getAge(),entity.getLocation(),entity.getBloodGroup(),entity.getEmail(),entity.getLastDonationDate());
	}

}
