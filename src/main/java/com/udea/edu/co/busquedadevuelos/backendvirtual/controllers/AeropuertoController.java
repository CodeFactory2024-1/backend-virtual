package com.udea.edu.co.busquedadevuelos.backendvirtual.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udea.edu.co.busquedadevuelos.backendvirtual.entities.Aeropuerto;
import com.udea.edu.co.busquedadevuelos.backendvirtual.services.AeropuertoService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("api/aeropuertos")
public class AeropuertoController {
    

    private final AeropuertoService aeropuertoService;

    
    public AeropuertoController(AeropuertoService aeropuertoService) {
        this.aeropuertoService = aeropuertoService;
    }


    @GetMapping("listar")
    public ResponseEntity<List<Object>> getAirports() {
        try {
            List<Object> aeropuertos = aeropuertoService.listAeropuertos();
            return ResponseEntity.ok(aeropuertos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    
    @GetMapping("listarPorNombre")
    public ResponseEntity<List<Object>> getMethodName(@RequestParam String nombre) {
        try {
            List<Object> aeropuertos = aeropuertoService.findAeropuerto(nombre);
            return ResponseEntity.ok(aeropuertos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    
    
}
