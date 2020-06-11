package com.saeeds28.config.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name ="User_List")
@Table(name="User_List")
@JsonPropertyOrder({"Username","Firstname","Lastname","Password","Type","Status","Address"})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
	@Id
	@JsonProperty("Username")
	@Column(name="user_name", nullable=false)
	private String username;
	
	@JsonProperty("Password")
	@Column(name="password_hash", length=256, nullable=false)
	private String password;
	
	@JsonProperty("Firstname")
	@Column(name="first_name", nullable=false)
	private String firstname;
	
	@JsonProperty("Lastname")
	@Column(name="last_name", nullable=false)
	private String lastname;
	
	@JsonProperty("Type")
	@Column(name="user_type", nullable=false)
	private String type;
	
	@JsonProperty("Status")
	@Column(name="user_status", nullable=false)
	private String status;
	
	@JsonProperty("Address")
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="emailAddress")
	private Address address;
}
