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


@RestController
@RequestMapping("/api/merchandise")
@CrossOrigin
public class MerchandiseController {


    @Autowired
    private IMerchandiseService merchandiseService;

    @GetMapping("/{idMerchandise}")
    public ResponseEntity<?> findMerchandiseById(@PathVariable long idMerchandise){
        try {
            MerchandiseDto dtoMerchandise = merchandiseService.findMerchandise(idMerchandise);
            if(dtoMerchandise == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            return ResponseEntity.ok().body(dtoMerchandise);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping()
    public ResponseEntity<?> listMerchandise(){
        try{
            return ResponseEntity.ok().body(merchandiseService.listMerchandise());
        } catch (Exception e ){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping()
    public ResponseEntity<?> addMerchandise(@RequestBody AddMerchandiseDto dtoAddMerchandise){
        try {
            MerchandiseDto dtoMerchandise = merchandiseService.addMerchandise(dtoAddMerchandise);
            if(dtoMerchandise == null) ResponseEntity.status(HttpStatus.BAD_REQUEST).body("un error ha ocurrido");
            return ResponseEntity.ok().body(dtoMerchandise);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/{idMerchandise}")
    public ResponseEntity<?> deleteMerchandise(@PathVariable long idMerchandise){
        try{
            merchandiseService.deleteMerchandise(idMerchandise);
            return ResponseEntity.noContent().build();
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    @PutMapping()
    public ResponseEntity<?>
        editMerchandise(@RequestBody EditMerchandiseDto dtoEditMerchandise){
        try{
            MerchandiseDto dtoMerchandise = merchandiseService.editMerchandise(dtoEditMerchandise);
            if(dtoMerchandise == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            return ResponseEntity.ok().body(dtoMerchandise);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/filter")
    public ResponseEntity<?> filterMerchandise(@RequestBody FilterMerchandiseDto dtoFilterMerchandise){
        try {
            return ResponseEntity.ok().body(merchandiseService.filterMerchandise(dtoFilterMerchandise));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
