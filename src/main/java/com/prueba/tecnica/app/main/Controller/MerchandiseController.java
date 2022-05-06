package com.prueba.tecnica.app.main.Controller;

import com.prueba.tecnica.app.main.Dto.Request.AddMerchandiseDto;
import com.prueba.tecnica.app.main.Dto.Request.EditMerchandiseDto;
import com.prueba.tecnica.app.main.Dto.Request.FilterMerchandiseDto;
import com.prueba.tecnica.app.main.Dto.MerchandiseDb.MerchandiseDto;
import com.prueba.tecnica.app.main.Service.IMerchandiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/merchandise")
public class MerchandiseController {


    @Autowired
    private IMerchandiseService merchandiseService;

    @GetMapping("/find/{idMerchandise}")
    public ResponseEntity<MerchandiseDto> findMerchandiseById(@PathVariable long idMerchandise){
        MerchandiseDto dtoMerchandise = merchandiseService.findMerchandise(idMerchandise);
        if(dtoMerchandise == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        return ResponseEntity.ok().body(dtoMerchandise);
    }

    @GetMapping()
    public ResponseEntity<List<MerchandiseDto>> listMerchandise(){
        return ResponseEntity.ok().body(merchandiseService.listMerchandise());
    }

    @PostMapping()
    public ResponseEntity<MerchandiseDto> addMerchandise(@RequestBody AddMerchandiseDto dtoAddMerchandise){
        MerchandiseDto dtoMerchandise = merchandiseService.addMerchandise(dtoAddMerchandise);
        if(dtoMerchandise == null) ResponseEntity.status(HttpStatus.BAD_REQUEST).body("un error ha ocurrido");
        return ResponseEntity.ok().body(dtoMerchandise);
    }

    @DeleteMapping("/delete/{idMerchandise}")
    public ResponseEntity<?> deleteMerchandise(@PathVariable long idMerchandise){
        merchandiseService.deleteMerchandise(idMerchandise);
        return ResponseEntity.noContent().build();
    }
    @PutMapping()
    public ResponseEntity<MerchandiseDto>
        editMerchandise(@RequestBody EditMerchandiseDto dtoEditMerchandise){
        MerchandiseDto dtoMerchandise = merchandiseService.editMerchandise(dtoEditMerchandise);
        if(dtoMerchandise == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        return ResponseEntity.ok().body(dtoMerchandise);
    }

    @PostMapping("/filter")
    public ResponseEntity<List<MerchandiseDto>> filterMerchandise(@RequestBody FilterMerchandiseDto dtoFilterMerchandise){
        return ResponseEntity.ok().body(merchandiseService.filterMerchandise(dtoFilterMerchandise));
    }
}
