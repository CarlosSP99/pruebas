package com.example.pruebaExamen.service;

import com.example.pruebaExamen.model.Coche;
import com.example.pruebaExamen.repository.CocheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CocheService {


    @Autowired
    private CocheRepository cocheRepository;

    public Coche createCoche(Coche coche){
        return cocheRepository.save(coche);
    }

    public void delteCocheById(int id){
        cocheRepository.deleteById(id);
    }

    public Coche modifyCocheById(int id, String precio){
        Optional<Coche> cocheOptional = cocheRepository.findById(id);
        if (cocheOptional.isPresent()) {
            Coche coche = cocheOptional.get();
            coche.setCspPrecio(precio);
            return cocheRepository.save(coche);
        } else {
            throw new RuntimeException("Coche not found with id: " + id); // Lanza una excepción si no se encuentra la canción
        }
    }

    public Coche getCoche(int id){
        Optional<Coche> cocheOptional = cocheRepository.findById(id);
        if (cocheOptional.isPresent()){
            return cocheOptional.get();
        }  else {
            throw new RuntimeException("Song not found with id: " + id); // Lanza una excepción si no se encuentra la canción
        }
    }
    public List<Coche> getCocheByMarcaOrModelo(String marca, String modelo){
        return cocheRepository.findByModelOrMake(modelo, marca);
    }

    public List<Coche> getCochesByAvailibility(Boolean aviable){
        return cocheRepository.findByAvailable(aviable);
    }
}
