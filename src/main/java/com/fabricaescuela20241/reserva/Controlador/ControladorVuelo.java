package com.fabricaescuela20241.reserva.Controlador;

import com.fabricaescuela20241.reserva.Modelo.Vuelo;
import com.fabricaescuela20241.reserva.Servicio.ServicioVuelo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vuelos")
public class ControladorVuelo {

    @Autowired
    private final ServicioVuelo servicioVuelo;

    public ControladorVuelo(ServicioVuelo servicioVuelo) {
        this.servicioVuelo = servicioVuelo;
    }

    @GetMapping("/all")
    public List<Vuelo> obtenerTodasLosVuelos() {
        return servicioVuelo.obtenerTodosLosVuelos();
    }

    @PostMapping("/crear")
    public Vuelo crearVuelo(@RequestBody Vuelo vuelo) {
        return servicioVuelo.guardarVuelo(vuelo);
    }
}
