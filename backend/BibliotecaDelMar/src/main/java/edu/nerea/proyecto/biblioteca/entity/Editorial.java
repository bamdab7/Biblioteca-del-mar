package edu.nerea.proyecto.biblioteca.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="editorial")
public class Editorial {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idEditorial;
	private String nombre;
	private Integer fundacion;
	private String direcionSede;
	private String url;
	public Integer getIdEditorial() {
		return idEditorial;
	}
	public void setIdEditorial(Integer idEditorial) {
		this.idEditorial = idEditorial;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getFundacion() {
		return fundacion;
	}
	public void setFundacion(Integer fundacion) {
		this.fundacion = fundacion;
	}
	public String getDirecionSede() {
		return direcionSede;
	}
	public void setDirecionSede(String direcionSede) {
		this.direcionSede = direcionSede;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	@Override
	public String toString() {
		return "Editorial [idEditorial=" + idEditorial + ", nombre=" + nombre + ", fundacion=" + fundacion
				+ ", direcionSede=" + direcionSede + ", url=" + url + "]";
	}
	

}
