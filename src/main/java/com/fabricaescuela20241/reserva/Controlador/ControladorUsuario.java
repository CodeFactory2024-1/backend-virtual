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

import com.fabricaescuela20241.reserva.Modelo.Usuario;
import com.fabricaescuela20241.reserva.Servicio.ServicioUsuario;

@RestController
@RequestMapping("/usuario")
public class ControladorUsuario {

    @Autowired
    private final ServicioUsuario servicioUsuario;

    public ControladorUsuario(ServicioUsuario servicioUsuario) {
        this.servicioUsuario = servicioUsuario;
    }

    @GetMapping("/all")
    public List<Usuario> obtenerTodosLosUsuarios() {
        return servicioUsuario.obtenerTodosLosUsuarios();
    }

    @GetMapping("/{id}")
    public Usuario obtenerUsuarioPorId(@PathVariable int id) {
        return servicioUsuario.obtenerUsuarioPorId(id);
    }

    @PostMapping("/agregar")
    public ResponseEntity<String> crearUsuario(@RequestBody Usuario user) {
        return servicioUsuario.guardarUsuario(user);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<String> actualizarUsuario(@PathVariable int id, @RequestBody Usuario user) {
        boolean flag = servicioUsuario.actualizarUsuario(id, user);
        if (flag){
            return ResponseEntity.ok("Usuario actualizado exitosamente");
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<String> eliminarUsuario(@PathVariable int id) {
        boolean flag = servicioUsuario.eliminarUsuarioPorId(id);
        if (flag){
            return ResponseEntity.ok("Usuario eliminado exitosamente");
        } else {
            return ResponseEntity.noContent().build();
        }
    }

}