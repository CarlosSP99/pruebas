package com.example.pruebaExamen.repository;

import com.example.pruebaExamen.model.Coche;
import com.example.pruebaExamen.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
