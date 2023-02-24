package com.renterZilla.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "property")
@Getter
@Setter
@RequiredArgsConstructor
public class Property {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long property_id;

	@Column(name = "type")
	@NotNull
	private String type;

	@Column(name = "city")
	@NotNull
	private String city;

	@Column(name = "pincode")
	@NotNull
	private Integer pincode;

	@Column(name = "address")
	@NotNull
	private String address;

	@Column(name = "available")
	@NotNull
	private boolean available;

	@Column(name = "latitude")
	@NotNull
	private double latitude;

	@Column(name = "longitude")
	@NotNull
	private double longitude;

	@OneToMany(mappedBy="property")
	private Set<PropertyFiles> files;
	
	@Column(name = "flatnumber")
	@NotNull
	private Integer flatnumber;
	
	@Column(name = "floor")
	@NotNull
	private Integer floor;
	
	@Column(name = "building")
	@NotNull
	private String building;

	@Column(name = "street")
	@NotNull
	private String street;
	
	@Column(name = "landmarks")
	@NotNull
	private String landmarks;

	@Column(name = "state")
	@NotNull
	private String state;

	@Column(name = "country")
	@NotNull
	private String country;
	
	@Column(name = "descrption")
	@NotNull
	private String descrption;
	
	@Column(name = "furnishing")
	@NotNull
	private String furnishing;

	@Column(name = "baths")
	@NotNull
	private Integer baths;
	
	@Column(name = "balconies")
	@NotNull
	private Integer balconies;
	
	@Column(name = "facing")
	@NotNull
	private String facing;
	
	@Column(name = "lift")
	@NotNull
	private boolean lift;
	
	@Column(name = "parkings")
	@NotNull
	private Integer parkings;
	
	@Column(name = "area")
	@NotNull
	private Integer area;
	
	@Column(name = "age")
	@NotNull
	private Integer age;
	
	@Column(name = "rent")
	@NotNull
	private Integer rent;
	
	@Column(name = "deposit")
	@NotNull
	private Integer deposit;
	
	@Column(name = "maintenance")
	@NotNull
	private Integer maintenance;

}
