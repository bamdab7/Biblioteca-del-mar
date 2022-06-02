package edu.nerea.proyecto.biblioteca.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="autor")
public class Autor {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idAutor;
	private String nombre;
	private String apellidos;
	private String status; //ACTIVO // NO ACTIVO
	private String imagen;
	public Integer getIdAutor() {
		return idAutor;
	}
	public void setIdAutor(Integer idAutor) {
		this.idAutor = idAutor;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	@Override
	public String toString() {
		return "Autor [idAutor=" + idAutor + ", nombre=" + nombre + ", apellidos=" + apellidos + ", status=" + status
				+ ", imagen=" + imagen + "]";
	}
	
	
	
}
