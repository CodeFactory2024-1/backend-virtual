package com.fabricaescuela20241.reserva.Modelo;

import java.time.LocalDate;

import com.fabricaescuela20241.reserva.utils.TipoEstadoReserva;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

@Table(name = "Reserva")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "secuencia_reserva")
    @GenericGenerator(name = "secuencia_reserva", strategy = "increment")
    @Column(name = "Id_reserva")
    private int idReserva;

    @ManyToOne
    @JoinColumn(name = "Id_vuelo", referencedColumnName="ID_vuelo")
    private Vuelo vuelo;

    @Column(name = "fecha_reserva")
    private LocalDate fechaReserva;

    @Column(name = "estado")
    private TipoEstadoReserva estado;

    @Column(name = "precio_total")
    private Float precio = 0F;
}