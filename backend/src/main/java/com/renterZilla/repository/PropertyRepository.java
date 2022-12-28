package com.renterZilla.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.renterZilla.model.Property;

public interface PropertyRepository extends JpaRepository<Property, Long> {
  List<Property> findByAvailable(boolean available);

  List<Property> findByCityContainingIgnoreCase(String city);
}
