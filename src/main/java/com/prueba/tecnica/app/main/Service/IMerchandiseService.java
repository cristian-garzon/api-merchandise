package com.prueba.tecnica.app.main.Service;

import com.prueba.tecnica.app.main.Model.Merchandise;
import org.springframework.lang.Nullable;

import java.util.Date;
import java.util.List;

public interface IMerchandiseService {
    public List<Merchandise> listMerchandise();
    public Merchandise addMerchandise(Merchandise merchandise, long idEmployee);
    public Merchandise findMerchandise(long idMerchandise);
    public void deleteMerchandise(long idMerchandise);
    public Merchandise editMerchandise(long idMerchandise, Merchandise merchandise, long idEmployee);
    public List<Merchandise> filterMerchandise(@Nullable Long idEmployee, @Nullable Long idMerchandise);
}
