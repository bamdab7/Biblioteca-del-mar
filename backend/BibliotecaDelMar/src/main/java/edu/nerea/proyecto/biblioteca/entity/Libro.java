package edu.nerea.proyecto.biblioteca.entity;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="libro")
public class Libro {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer idLibro;
	private String titulo;
	private String tipo; //enumerado LIBRO, REVISTA, ENCICLOPEDIA,CD
	private String saga;
	@OneToOne //relacion N-1 con tabla editorial
	@JoinColumn(name="idEditorial",referencedColumnName="idEditorial")
	private Editorial editorial;
	private Integer paginas;
	private String descripcion;
	private String imagen;
	@OneToOne
	@JoinColumn(name="idAutor", referencedColumnName="idAutor")
	private Autor autor;
	
	
	public Libro() {
		super();
	}
	
	
	public Integer getIdLibro() {
		return idLibro;
	}

	public void setIdLibro(Integer idLibro) {
		this.idLibro = idLibro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getSaga() {
		return saga;
	}

	public void setSaga(String saga) {
		this.saga = saga;
	}

	public Integer getPaginas() {
		return paginas;
	}

	public void setPaginas(Integer paginas) {
		this.paginas = paginas;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public Editorial getEditorial() {
		return editorial;
	}

	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}
	
	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}


	@Override
	public String toString() {
		return "Libro [idLibro=" + idLibro + ", titulo=" + titulo + ", tipo=" + tipo + ", saga=" + saga + ", editorial="
				+ editorial + ", paginas=" + paginas + ", descripcion=" + descripcion + ", imagen=" + imagen + "]";
	}

	
	
	
}
