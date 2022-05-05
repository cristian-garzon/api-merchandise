package com.prueba.tecnica.app.main.Service;

import com.prueba.tecnica.app.main.Dto.Request.AddMerchandiseDto;
import com.prueba.tecnica.app.main.Model.Merchandise;

import java.util.List;

public interface IMerchandiseService {
    public List<Merchandise> listMerchandise();
    public Merchandise addMerchandise(Merchandise merchandise, long idEmployee);
    public Merchandise findMerchandise(long idMerchandise);
    public void deleteMerchandise(long idMerchandise);
}