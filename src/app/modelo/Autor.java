package app.modelo;

import java.util.HashSet;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

public class Autor {
	private long id;
	public Set<Libro> getLibros() {
		return libros;
	}
	public void setLibros(Set<Libro> libros) {
		this.libros = libros;
	}
	private String nombre="";
	private String nacionalidad="";
	private String  comentarios;
	private Set<Libro> libros;

	public Autor(){
		libros=new HashSet<Libro>();	
	}
	public Autor(String nombre, String nacionalidad, String comentarios) {
		libros=new HashSet<Libro>();
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
		this.comentarios = comentarios;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public void addLibro(Libro libro){
		libros.add(libro);

	}
	@Override
	public String toString() {
		return nombre+", "+nacionalidad+"\n----------------------------------------\n"+comentarios;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

}
