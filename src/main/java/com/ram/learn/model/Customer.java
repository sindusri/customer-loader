package com.ram.learn.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonRootName;
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
@JsonRootName(value = "customer")
public class Customer{
	
	private UUID id;
	private String firstName;
	private String lastName;
	private Contact contact;
	 
}
