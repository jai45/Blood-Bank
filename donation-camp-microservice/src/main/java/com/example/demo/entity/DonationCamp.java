package com.example.demo.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.transaction.Transactional;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Transactional
@Table(name = "donationcamp")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DonationCamp {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(generator="donationcamp_id_seq")
	@SequenceGenerator(name="my_seq",sequenceName="DONATIONCAMP_ID_SEQ", allocationSize=1,initialValue = 1000)
	int id;
	@Column(name = "campname")
	String campName;
	@Column(name = "location")
	String location;
	@Column(name = "dateofheld")
	@DateTimeFormat(iso = ISO.DATE)
	LocalDate dateOfHeld;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "DonorCamps",
	joinColumns = { 
			@JoinColumn(name = "camp_id", referencedColumnName = "id", nullable = false, updatable = false ) },
	inverseJoinColumns = {
			@JoinColumn(name = "donor_id", referencedColumnName = "id", nullable = false, updatable = false) })
	List<Donor> donors;
}
