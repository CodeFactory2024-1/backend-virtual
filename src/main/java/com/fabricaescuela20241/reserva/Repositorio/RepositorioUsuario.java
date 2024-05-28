package com.fabricaescuela20241.reserva.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fabricaescuela20241.reserva.Modelo.Usuario;


public interface RepositorioUsuario extends JpaRepository<Usuario, Integer>{

}