package com.prueba.tecnica.app.main.Service.Implements;

import com.prueba.tecnica.app.main.Model.Employee;
import com.prueba.tecnica.app.main.Model.Merchandise;
import com.prueba.tecnica.app.main.Repository.IEmployeeRepo;
import com.prueba.tecnica.app.main.Repository.IMerchandiseRepo;
import com.prueba.tecnica.app.main.Service.IMerchandiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class IMerchandiseServiceImpl implements IMerchandiseService {
    @Autowired
    private IMerchandiseRepo merchandiseRepo;

    @Autowired
    private IEmployeeRepo employeeRepo;


    @Override
    @Transactional(readOnly = true)
    public List<Merchandise> listMerchandise(){
        return merchandiseRepo.findAll();
    }

    @Override
    @Transactional
    public Merchandise addMerchandise(Merchandise merchandise, long idEmployee){
        Employee employee = employeeRepo.findById(idEmployee).orElse(null);
        if(employee != null){
            merchandise.setEmployee(employee);
            return merchandiseRepo.save(merchandise);
        }
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public Merchandise findMerchandise(long idMerchandise){
        return merchandiseRepo.findById(idMerchandise).orElse(null);
    }

    @Override
    @Transactional
    public void deleteMerchandise(long idMerchandise){
        merchandiseRepo.deleteById(idMerchandise);
    }

}