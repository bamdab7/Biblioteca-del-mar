package edu.nerea.proyecto.bilbioteca.entity;

public class Libro {

	private Integer idLibro;
	private String titulo;
	private String tipo; //enumerado LIBRO, REVOSTA, ENCICLOPEDIA,CD
	private String saga;
	private Integer idEditorial;
	private Integer paginas;
	private String descripcion;
	private String palabrasClave;
	
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

	public Integer getIdEditorial() {
		return idEditorial;
	}

	public void setIdEditorial(Integer idEditorial) {
		this.idEditorial = idEditorial;
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

	public String getPalabrasClave() {
		return palabrasClave;
	}

	public void setPalabrasClave(String palabrasClave) {
		this.palabrasClave = palabrasClave;
	}

	@Override
	public String toString() {
		return "Libro [idLibro=" + idLibro + ", titulo=" + titulo + ", tipo=" + tipo + ", saga=" + saga
				+ ", idEditorial=" + idEditorial + ", paginas=" + paginas + ", descripcion=" + descripcion
				+ ", palabrasClave=" + palabrasClave + "]";
	}
	
	
	
}
