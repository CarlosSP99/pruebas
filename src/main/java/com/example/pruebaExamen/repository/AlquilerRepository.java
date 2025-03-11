package com.example.pruebaExamen.repository;

import com.example.pruebaExamen.model.Alquiler;
import com.example.pruebaExamen.model.Coche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AlquilerRepository  extends JpaRepository<Alquiler, Integer> {


}
