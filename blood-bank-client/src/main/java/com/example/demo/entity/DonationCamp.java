package com.example.demo.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Component;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DonationCamp {
	
	@Id
	@GeneratedValue(generator="donationcamp_id_seq")
	@SequenceGenerator(name="my_seq",sequenceName="DONATIONCAMP_ID_SEQ", allocationSize=1,initialValue = 1000)
	int id;
	@NotNull(message = "Required")
	String campName;
	@NotNull(message = "Required")
	String location;
	@NotNull(message = "Required")
	@DateTimeFormat(iso = ISO.DATE)
	LocalDate dateOfHeld;
	
	
	@ManyToMany(mappedBy = "camps")
	List<Donor> donors;
	

}