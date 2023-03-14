package com.app.web.modelos;

import javax.persistence.*;

@Entity
@Table(name = "Resultado")
public class Resultado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IdResultado;
	@Column(name = "Resultado_Examen", nullable = false, length = 50)
	private String Resultado_Examen;
	@Column(name = "Resultado_entrevista", nullable = false, length = 50)
	private String Resultado_entrevista;
	/* relacion con cita */
	@OneToOne
	@JoinColumn (name = "IdCita")
	private Cita cita;

	public Resultado() {
		super();
	}

	public Resultado(Long idResultado, String resultado_Examen, String resultado_entrevista, Cita cita) {
		super();
		IdResultado = idResultado;
		Resultado_Examen = resultado_Examen;
		Resultado_entrevista = resultado_entrevista;
		this.cita = cita;
	}

	public Long getIdResultado() {
		return IdResultado;
	}

	public void setIdResultado(Long idResultado) {
		IdResultado = idResultado;
	}

	public String getResultado_Examen() {
		return Resultado_Examen;
	}

	public void setResultado_Examen(String resultado_Examen) {
		Resultado_Examen = resultado_Examen;
	}

	public String getResultado_entrevista() {
		return Resultado_entrevista;
	}

	public void setResultado_entrevista(String resultado_entrevista) {
		Resultado_entrevista = resultado_entrevista;
	}

	public Cita getCita() {
		return cita;
	}

	public void setCita(Cita cita) {
		this.cita = cita;
	}

	@Override
	public String toString() {
		return "Resultado [IdResultado=" + IdResultado + ", Resultado_Examen=" + Resultado_Examen
				+ ", Resultado_entrevista=" + Resultado_entrevista + ", cita=" + cita + "]";
	}

}
