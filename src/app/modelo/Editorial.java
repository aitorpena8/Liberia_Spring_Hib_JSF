package app.modelo;

import java.util.HashSet;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

public class Editorial {
	private String nombre="";
	private Direccion direccion;
	private String nif="";
	private Set<Libro> libros;
	public Editorial(){
		libros=new HashSet<Libro>();
	}

	public Editorial(String nombre, Direccion direccion, String nif) {
		libros=new HashSet<Libro>();
		this.nombre = nombre;
		this.direccion = direccion;
		this.nif = nif;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	public String getNif() {
		return nif;
	}
	public void setNif(String nif) {
		this.nif = nif;
	}
	public void addLibro(Libro l){
		libros.add(l);
		l.setEditorial(this);
	}


	public Set<Libro> getLibros() {
		return libros;
	}

	public void setLibros(Set<Libro> libros) {
		this.libros = libros;
	}

	@Override
	public String toString() {
		return nif+"-"+nombre+"\n----------------------------------------\n"+direccion;
	}



}
