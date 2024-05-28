package com.fabricaescuela20241.reserva.Controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fabricaescuela20241.reserva.Modelo.Reserva;
import com.fabricaescuela20241.reserva.Servicio.ServicioReserva;

@RestController
@RequestMapping("/reserva")
public class ControladorReserva {
    
    @Autowired
    private final ServicioReserva servicioReserva;

    public ControladorReserva(ServicioReserva servicioReserva) {
        this.servicioReserva = servicioReserva;
    }

    @GetMapping("/all")
    public List<Reserva> obtenerTodasLasReservas() {
        return servicioReserva.obtenerTodasLasReservas();
    }

    @GetMapping("/{id}")
    public Reserva obtenerReservaPorId(@PathVariable int id) {
        return servicioReserva.obtenerReservaPorId(id);
    }

    @PostMapping("/crear")
    public Reserva crearReserva(@RequestBody Reserva reserva) {
        return servicioReserva.guardarReserva(reserva);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<String> actualizarReserva(@PathVariable int id, @RequestBody Reserva reserva) {
        boolean flag = servicioReserva.actualizarReserva(id, reserva);
        if (flag){
            return ResponseEntity.ok("Reserva actualizado exitosamente");
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarReserva(@PathVariable int id) {
        boolean flag = servicioReserva.eliminarReservaPorId(id);
        if (flag){
            return ResponseEntity.ok("Reserva eliminada exitosamente");
        } else {
            return ResponseEntity.noContent().build();
        }
    }
}
