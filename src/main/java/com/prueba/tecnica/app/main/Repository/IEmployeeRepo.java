package com.prueba.tecnica.app.main.Repository;

import com.prueba.tecnica.app.main.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepo extends JpaRepository<Employee, Long> {
}
