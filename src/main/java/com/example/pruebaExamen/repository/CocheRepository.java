package com.example.pruebaExamen.repository;

import com.example.pruebaExamen.model.Alquiler;
import com.example.pruebaExamen.model.Coche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CocheRepository extends JpaRepository<Coche, Integer> {

    @Query("SELECT s FROM Coche s WHERE s.model = :model OR s.brand = :brand")
    List<Coche> findByModelOrMake(@Param("model") String model, @Param("brand") String brand);

    @Query("SELECT s FROM Coche s WHERE s.available = :available")
    List<Coche> findByAvailable(@Param("available") Boolean available);



}

