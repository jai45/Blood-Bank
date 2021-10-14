package com.example.demo.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.DonationCamp;
@Repository
public interface DonationCampRepository extends JpaRepository<DonationCamp, Integer>{

	List<DonationCamp> findByLocation(String location);

	@Query(nativeQuery = true, value = "select id from donationcamp")
	@Modifying
	@Transactional
	public List<Integer> getIds();
	
	@Query(nativeQuery = true, value = "update donationcamp set campName=:name,location=:location,dateOfHeld=:date where id=:id")
	@Modifying
	@Transactional
	public int updateCamp(@Param("id") int id,@Param("name") String campName,@Param("location") String location,@Param("date") LocalDate dateOfHeld);

}
