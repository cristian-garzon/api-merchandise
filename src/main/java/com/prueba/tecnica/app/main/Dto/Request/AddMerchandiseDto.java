package com.prueba.tecnica.app.main.Dto.Request;

import java.util.Date;

public class AddMerchandiseDto {
    private String productName;
    private int quantity;
    private Date EnterDate;
    private Long idEmployee;


    //getters

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public Date getEnterDate() {
        return EnterDate;
    }

    public Long getIdEmployee() {
        return idEmployee;
    }

    // setters

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setEnterDate(Date enterDate) {
        EnterDate = enterDate;
    }

    public void setIdEmployee(Long idEmployee) {
        this.idEmployee = idEmployee;
    }
}
