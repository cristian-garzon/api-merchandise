package com.prueba.tecnica.app.main.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Merchandise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_merchandise")
    private Long idMerchandise;

    @Column(name = "product_name", unique = true)
    private String productName;

    private int quantity;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "enter_date")
    private Date enterDate;

    @JsonIgnoreProperties(value = {"merchandises"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_employee")
    @JsonIgnore
    private Employee employee;

    // getters
    public Long getIdMerchandise() {
        return idMerchandise;
    }

    public String getProductName() {
        return productName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Date getEnterDate() {
        return enterDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    //setters

    public void setIdMerchandise(Long idMerchandise) {
        this.idMerchandise = idMerchandise;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setEnterDate(Date enterDate) {
        this.enterDate = enterDate;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }


}
