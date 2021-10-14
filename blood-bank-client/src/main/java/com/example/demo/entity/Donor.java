package com.example.demo.entity;

import java.time.LocalDate;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Range;
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
public class Donor {
	@Id
	int id;
	@NotNull(message = "Required")
	@Range(min = 18,max=70,message = "Age should be between 18 and 70")
	int age;
	@NotNull(message = "Required")
	String donorName;
	@NotNull(message = "Required")
	String location;
	@NotNull(message = "Required")
	String bloodGroup;
	@NotNull(message = "Required")
	String email;
	@NotNull(message = "Required")
	@DateTimeFormat(iso = ISO.DATE)
	LocalDate lastDonationDate;
	
}
