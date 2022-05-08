package com.prueba.tecnica.app.main.Controller;


import com.prueba.tecnica.app.main.Dto.MerchandiseDb.EmployeeDto;
import com.prueba.tecnica.app.main.Model.Employee;
import com.prueba.tecnica.app.main.Service.IEmployeeService;
import io.swagger.models.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
@CrossOrigin
public class EmployeeController {


    @Autowired
    private IEmployeeService employeeService;

    @GetMapping()
    public ResponseEntity<List<EmployeeDto>> ListEmployees(){
        return ResponseEntity.ok().body(employeeService.listEmployeeDto());
    }
}
