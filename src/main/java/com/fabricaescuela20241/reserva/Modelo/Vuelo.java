package com.fabricaescuela20241.reserva.Modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

@Table(name = "Vuelo")
public class Vuelo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "secuencia_vuelo")
    @GenericGenerator(name = "secuencia_vuelo", strategy = "increment")
    
    @Column(name="ID_vuelo")
    private int idVuelo;

    @Column(name="tipo_vuelo")
    private String tipoVuelo;

    @Column(name="origen")
    private String origen;

    @Column(name="destino")
    private String destino;

    @Column(name="fecha_salida")
    private LocalDate fechasalida;

    @Column(name="fecha_llegada")
    private LocalDate fechaLLegada;

    @Column(name="hora_salida")
    private LocalTime horasalida;

    @Column(name="hora_llegada")
    private LocalTime horaLLegada;
    
    @Column(name="cantidad_pasajeros")
    private int CanMaxPasajeros;

    @Column(name = "tipo_aeronave")
    private String aeronave;

    @Column(name = "precio")
    private Float precio;

    @Column(name = "impuesto")
    private Float impuesto;

    @Column(name = "sobretasa")
    private Float sobre_tasa;

}
