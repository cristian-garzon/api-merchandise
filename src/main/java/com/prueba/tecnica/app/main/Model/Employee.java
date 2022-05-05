package com.prueba.tecnica.app.main.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Employee {

    //attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_employee")
    private Long idEmployee;

    private String name;

    private int age;

    @JsonIgnoreProperties(value = {"employees"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_job_position")
    private JobPosition jobPosition;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "enter_date_company")
    private Date enterDateCompany;

    @JsonIgnoreProperties(value = {"employee"})
    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Merchandise> merchandises;


    // constructor

    public Employee() {
        this.merchandises = new ArrayList<>();
    }


    //setters

    public void setIdEmployee(Long idEmployee) {
        this.idEmployee = idEmployee;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEnterDateCompany(Date enterDateCompany) {
        this.enterDateCompany = enterDateCompany;
    }

    public void setJobPosition(JobPosition jobPosition) {
        this.jobPosition = jobPosition;
    }

    public void setMerchandises(List<Merchandise> merchandises) {
        this.merchandises = merchandises;
    }

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

    public Date getEnterDateCompany() {
        return enterDateCompany;
    }

    public List<Merchandise> getMerchandises() {
        return merchandises;
    }

    public JobPosition getJobPosition() {
        return jobPosition;
    }
}
