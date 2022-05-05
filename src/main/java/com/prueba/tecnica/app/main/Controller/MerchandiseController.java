package com.prueba.tecnica.app.main.Controller;

import com.prueba.tecnica.app.main.Dto.Request.AddMerchandiseDto;
import com.prueba.tecnica.app.main.Model.Merchandise;
import com.prueba.tecnica.app.main.Service.IMerchandiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@RestController
@RequestMapping("/merchandise")
public class MerchandiseController {


    @Autowired
    private IMerchandiseService merchandiseService;

    @GetMapping("/find/{idMerchandise}")
    public ResponseEntity<Merchandise> findMerchandiseById(@PathVariable long idMerchandise){
        Merchandise merchandise = merchandiseService.findMerchandise(idMerchandise);
        if(merchandise == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        return ResponseEntity.ok().body(merchandise);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Merchandise>> listMerchandise(){
        return ResponseEntity.ok().body(merchandiseService.listMerchandise());
    }

    @PostMapping("/add/{idEmployee}")
    public ResponseEntity<Merchandise> addMerchandise(@RequestBody Merchandise merchandiseRequest, @PathVariable long idEmployee){
        Merchandise merchandise = merchandiseService.addMerchandise(merchandiseRequest, idEmployee);
        if(merchandise == null) ResponseEntity.status(HttpStatus.BAD_REQUEST).body("un error ha ocurrido");
        return ResponseEntity.ok().body(merchandise);
    }

    @DeleteMapping("/delete/{idMerchandise}")
    public ResponseEntity<Merchandise> deleteMerchandise(@PathVariable long idMerchandise){
        merchandiseService.deleteMerchandise(idMerchandise);
        return ResponseEntity.noContent().build();
    }
}