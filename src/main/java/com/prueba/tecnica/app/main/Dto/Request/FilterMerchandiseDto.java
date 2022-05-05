package com.prueba.tecnica.app.main.Dto.Request;

import org.springframework.lang.Nullable;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;


public class FilterMerchandiseDto {
    private Long idEmployee;

    private Long idMerchandise;


    //getters

    public Long getIdEmployee() {
        return idEmployee;
    }

    public Long getIdMerchandise() {
        return idMerchandise;
    }


    //setters


    public void setIdEmployee(Long idEmployee) {
        this.idEmployee = idEmployee;
    }

    public void setIdMerchandise(Long idMerchandise) {
        this.idMerchandise = idMerchandise;
    }
}
