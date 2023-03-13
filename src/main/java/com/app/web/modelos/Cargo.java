package com.app.web.modelos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Cargo")
public class Cargo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IdCargo;
	@Column(name = "nombeCargo", nullable = false, length = 20)
	private String nombeCargo;

	@OneToMany(mappedBy = "cargo", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Usuario> tareas = new ArrayList<>();

	public Cargo() {
		super();
	}

	public Cargo(Long idCargo, String nombeCargo, List<Usuario> tareas) {
		super();
		IdCargo = idCargo;
		this.nombeCargo = nombeCargo;
		this.tareas = tareas;
	}

	public Long getIdCargo() {
		return IdCargo;
	}

	public void setIdCargo(Long idCargo) {
		IdCargo = idCargo;
	}

	public String getNombeCargo() {
		return nombeCargo;
	}

	public void setNombeCargo(String nombeCargo) {
		this.nombeCargo = nombeCargo;
	}

	public List<Usuario> getTareas() {
		return tareas;
	}

	public void setTareas(List<Usuario> tareas) {
		this.tareas = tareas;
	}

	@Override
	public String toString() {
		return "Cargo [IdCargo=" + IdCargo + ", nombeCargo=" + nombeCargo + ", tareas=" + tareas + "]";
	}

}
