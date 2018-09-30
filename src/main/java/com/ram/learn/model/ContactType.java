package com.ram.learn.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
@JsonDeserialize
public enum ContactType {
	BUSINESS, PERSONAL, HOME, WORK
}
