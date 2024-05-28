package com.fabricaescuela20241.reserva.Servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabricaescuela20241.reserva.Modelo.Reserva;
import com.fabricaescuela20241.reserva.Repositorio.RepositorioReserva;

@Service
public class ServicioReserva {

    @Autowired
    private RepositorioReserva repositorioReserva;

    public Reserva guardarReserva(Reserva reserva) {
        return repositorioReserva.save(reserva);

    }

    public List<Reserva> obtenerTodasLasReservas() {
        return repositorioReserva.findAll();
    }

    public Reserva obtenerReservaPorId(int id) {
        return repositorioReserva.findById(id).orElse(null);
    }

    public boolean eliminarReservaPorId(int id) {
        if(!repositorioReserva.existsById(id)){
            return false;
        }
        repositorioReserva.deleteById(id);
        return true;
    }

    public boolean actualizarReserva(int id, Reserva reserva){
        Optional<Reserva> optionalReserva = repositorioReserva.findById(id);
        if(!optionalReserva.isPresent()){
            return false;
        }

        Reserva reservaExiste = optionalReserva.get();

        if (reserva.getIdReserva() != id){
            return false;
        }

        if(reserva.getFechaReserva() != null){
            reservaExiste.setFechaReserva(reserva.getFechaReserva());
        }

        if (reserva.getEstado() != null){
            reservaExiste.setEstado(reserva.getEstado());
        }

        if (reserva.getVuelo() != null){
            reservaExiste.setVuelo(reserva.getVuelo());
        }

        if (reserva.getPrecio() != null){
            reservaExiste.setPrecio(reserva.getPrecio());
        }

        repositorioReserva.save(reservaExiste);
        return true;

    }

}
