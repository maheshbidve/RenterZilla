package com.renterZilla.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "property")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Property {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "type")
	private String type;

	@Column(name = "city")
	private String city;

	@Column(name = "pincode")
	private Integer pincode;

	@Column(name = "address")
	private String address;

	@Column(name = "available")
	private boolean available;

	public Property(String type, String city, Integer pincode, String address, boolean available) {
		this.id = id;
		this.type = type;
		this.city = city;
		this.pincode = pincode;
		this.address = address;
		this.available = available;
	}
}
