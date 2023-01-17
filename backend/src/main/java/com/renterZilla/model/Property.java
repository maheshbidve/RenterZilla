package com.renterZilla.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "property")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Property {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long property_id;

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

	@Column(name = "latitude")
	private double latitude;

	@Column(name = "longitude")
	private double longitude;

	@OneToMany(mappedBy="property")
	private Set<PropertyFiles> files;

	public Property(String type, String city, Integer pincode, String address, double latitude, double longitude, boolean available) {
		this.type = type;
		this.city = city;
		this.pincode = pincode;
		this.address = address;
		this.latitude = latitude;
		this.longitude = longitude;
		this.available = available;
	}
}
