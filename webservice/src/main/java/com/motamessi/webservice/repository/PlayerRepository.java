package com.motamessi.webservice.repository;

import com.motamessi.webservice.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Employee, Long> {
    // CRUD
}
