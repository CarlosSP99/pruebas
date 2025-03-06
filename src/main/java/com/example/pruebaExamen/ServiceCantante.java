package com.example.pruebaExamen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServiceCantante {


    @Autowired
    private Songrepository songrepository;

    public Cantante guardarCantante(Cantante cantante){
        return songrepository.save(cantante);
    }

    public Cantante buscarCantante(int id){
        Optional<Cantante> cantante = songrepository.findById(id);
        if (cantante.isPresent()){
            return cantante.get();
        } else{
            Cantante cantanteNulo=null;
            return cantanteNulo;
        }
    }
}
