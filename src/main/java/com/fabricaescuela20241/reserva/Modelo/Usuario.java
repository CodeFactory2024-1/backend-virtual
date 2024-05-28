package com.fabricaescuela20241.reserva.Modelo;

import com.fabricaescuela20241.reserva.utils.TipoDocumento;
import com.fabricaescuela20241.reserva.utils.TipoUsuario;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

@Table(name = "Pasajero")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "secuenciaUsuario")
    @GenericGenerator(name = "secuenciaUsuario", strategy = "increment")
    @Column(name = "ID_pasajero")
    private int idPasajero;

    @ManyToOne
    @JoinColumn(name = "ID_reserva", referencedColumnName = "Id_reserva")
    private Reserva reserva;

    @Column(name = "nombre", length = 250)
    private String nombres;

    @Column(name = "apellido", length = 250)
    private String apellidos;

    @Column(name = "num_documento", unique = true, nullable = false)
    private String numeroDocumento;

    @Column(name = "tipo_documento", nullable = false)
    private TipoDocumento tipoDocumento;

    @Column(name = "telefono", unique = true, nullable = false)
    private String telefono;

    @Column(name = "correo", unique = true, nullable = false)
    private String correo;

    @Column(name = "precio")
    private Float precio = 0F;

    @Column(name = "tipo", nullable = false)
    private TipoUsuario tipo;

}