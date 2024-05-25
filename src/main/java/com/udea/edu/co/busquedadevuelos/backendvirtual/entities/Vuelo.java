package com.udea.edu.co.busquedadevuelos.backendvirtual.entities;


import java.sql.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "vuelos")
public class Vuelo {
    
    @Id
    @Column(name = "id_vuelo", nullable = false)
    private String id;

    @Column(name = "tipo_vuelo", nullable = false)
    private String tipoVuelo;

    @Column(name = "codigo_aeropuerto_origen", nullable = false)
    private String idAeropuertoOrigen;

    @Column(name = "codigo_aeropuerto_destino", nullable = false)
    private String idAeropuertoDestino;

    @Column(name = "id_tipo_aeronave", nullable = false)
    private Long idTipoAvion;

    @Column(name = "fecha_salida", nullable = false)
    private Date fechaSalida;

    @Column(name = "fecha_llegada", nullable = false)
    private Date fechaLlegada;

    @Column(name = "hora_salida", nullable = false)
    private String horaSalida;

    @Column(name = "hora_llegada", nullable = false)
    private String horaLlegada;

    @Column(name = "precio", nullable = false)
    private Double precio;

    @Column(name = "cantidad_max_pasajeros", nullable = false)
    private Integer cantidadPasajeros;

    @Column(name = "sobretasa", nullable = false)
    private Double sobretasa;

    @Column(name = "porcentaje_impuestos", nullable = false, updatable = false)
    private Double porcentajeImpuestos;

    @ManyToOne
    @JoinColumn(name = "codigo_aeropuerto_origen", insertable = false, updatable = false)
    private Aeropuerto origen;

    @ManyToOne
    @JoinColumn(name = "codigo_aeropuerto_destino", insertable = false, updatable = false)
    private Aeropuerto destino;

    @ManyToOne
    @JoinColumn(name = "id_tipo_aeronave", insertable = false, updatable = false)
    private TipoAeronave tipoAeronave;

    
    // Getters y Setters

    public Vuelo(String id, String tipoVuelo, String idAeropuertoOrigen, String idAeropuertoDestino, Long idTipoAvion,
            Date fechaSalida, Date fechaLlegada, String horaSalida, String horaLlegada, Double precio,
            Integer cantidadPasajeros, Double sobretasa, Double porcentajeImpuestos) {
        this.id = id;
        this.tipoVuelo = tipoVuelo;
        this.idAeropuertoOrigen = idAeropuertoOrigen;
        this.idAeropuertoDestino = idAeropuertoDestino;
        this.idTipoAvion = idTipoAvion;
        this.fechaSalida = fechaSalida;
        this.fechaLlegada = fechaLlegada;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
        this.precio = precio;
        this.cantidadPasajeros = cantidadPasajeros;
        this.sobretasa = sobretasa;
        this.porcentajeImpuestos = porcentajeImpuestos;
    }

    public Vuelo() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipoVuelo() {
        return tipoVuelo;
    }

    public void setTipoVuelo(String tipoVuelo) {
        this.tipoVuelo = tipoVuelo;
    }

    public String getIdAeropuertoDestino() {
        return idAeropuertoDestino;
    }

    public void setIdAeropuertoDestino(String idAeropuertoDestino) {
        this.idAeropuertoDestino = idAeropuertoDestino;
    }

    public String getIdAeropuertoOrigen() {
        return idAeropuertoOrigen;
    }

    public void setIdAeropuertoOrigen(String idAeropuertoOrigen) {
        this.idAeropuertoOrigen = idAeropuertoOrigen;
    }

    public Long getIdTipoAvion() {
        return idTipoAvion;
    }

    public void setIdTipoAvion(Long idTipoAvion) {
        this.idTipoAvion = idTipoAvion;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Date getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(Date fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(String horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getCantidadPasajeros() {
        return cantidadPasajeros;
    }

    public void setCantidadPasajeros(Integer cantidadPasajeros) {
        this.cantidadPasajeros = cantidadPasajeros;
    }

    public Double getSobretasa() {
        return sobretasa;
    }

    public void setSobretasa(Double sobretasa) {
        this.sobretasa = sobretasa;
    }

    public Double getPorcentajeImpuestos() {
        return porcentajeImpuestos;
    }

    public void setPorcentajeImpuestos(Double porcentajeImpuestos) {
        this.porcentajeImpuestos = porcentajeImpuestos;
    }

    public Aeropuerto getOrigen() {
        return origen;
    }

    public void setOrigen(Aeropuerto origen) {
        this.origen = origen;
    }

    public Aeropuerto getDestino() {
        return destino;
    }

    public void setDestino(Aeropuerto destino) {
        this.destino = destino;
    }

    public TipoAeronave getTipoAeronave() {
        return tipoAeronave;
    }

    public void setTipoAeronave(TipoAeronave tipoAeronave) {
        this.tipoAeronave = tipoAeronave;
    }

}