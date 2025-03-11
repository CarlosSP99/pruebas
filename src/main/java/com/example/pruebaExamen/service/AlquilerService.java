package com.example.pruebaExamen.service;

import com.example.pruebaExamen.model.Alquiler;
import com.example.pruebaExamen.model.Coche;
import com.example.pruebaExamen.repository.AlquilerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlquilerService {

    @Autowired
    private AlquilerRepository alquilerRepository;

    public Alquiler createAlquiler(Alquiler alquiler) {
        return alquilerRepository.save(alquiler);
    }

    public void deleteAlquilerById(int id) {
        alquilerRepository.deleteById(id);
    }

    public Alquiler modifyAlquilerById(int id, String status) {
        Optional<Alquiler> alquilerOpt = alquilerRepository.findById(id);
        if (alquilerOpt.isPresent()) {
            Alquiler alquiler = alquilerOpt.get();
            alquiler.setStatus(status);
            return alquilerRepository.save(alquiler);
        } else {
            throw new RuntimeException("Alquiler not found with id: " + id);
        }
    }

    public Alquiler getAlquiler(int id) {
        Optional<Alquiler> alquilerOpt = alquilerRepository.findById(id);
        if (alquilerOpt.isPresent()) {
            return alquilerOpt.get();
        } else {
            throw new RuntimeException("Alquiler not found with id: " + id);
        }
    }




}