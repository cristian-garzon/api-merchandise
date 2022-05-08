package com.prueba.tecnica.app.main.Service.Implements;

import com.prueba.tecnica.app.main.Dto.MerchandiseDb.EmployeeDto;
import com.prueba.tecnica.app.main.Repository.IEmployeeRepo;
import com.prueba.tecnica.app.main.Service.IEmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IEmployeeServiceImpl implements IEmployeeService {


    @Autowired
    private IEmployeeRepo employeeRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    @Transactional(readOnly = true)
    public List<EmployeeDto> listEmployeeDto(){
        return employeeRepo.findAll().stream().map(employee -> modelMapper.map(employee, EmployeeDto.class)).
                collect(Collectors.toList());
    }
}
