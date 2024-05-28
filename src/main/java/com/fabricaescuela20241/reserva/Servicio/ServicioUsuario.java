package com.fabricaescuela20241.reserva.Servicio;

import java.util.List;
import java.util.Optional;
import com.fabricaescuela20241.reserva.Modelo.Reserva;
import com.fabricaescuela20241.reserva.Modelo.Vuelo;
import com.fabricaescuela20241.reserva.Repositorio.RepositorioReserva;
import com.fabricaescuela20241.reserva.Repositorio.RepositorioVuelo;
import com.fabricaescuela20241.reserva.utils.TipoUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fabricaescuela20241.reserva.Modelo.Usuario;
import com.fabricaescuela20241.reserva.Repositorio.RepositorioUsuario;

@Service
public class ServicioUsuario {

    @Autowired
    private RepositorioUsuario repositorioUsuario;
    private RepositorioReserva repositorioReserva;
    private RepositorioVuelo repositorioVuelo;

    public ServicioUsuario(RepositorioUsuario repositorioUsuario, RepositorioReserva repositorioReserva, RepositorioVuelo repositorioVuelo){
        this.repositorioUsuario = repositorioUsuario;
        this.repositorioReserva = repositorioReserva;
        this.repositorioVuelo = repositorioVuelo;
    }

    public ResponseEntity<String> guardarUsuario(Usuario usuario) {

        repositorioUsuario.save(usuario);
        calcularPrecio(usuario.getIdPasajero(), usuario.getReserva().getIdReserva(), true);

        return ResponseEntity.ok("Usuario agregado");
    }

    private void calcularPrecio(int idUsuario, int idReserva, boolean mode){

        Usuario usuario = repositorioUsuario.getReferenceById(idUsuario);
        Reserva reserva = repositorioReserva.getReferenceById(idReserva);
        Vuelo vuelo = repositorioVuelo.getReferenceById(reserva.getVuelo().getIdVuelo());

        if (usuario.getTipo() == TipoUsuario.NIÑO){
            usuario.setPrecio(reserva.getVuelo().getPrecio() * 0.6F);

        }else {
            usuario.setPrecio(reserva.getVuelo().getPrecio());
        }

        if (!mode){
            reserva.setPrecio(reserva.getPrecio() - usuario.getPrecio());
            vuelo.setCanMaxPasajeros(vuelo.getCanMaxPasajeros() + 1);
        } else {
            reserva.setPrecio(reserva.getPrecio() + usuario.getPrecio());
            vuelo.setCanMaxPasajeros(vuelo.getCanMaxPasajeros() - 1);
        }

        if(reserva.getPrecio() < 0.01){
            reserva.setPrecio(0.0F);
        }

        repositorioUsuario.save(usuario);
        repositorioReserva.save(reserva);
        repositorioVuelo.save(vuelo);
    }

    public List<Usuario> obtenerTodosLosUsuarios() {
        return repositorioUsuario.findAll();
    }

    public Usuario obtenerUsuarioPorId(int id) {
        return repositorioUsuario.findById(id).orElse(null);
    }

    public boolean eliminarUsuarioPorId(int id) {
        if (!repositorioUsuario.existsById(id)){
            return false;
        }
        calcularPrecio(id, repositorioUsuario.getReferenceById(id).getReserva().getIdReserva(), false);

        repositorioUsuario.deleteById(id);
        return true;
    }

    public boolean actualizarUsuario(int id, Usuario usuario ){
        Optional<Usuario> optionalUsuario = repositorioUsuario.findById(id);
        if(optionalUsuario.isEmpty() && usuario.getPrecio() != null){
            return false;
        }

        Usuario usuarioExiste = optionalUsuario.get();

        if(usuario.getIdPasajero() != id){
            return false;
        }

        if (usuario.getNombres() != null){
            usuarioExiste.setNombres(usuario.getNombres());
        }

        if (usuario.getApellidos() != null){
            usuarioExiste.setApellidos(usuario.getApellidos());
        }

        if (usuario.getNumeroDocumento() != null){
            usuarioExiste.setNumeroDocumento(usuario.getNumeroDocumento());
        }

        if (usuario.getTelefono() != null){
            usuarioExiste.setTelefono(usuario.getTelefono());
        }

        if (usuario.getCorreo() != null){
            usuarioExiste.setCorreo(usuario.getCorreo());
        }

        if (usuario.getReserva() != null){
            usuarioExiste.setReserva(usuario.getReserva());
        }

        if (usuario.getNumeroDocumento() != null){
            usuarioExiste.setNumeroDocumento(usuario.getNumeroDocumento());
        }

        if (usuario.getTipoDocumento() != null){
            usuarioExiste.setTipoDocumento(usuario.getTipoDocumento());
        }

        repositorioUsuario.save(usuarioExiste);
        return true;
    }
}