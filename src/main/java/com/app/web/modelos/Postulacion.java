package com.app.web.modelos;

import javax.persistence.*;

@Entity
@Table(name = "Postulacion")
public class Postulacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long IdPostulacion;
    @OneToOne
    @JoinColumn(name = "Idusuario")
    private Usuario usuario;
    @OneToOne(mappedBy = "postulacion", cascade = CascadeType.ALL)
    private Cita cita;
    @OneToOne
    @JoinColumn(name = "IdVacante")
    private Vacante vacante;

    public Postulacion() {
    }

    public Postulacion(long idPostulacion, Usuario usuario, Cita cita, Vacante vacante) {
        IdPostulacion = idPostulacion;
        this.usuario = usuario;
        this.cita = cita;
        this.vacante = vacante;
    }

    public long getIdPostulacion() {
        return IdPostulacion;
    }

    public void setIdPostulacion(long idPostulacion) {
        IdPostulacion = idPostulacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Cita getCita() {
        return cita;
    }

    public void setCita(Cita cita) {
        this.cita = cita;
    }

    public Vacante getVacante() {
        return vacante;
    }

    public void setVacante(Vacante vacante) {
        this.vacante = vacante;
    }

    @Override
    public String toString() {
        return "Postulacion{" +
                "IdPostulacion=" + IdPostulacion +
                ", usuario=" + usuario +
                ", cita=" + cita +
                ", vacante=" + vacante +
                '}';
    }
}
