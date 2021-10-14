package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Donor;
import com.example.demo.exception.IdNotFoundException;
import com.example.demo.services.DonorService;

@RestController
@RequestMapping(path = "/api/v1/donors")
public class DonorController {
	@Autowired
	private DonorService service; 
	
	@GetMapping
	public List<Donor> findAll(){
		return this.service.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Donor> add(@RequestBody Donor entity) {
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.addDonor(entity));
	}
	@PutMapping
	public ResponseEntity<Object> update(@RequestBody Donor entity){
		return ResponseEntity.status(HttpStatus.OK).body(this.service.updateDonor(entity));
	}
	@GetMapping(path = "/bloodgroup/{group}")
	public List<Donor> findByBloodGroup(@PathVariable("group") String group){
		return this.service.findByBloodGroup(group);
	}
	@GetMapping(path = "/location/{location}")
	public List<Donor> findByLocation(@PathVariable("location") String location){
		return this.service.findByLocation(location);
	}
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<String> removeDonor(@PathVariable("id") int id) {
		int count = this.service.remove(id);
		return count==1?ResponseEntity.ok().body(count+" rows deleted"):
				ResponseEntity.status(HttpStatus.NOT_FOUND).body("Record not found");
	}
	@GetMapping(path="/{id}")
	public Donor getDonor(@PathVariable("id") int id) throws IdNotFoundException {
		return this.service.findByID(id);
	}
	@GetMapping(path = "/getids")
	public List<Integer> getIds(){
		return this.service.getIds();
	}
}
