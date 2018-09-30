package com.ram.learn.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@JsonSerialize
@JsonDeserialize
public class Address {
	
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String stateProvice;
	private String postalCode;
	private String country;
	private ContactType type;

}
