package com.renterZilla.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.renterZilla.repository.PropertyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.renterZilla.model.Property;

@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/api")
public class PropertyController {

	private static final Logger LOGGER = LoggerFactory.getLogger(PropertyController.class);

	@Autowired
	PropertyRepository propertyRepository;

	@GetMapping("/property")
	@PreAuthorize("hasRole('TENANT') or hasRole('ADMIN')")
	public ResponseEntity<List<Property>> getAllProperties(@RequestParam(required = false) String city) {
		try {
			List<Property> properties = new ArrayList<Property>();

			if (city == null)
				propertyRepository.findAll().forEach(properties::add);
			else
				propertyRepository.findByCityContainingIgnoreCase(city).forEach(properties::add);

			if (properties.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(properties, HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error("Failed to load property list", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/property/{id}")
	public ResponseEntity<Property> getPropertyById(@PathVariable("id") long id) {
		Optional<Property> propertyData = propertyRepository.findById(id);

		if (propertyData.isPresent()) {
			return new ResponseEntity<>(propertyData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/property")
	public ResponseEntity<Property> createProperty(@RequestBody Property property) {
		try {
			Property _property = propertyRepository
					.save(new Property(property.getType(), property.getCity(), property.getPincode(), property.getAddress(), property.getLatitude(), property.getLongitude(), true));
			return new ResponseEntity<>(_property, HttpStatus.CREATED);
		} catch (Exception e) {
			LOGGER.error("Failed to save property", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/property/{id}")
	public ResponseEntity<Property> updateProperty(@PathVariable("id") long id, @RequestBody Property property) {
		Optional<Property> propertyData = propertyRepository.findById(id);

		if (propertyData.isPresent()) {
			Property _property = propertyData.get();
			_property.setType(property.getType());
			_property.setCity(property.getCity());
			_property.setPincode(property.getPincode());
			_property.setAddress(property.getAddress());
			_property.setAvailable(property.isAvailable());
			return new ResponseEntity<>(propertyRepository.save(_property), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/property/{id}")
	public ResponseEntity<HttpStatus> deleteProperty(@PathVariable("id") long id) {
		try {
			propertyRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			LOGGER.error("Failed to delete property", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/property")
	public ResponseEntity<HttpStatus> deleteAllProperty() {
		try {
			propertyRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/property/available")
	public ResponseEntity<List<Property>> findByAvailable() {
		try {
			List<Property> properties = propertyRepository.findByAvailable(true);

			if (properties.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(properties, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
