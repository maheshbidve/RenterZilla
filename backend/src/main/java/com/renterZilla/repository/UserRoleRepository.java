package com.renterZilla.repository;

import com.renterZilla.model.RoleEnum;
import com.renterZilla.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleEnum name);
}
