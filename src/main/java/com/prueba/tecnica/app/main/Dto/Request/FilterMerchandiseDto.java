package com.prueba.tecnica.app.main.Dto.Request;



public class FilterMerchandiseDto {
    private Long idEmployee;

    private Long idMerchandise;


    private String NameEmployee;

    private String nameMerchandise;
    //getters


    public String getNameEmployee() {
        return NameEmployee;
    }

    public String getNameMerchandise() {
        return nameMerchandise;
    }

    public Long getIdEmployee() {
        return idEmployee;
    }

    public Long getIdMerchandise() {
        return idMerchandise;
    }


    //setters


    public void setNameEmployee(String nameEmployee) {
        NameEmployee = nameEmployee;
    }

    public void setNameMerchandise(String nameMerchandise) {
        this.nameMerchandise = nameMerchandise;
    }

    public void setIdEmployee(Long idEmployee) {
        this.idEmployee = idEmployee;
    }

    public void setIdMerchandise(Long idMerchandise) {
        this.idMerchandise = idMerchandise;
    }
}
