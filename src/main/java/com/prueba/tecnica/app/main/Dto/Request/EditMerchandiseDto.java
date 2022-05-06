package com.prueba.tecnica.app.main.Dto.Request;

public class EditMerchandiseDto extends AddMerchandiseDto{

    private Long idMerchandise;

    // getters
    public Long getIdMerchandise() {
        return idMerchandise;
    }


    // setters

    public void setIdMerchandise(Long idMerchandise) {
        this.idMerchandise = idMerchandise;
    }
}
