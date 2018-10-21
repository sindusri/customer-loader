package com.ram.learn.model;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

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
@JsonRootName(value = "order")
@Entity(name="ORDER")
public class Order {

@Id
@Column(name="ID")
private UUID id;
@Column(name="CUSTOMER_ID")
private UUID customerId;
@Column(name="ORDDER_DATE_TIME")
private LocalDateTime orderDateTimeUTC;
@Column(name="ORDER_STATUS")
@Enumerated(EnumType.STRING)
private ORDER_STATUS orderStatus;
}
