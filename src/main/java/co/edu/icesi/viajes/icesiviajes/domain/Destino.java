package co.edu.icesi.viajes.icesiviajes.domain;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "destino")
public class Destino {

    @Id
    @Column(name = "id_dest", nullable = false)
    private Long idDest;

    @Column(name = "codigo", nullable = false, length = 5)
    private String codigo;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "descripcion", nullable = false, length = 300)
    private String descripcion;

    @Column(name = "tierra", nullable = false, length = 1)
    private String tierra;

    @Column(name = "aire", nullable = false, length = 1)
    private String aire;

    @Column(name = "mar", nullable = false, length = 1)
    private String mar;

    @Column(name = "fecha_creacion", nullable = false)
    private Date fechaCreacion;

    @Column(name = "fecha_modificacion")
    private Date fechaModificacion;

    @Column(name = "usu_creador", nullable = false, length = 10)
    private String usuCreador;

    @Column(name = "usu_modificador", length = 10)
    private String usuModificador;

    @Column(name = "estado", nullable = false, length = 1)
    private String estado;

    @Column(name = "id_tide", nullable = false)
    private int idTide;

    public Long getIdDest() {
        return idDest;
    }

    public void setIdDest(Long idDest) {
        this.idDest = idDest;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTierra() {
        return tierra;
    }

    public void setTierra(String tierra) {
        this.tierra = tierra;
    }

    public String getAire() {
        return aire;
    }

    public void setAire(String aire) {
        this.aire = aire;
    }

    public String getMar() {
        return mar;
    }

    public void setMar(String mar) {
        this.mar = mar;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public String getUsuCreador() {
        return usuCreador;
    }

    public void setUsuCreador(String usuCreador) {
        this.usuCreador = usuCreador;
    }

    public String getUsuModificador() {
        return usuModificador;
    }

    public void setUsuModificador(String usuModificador) {
        this.usuModificador = usuModificador;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdTide() {
        return idTide;
    }

    public void setIdTide(int idTide) {
        this.idTide = idTide;
    }
}

