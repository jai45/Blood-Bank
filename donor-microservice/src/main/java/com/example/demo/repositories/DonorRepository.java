package com.example.demo.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Donor;

@Repository
public interface DonorRepository extends JpaRepository<Donor, Integer> {

	List<Donor> findByLocation(String location);

	List<Donor> findByBloodGroup(String group);
	
	@Query(nativeQuery = true, value = "select id from donor")
	@Modifying
	@Transactional
	public List<Integer> getIds();
	@Query(nativeQuery = true, value = "update donor set donorName=:name, age=:age,location=:location,bloodGroup=:group,email=:email,lastDonationDate=:date where id=:id")
	@Modifying
	@Transactional
	public int updateDonor(@Param("id") int id,@Param("name") String donorName,@Param("age") int age,@Param("location") String location,@Param("group") String bloodGroup,@Param("email") String email,
			@Param("date") LocalDate lastDonationDate);

}
