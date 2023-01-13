package com.renterZilla.repository;

import com.renterZilla.model.PropertyFiles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface PropertyFilesRepository extends JpaRepository<PropertyFiles, Long> {
    Optional<PropertyFiles> findByName(String name);
}