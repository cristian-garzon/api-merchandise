package com.prueba.tecnica.app.main.Service;

import com.prueba.tecnica.app.main.Dto.Request.AddMerchandiseDto;
import com.prueba.tecnica.app.main.Dto.Request.EditMerchandiseDto;
import com.prueba.tecnica.app.main.Dto.Request.FilterMerchandiseDto;
import com.prueba.tecnica.app.main.Dto.MerchandiseDb.MerchandiseDto;

import java.util.List;

public interface IMerchandiseService {
    public List<MerchandiseDto> listMerchandise();
    public MerchandiseDto addMerchandise(AddMerchandiseDto dtoAddMerchandise);
    public MerchandiseDto findMerchandise(long idMerchandise);
    public void deleteMerchandise(long idMerchandise);
    public MerchandiseDto editMerchandise(EditMerchandiseDto merchandiseDto);
    public List<MerchandiseDto> filterMerchandise(FilterMerchandiseDto dtoFilterMerchandise);
}
