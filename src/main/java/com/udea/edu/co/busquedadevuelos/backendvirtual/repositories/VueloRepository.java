package com.udea.edu.co.busquedadevuelos.backendvirtual.repositories;


import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.udea.edu.co.busquedadevuelos.backendvirtual.entities.Vuelo;

@Repository
public interface VueloRepository extends JpaRepository<Vuelo, String> {

    @Query("SELECT v FROM Vuelo v " +
       "WHERE v.fechaSalida > CURRENT_DATE")
    List<Vuelo> getAllflights();
    @Query("SELECT v FROM Vuelo v " +
       "WHERE v.idAeropuertoOrigen = ?1 " +
       "AND v.idAeropuertoDestino = ?2 " +
       "AND v.fechaSalida = ?3")
    List<Vuelo> findVuelosIda(String codigoAeropuertoOrigen, String codigoAeropuertoDestino, Date fechaSalida);

    @Query("SELECT v FROM Vuelo v " +
       "WHERE v.idAeropuertoOrigen = ?1 " +
       "AND v.idAeropuertoDestino = ?2 " +
       "AND v.fechaSalida = ?3")
    List<Vuelo> findVuelosIdaVuelta(String codigoAeropuertoOrigen, String codigoAeropuertoDestino, Date fechaSalida, Date fechaLlegada);

}
