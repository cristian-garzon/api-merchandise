package com.prueba.tecnica.app.main.Service.Implements;

import com.prueba.tecnica.app.main.Dto.Request.AddMerchandiseDto;
import com.prueba.tecnica.app.main.Dto.Request.EditMerchandiseDto;
import com.prueba.tecnica.app.main.Dto.Request.FilterMerchandiseDto;
import com.prueba.tecnica.app.main.Dto.MerchandiseDb.MerchandiseDto;
import com.prueba.tecnica.app.main.Model.Employee;
import com.prueba.tecnica.app.main.Model.Merchandise;
import com.prueba.tecnica.app.main.Repository.IEmployeeRepo;
import com.prueba.tecnica.app.main.Repository.IMerchandiseRepo;
import com.prueba.tecnica.app.main.Service.IMerchandiseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IMerchandiseServiceImpl implements IMerchandiseService {
    @Autowired
    private IMerchandiseRepo merchandiseRepo;

    @Autowired
    private IEmployeeRepo employeeRepo;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    @Transactional(readOnly = true)
    public List<MerchandiseDto> listMerchandise(){
        return mapListMerchandise(merchandiseRepo.findAll());
    }

    @Override
    @Transactional
    public MerchandiseDto addMerchandise(AddMerchandiseDto dtoAddMerchandise){
        Merchandise merchandise = modelMapper.map(dtoAddMerchandise, Merchandise.class);
        Employee employee = employeeRepo.findById(dtoAddMerchandise.getIdEmployee()).orElse(null);
        if(employee != null){
            merchandise.setEmployee(employee);
            merchandise = merchandiseRepo.save(merchandise);
            return modelMapper.map(merchandise, MerchandiseDto.class);
        }
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public MerchandiseDto findMerchandise(long idMerchandise){
        Merchandise merchandise = merchandiseRepo.findById(idMerchandise).orElse(null);
        if(merchandise != null){
            return modelMapper.map(merchandise, MerchandiseDto.class);
        }
        return null;
    }

    @Override
    @Transactional
    public void deleteMerchandise(long idMerchandise){
        merchandiseRepo.deleteById(idMerchandise);
    }

    @Override
    @Transactional
    public MerchandiseDto editMerchandise(EditMerchandiseDto dtoEditMerchandise){
        Merchandise merchandiseEdit = merchandiseRepo.findById(dtoEditMerchandise.getIdMerchandise()).orElse(null);
        if(merchandiseEdit != null){
            merchandiseEdit = modelMapper.map(dtoEditMerchandise, Merchandise.class);
            Employee employee = employeeRepo.findById(dtoEditMerchandise.getIdEmployee()).orElse(null);
            merchandiseEdit.setEmployee(employee == null ? merchandiseEdit.getEmployee() : employee);
            merchandiseEdit = merchandiseRepo.save(merchandiseEdit);
            return modelMapper.map(merchandiseEdit, MerchandiseDto.class);
        }
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public List<MerchandiseDto> filterMerchandise(FilterMerchandiseDto dtoFilterMerchandise){
        return mapListMerchandise(merchandiseRepo.
                filterMerchandise(dtoFilterMerchandise.getIdEmployee(), dtoFilterMerchandise.getIdMerchandise(),
                        dtoFilterMerchandise.getNameEmployee(), dtoFilterMerchandise.getNameMerchandise()));
    }

    private List<MerchandiseDto>  mapListMerchandise(List<Merchandise> merchandises){
        return merchandises.stream().map(merchandise -> modelMapper.map(merchandise, MerchandiseDto.class))
                .collect(Collectors.toList());
    }

}