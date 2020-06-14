package com.saeeds28.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name ="Address_List")
@Table(name="Address_List")
@JsonPropertyOrder({"Street","City","Province","Country","PostalCode"})
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Address {
	@Id
	@JsonIgnore
	private String emailAddress;
	
	@Column(nullable=false)
	@JsonProperty("Street")
	private String street;
	
	@Column(nullable=false)
	@JsonProperty("City")
	private String city;
	
	@Column(nullable=false)
	@JsonProperty("Province")
	private String province;
	
	@Column(nullable=false)
	@JsonProperty("Country")
	private String country;
	
	@Column(nullable=false)
	@JsonProperty("PostalCode")
	private String postalCode;	
}
