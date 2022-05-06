package com.prueba.tecnica.app.main.Dto.MerchandiseDb;

import com.prueba.tecnica.app.main.Model.JobPosition;

public class EmployeeDto {
    private Long idEmployee;
    private String name;
    private int age;

    private JobPositionDto jobPosition;
    // getters

    public Long getIdEmployee() {
        return idEmployee;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public JobPositionDto getJobPosition() {
        return jobPosition;
    }

    // setters


    public void setIdEmployee(Long idEmployee) {
        this.idEmployee = idEmployee;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setJobPosition(JobPositionDto jobPosition) {
        this.jobPosition = jobPosition;
    }
}
