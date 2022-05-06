package com.prueba.tecnica.app.main.Dto.MerchandiseDb;

import com.prueba.tecnica.app.main.Model.Employee;

import java.util.Date;

public class MerchandiseDto {
    private Long idMerchandise;
    private String productName;
    private int quantity;
    private Date enterDate;

    private EmployeeDto employee;

    // getters


    public EmployeeDto getEmployee() {
        return employee;
    }

    public Long getIdMerchandise() {
        return idMerchandise;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public Date getEnterDate() {
        return enterDate;
    }

    // setters


    public void setEmployee(EmployeeDto employee) {
        this.employee = employee;
    }

    public void setIdMerchandise(Long idMerchandise) {
        this.idMerchandise = idMerchandise;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setEnterDate(Date enterDate) {
        this.enterDate = enterDate;
    }
}
