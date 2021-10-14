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
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Range;
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
@Table(name = "donor")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Donor {
	@Id
	@Column(name = "id")
	@GeneratedValue(generator="donor_id_seq")
	@SequenceGenerator(name="my_seq",sequenceName="DONOR_ID_SEQ", allocationSize=1,initialValue = 101)
	int id;
	@NotNull(message = "Required")
	@Range(min = 18,max=70,message = "Age should be between 18 and 70")
	@Column(name = "age")
	int age;
	@NotNull(message = "Required")
	@Column(name = "donorname")
	String donorName;
	@NotNull(message = "Required")
	@Column(name = "location")
	String location;
	@NotNull(message = "Required")
	@Column(name = "bloodgroup")
	String bloodGroup;
	@Column(name= "email")
	@NotNull(message = "Required")
	String email;
	@NotNull(message = "Required")
	@Column(name = "lastdonationdate")
	@DateTimeFormat(iso = ISO.DATE)
	LocalDate lastDonationDate;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "DonorCamps",
	joinColumns = { 
			@JoinColumn(name = "donor_id", referencedColumnName = "id", nullable = false, updatable = false ) },
	inverseJoinColumns = {
			@JoinColumn(name = "camp_id", referencedColumnName = "id", nullable = false, updatable = false) })
	List<DonationCamp> camps;
	
}
