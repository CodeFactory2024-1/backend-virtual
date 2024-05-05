package com.udea.edu.co.busquedadevuelos.backendvirtual.services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.udea.edu.co.busquedadevuelos.backendvirtual.repositories.AeropuertoRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AeropuertoService {
    
    private final AeropuertoRepository aeropuertoRepository;

    public AeropuertoService(AeropuertoRepository aeropuertoRepository){
        this.aeropuertoRepository = aeropuertoRepository;
    }

    public List<Object> listAeropuertos() {
        return aeropuertoRepository.listAeropuertos();
    }

    public List<Object> findAeropuerto(String nombre) {
        List<Object> aeropuertos = aeropuertoRepository.findAeropuertoByNombre(nombre);
        return aeropuertos;
    }

}
