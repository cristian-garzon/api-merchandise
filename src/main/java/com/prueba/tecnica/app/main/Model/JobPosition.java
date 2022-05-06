package com.prueba.tecnica.app.main.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class JobPosition {
    //  Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "id_job_position")
    private int idJobPosition;

    private String name;



    @OneToMany(mappedBy = "jobPosition", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Employee> employees;

    // constructor
    public JobPosition() {
        this.employees = new ArrayList<>();
    }

    // setters
    public void setIdJobPosition(int idJobPosition) {
        this.idJobPosition = idJobPosition;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    // getters
    public int getIdJobPosition() {
        return idJobPosition;
    }

    public String getName() {
        return name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}
