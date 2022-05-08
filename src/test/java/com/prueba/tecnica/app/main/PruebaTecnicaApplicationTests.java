package com.prueba.tecnica.app.main;

import com.prueba.tecnica.app.main.Dto.MerchandiseDb.EmployeeDto;
import com.prueba.tecnica.app.main.Dto.MerchandiseDb.MerchandiseDto;
import com.prueba.tecnica.app.main.Dto.Request.AddMerchandiseDto;
import com.prueba.tecnica.app.main.Dto.Request.EditMerchandiseDto;
import com.prueba.tecnica.app.main.Dto.Request.FilterMerchandiseDto;
import com.prueba.tecnica.app.main.Service.IEmployeeService;
import com.prueba.tecnica.app.main.Service.IMerchandiseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
class PruebaTecnicaApplicationTests {

    @Autowired
    private IMerchandiseService merchandiseService;

    @Autowired
    private IEmployeeService employeeService;

    @Test
    void filterMerchandise(){
        FilterMerchandiseDto dtoFilterMerchandise = new FilterMerchandiseDto();
        dtoFilterMerchandise.setNameMerchandise("cilindros");
        dtoFilterMerchandise.setNameEmployee("");
        List<MerchandiseDto> dtoMerchandises = merchandiseService.filterMerchandise(dtoFilterMerchandise);
        assert  dtoMerchandises.size()  == 2;
    }
    @Test
    void listMerchandise() {
        List<MerchandiseDto> dtoMerchandises = merchandiseService.listMerchandise();
        assert  dtoMerchandises.size()  == 5;
    }

    @Test
    void findMerchandise(){
        MerchandiseDto merchandiseDto = merchandiseService.findMerchandise(2);
        assert (merchandiseDto.getProductName()).equals("motor 2.5 TFSI") && merchandiseDto.getEmployee().getName().equals("camilo");
    }

    @Test
    void deleteMerchandise(){
        merchandiseService.deleteMerchandise(1L);
        MerchandiseDto merchandiseDto = merchandiseService.findMerchandise(1);
        assert merchandiseDto == null;

    }
    @Test
    void createMerchandise() {
        AddMerchandiseDto dtoAddMerchandise = new AddMerchandiseDto();
        dtoAddMerchandise.setIdEmployee(1L);
        dtoAddMerchandise.setProductName("llave inglesa2");
        dtoAddMerchandise.setEnterDate(new Date());
        dtoAddMerchandise.setQuantity(5);

        MerchandiseDto dtoMerchandise = merchandiseService.addMerchandise(dtoAddMerchandise);
        assert(dtoMerchandise.getEmployee().getName()).equals("cristian");

    }

    @Test
    void editMerchandise(){
        EditMerchandiseDto dtoEditMerchandise = new EditMerchandiseDto();
        dtoEditMerchandise.setIdMerchandise(3L);
        dtoEditMerchandise.setEnterDate(new Date());
        dtoEditMerchandise.setIdEmployee(1L);
        dtoEditMerchandise.setQuantity(6);
        dtoEditMerchandise.setProductName("motor 1.6 EcoBoast");
        MerchandiseDto dtoMerchandise = merchandiseService.editMerchandise(dtoEditMerchandise);
        assert  (dtoMerchandise.getEmployee().getName()).equals("cristian") && (dtoMerchandise.getProductName()).equals("motor 1.6 EcoBoast");
    }

    @Test
    void ListEmployee(){
        List<EmployeeDto> dtoEmployees = employeeService.listEmployeeDto();
        assert  dtoEmployees.size()  == 2;
    }


}
