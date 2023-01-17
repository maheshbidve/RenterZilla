package com.renterZilla.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
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

	@OneToMany(mappedBy="property")
	private Set<PropertyFiles> files;

	public Property(String type, String city, Integer pincode, String address, boolean available) {
		this.property_id = property_id;
		this.type = type;
		this.city = city;
		this.pincode = pincode;
		this.address = address;
		this.available = available;
	}
}
