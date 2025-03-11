package com.example.pruebaExamen.controller;

import com.example.pruebaExamen.model.Alquiler;
import com.example.pruebaExamen.model.Coche;
import com.example.pruebaExamen.model.Usuario;
import com.example.pruebaExamen.service.AlquilerService;
import com.example.pruebaExamen.service.CocheService;
import com.example.pruebaExamen.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/api")
public class Controller {

    // Coche
    @Autowired
    private CocheService cocheService;

    @PostMapping("coche/crear")
    public ResponseEntity createCoche(@RequestBody Coche coche){
       try{
           cocheService.createCoche(coche);
           return ResponseEntity.ok(coche);
       } catch (Exception e){

           System.out.println("La has liado");
           return ResponseEntity.notFound().build();
       }
    }

    @GetMapping("coche/id/{id}")
    public ResponseEntity getCocheById(@PathVariable int id){
        try {
            Coche cantante =cocheService.getCoche(id);
            return ResponseEntity.ok(cantante);
        } catch (NullPointerException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("coche/{id}")
    public ResponseEntity deleteCocheById(@PathVariable int id){
        try {
            cocheService.delteCocheById(id);
            return ResponseEntity.ok().build();
        } catch (NullPointerException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("coche/{id}")
    public ResponseEntity<Coche> modifyModelFromCoche(
            @PathVariable int id, // Cambiado a Long para coincidir con BIGSERIAL
            @RequestBody Map<String, String> request) {
        try {
            String model = request.get("model");
            if (model == null || model.isEmpty()) {
                return ResponseEntity.badRequest().body(null);
            }
            Coche updatedCoche = cocheService.modifyCocheById(id, model);
            return ResponseEntity.ok(updatedCoche);
        } catch (RuntimeException e) {
            // Podrías registrar la excepción aquí para depuración
            return ResponseEntity.badRequest().build();
        }
    }

    // Busqueda coches

    @GetMapping("coche/lista")
    public ResponseEntity getCocheByMarcaOrModelo(
            @RequestParam(required = false) String  model,
            @RequestParam(required = false) String  brand
    ){
        try {
            List<Coche> listOfCOches =cocheService.getCocheByMarcaOrModelo(brand, model);

            return ResponseEntity.ok(listOfCOches);
        } catch (NullPointerException e){
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("coche/{avability}")
    public ResponseEntity getCochesByAvaiables(@PathVariable Boolean avability){
        try {
            List<Coche> listOfCOches =cocheService.getCochesByAvailibility(avability);
            return ResponseEntity.ok(listOfCOches);
        } catch (NullPointerException e){
            return ResponseEntity.notFound().build();
        }
    }


    //Usuario
    // Coche
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/crearUser")
    public ResponseEntity createUser(@RequestBody Usuario usuario){
        try{
            usuarioService.createUser(usuario);
            return ResponseEntity.ok(usuario);
        } catch (Exception e){

            System.out.println("La has liado");
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("user/{id}")
    public ResponseEntity getUserById(@PathVariable int id){
        try {
            Usuario usuario =usuarioService.getUser(id);
            return ResponseEntity.ok(usuario);
        } catch (NullPointerException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("user/{id}")
    public ResponseEntity<Usuario> deleteUserById(@PathVariable int id){
        try {
            usuarioService.delteUserById(id);
            return ResponseEntity.ok().build();
        } catch (NullPointerException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("user/{id}")
    public ResponseEntity<Usuario> modifyUserById(
            @PathVariable int id,
            @RequestBody Map<String, String> request) {
        try {
            String model = request.get("cspEdad");
            if (model == null || model.isEmpty()) {
                return ResponseEntity.badRequest().body(null);
            }
            Usuario usuario = usuarioService.modifyUserById(id, model);
            return ResponseEntity.ok(usuario);
        } catch (RuntimeException e) {
            // Podrías registrar la excepción aquí para depuración
            return ResponseEntity.badRequest().build();
        }
    }


    @Autowired
    private AlquilerService alquilerService;

    @PostMapping("/crearAlquiler")
    public ResponseEntity createAlquiler(@RequestBody Alquiler alquiler) {
        try {
            alquilerService.createAlquiler(alquiler);
            return ResponseEntity.ok(alquiler);
        } catch (Exception e) {
            System.out.println("La has liado");
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("alquiler/{id}")
    public ResponseEntity getAlquilerById(@PathVariable int id) {
        try {
            Alquiler alquiler = alquilerService.getAlquiler(id);
            return ResponseEntity.ok(alquiler);
        } catch (NullPointerException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("alquiler/{id}")
    public ResponseEntity deleteAlquilerById(@PathVariable int id) {
        try {
            alquilerService.deleteAlquilerById(id);
            return ResponseEntity.ok().build();
        } catch (NullPointerException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("alquiler/{id}")
    public ResponseEntity modifyAlquilerById(
            @PathVariable int id,
            @RequestBody Map<String, String> request) {
        try {
            String status = request.get("status");
            if (status == null || status.isEmpty()) {
                return ResponseEntity.badRequest().body(null);
            }
            Alquiler alquiler = alquilerService.modifyAlquilerById(id, status);
            return ResponseEntity.ok(alquiler);
        } catch (RuntimeException e) {
            // Podrías registrar la excepción aquí para depuración
            return ResponseEntity.badRequest().build();
        }
    }

    // alquiler rental

}
