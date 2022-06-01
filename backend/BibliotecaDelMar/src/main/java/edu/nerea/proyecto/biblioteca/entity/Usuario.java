package edu.nerea.proyecto.biblioteca.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuario {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String email;
	private String username;
	private String password;
	private Integer status;
	
	public Usuario(){
		super();
	}

	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id= id;
	}
	public String getNombre(){
		return nombre;
	}
	public void setNombre(String nombre){
		this.nombre=nombre;
	}
	public String setEmail(){
		return email;
	}
	public void getEmail(String email){
		this.email=email;
	}
	public String setUsername(){
		return username;
	}
	public void getUsername(String username){
		this.username=username;
	}
	public String setPassword(){
		return password;
	}
	public void getPassword(String password){
		this.password=password;
	}
	public Integer setStatus(){
		return status;
	}
	public void getStatus(Integer status){
		this.status=status;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", email=" + email + ", username=" + username + ", password="
		+ password + ", status=" + status +  "]";
	}


	
	
}
