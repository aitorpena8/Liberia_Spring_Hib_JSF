package app.modelo;

import java.util.HashSet;


import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;






public class Libro {

	private String titulo="";
	private Set<Autor> autores;
	private Editorial editorial;
	private String isbn="";
	private int publicacion;
	private double precio;
	private String descripcion;


	public Libro(String titulo, Editorial editorial, String isbn,
			int publicacion, double precio, String descripcion) {
		autores=new HashSet<Autor>();
		this.titulo = titulo;
		this.editorial = editorial;
		this.isbn = isbn;
		this.publicacion = publicacion;
		this.precio = precio;
		this.descripcion = descripcion;
	}
	public Libro(){
		autores=new HashSet<Autor>();
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public int getPublicacion() {
		return publicacion;
	}
	public void setPublicacion(int publicacion) {
		this.publicacion = publicacion;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void addAutor(Autor autor){
		autores.add(autor);
		autor.addLibro(this);

	}

	public Set<Autor> getAutores() {
		return autores;
	}
	public void setAutores(Set<Autor> autores) {
		this.autores = autores;
	}
	public Editorial getEditorial() {
		return editorial;
	}
	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}
	@Override
	public String toString() {
		String out= "\n"+this.getIsbn()+" - "+this.getTitulo();
		out+="\n**************************************** \n";
		int i=0;
		for(Autor autor:this.getAutores()){
			if(i==0)
				out+=autor+",";
			else
				out+=", "+autor;
			i++;
		}
		out+="\n**************************************** \n";
		out+=this.getEditorial();

		out+="\n**************************************** \n";
		out+=this.getPublicacion()+"|"+this.getPrecio()+" €";
		return out;
	}

}
