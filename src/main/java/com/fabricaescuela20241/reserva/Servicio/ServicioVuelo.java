package com.fabricaescuela20241.reserva.Servicio;

import com.fabricaescuela20241.reserva.Modelo.Vuelo;
import com.fabricaescuela20241.reserva.Repositorio.RepositorioVuelo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioVuelo {

    @Autowired
    private RepositorioVuelo repositorioVuelo;

    public Vuelo guardarVuelo(Vuelo vuelo){
        return repositorioVuelo.save(vuelo);
    }

    public List<Vuelo> obtenerTodosLosVuelos(){
        return repositorioVuelo.findAll();
    }
}
