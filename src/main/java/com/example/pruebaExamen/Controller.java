package com.example.pruebaExamen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/apo")
public class Controller {

    @Autowired
    private Songrepository songrepository;
    @Autowired
    private ServiceCantante serviceCantante;
    @PostMapping("/prueba")
    public ResponseEntity pruebaDeFogeo(@RequestBody Cantante cantante){
       try{
           songrepository.save(cantante);
           return ResponseEntity.ok(cantante);
       } catch (Exception e){
           System.out.println("La has liado");
           return ResponseEntity.notFound().build();
       }
    }

    @GetMapping("/{id}")
    public ResponseEntity prueba2(@PathVariable int id){
        try {
            Cantante cantante =serviceCantante.buscarCantante(id);
            return ResponseEntity.ok(cantante);
        } catch (NullPointerException e){
            return ResponseEntity.notFound().build();
        }
    }
}
