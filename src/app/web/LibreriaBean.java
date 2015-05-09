package app.web;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

import app.modelo.Autor;
import app.modelo.Direccion;
import app.modelo.Editorial;
import app.modelo.Libro;
import app.negocio.ItfzGestionLibreria;

@ManagedBean
@RequestScoped
public class LibreriaBean {

	private Libro libro;
	private Autor autor;
	private Editorial editorial;
	private List<Libro> listaLibros;
	private List<Autor> listaAutores;
	private List<Editorial> listaEditoriales;




	private ItfzGestionLibreria gestionLibreria;

	public void inicializa(){
		
		System.out.println("LibreriaBean:inicializa()");
		libro=new Libro();
		autor=new Autor();
		Direccion dir=new Direccion();
		editorial=new Editorial();
		editorial.setDireccion(dir);
		listaLibros=new ArrayList<Libro>();
		listaAutores=new ArrayList<Autor>();
		listaEditoriales=new ArrayList<Editorial>();
		
	}



	public List<SelectItem> getAutores(){
		List<SelectItem> lista = new ArrayList<SelectItem>();
		List<Autor> listAutor=gestionLibreria.consultarTodosAutores();
		lista.add(new SelectItem(null,"-- Seleccione Autor"));
		for(Autor autor:listAutor){
			lista.add(new SelectItem(autor,autor.getNombre()));
		}
		return lista;
	}

	public List<SelectItem> getEditoriales(){
		List<SelectItem> lista = new ArrayList<SelectItem>();
		List<Editorial> listEditorial=gestionLibreria.consultarTodasEditoriales();
		lista.add(new SelectItem(null,"-- Seleccione Editorial"));
		for(Editorial editorial:listEditorial){
			lista.add(new SelectItem(editorial,editorial.getNombre()));
		}
		return lista;

	}


	public List<SelectItem> getNacionalidades(){
		List<String> listaNacionalidades=gestionLibreria.consultarAutorNacionalidades();
		List <SelectItem>lista=new ArrayList<SelectItem>();
		lista.add(new SelectItem(null,"-- "));
		for(String nac:listaNacionalidades){
			lista.add(new SelectItem(nac,nac));
		}
		return lista;

	}




	public Libro getLibro() {
		return libro;
	}



	public void setLibro(Libro libro) {
		this.libro = libro;
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



	public ItfzGestionLibreria getGestionLibreria() {
		return gestionLibreria;
	}



	public void setGestionLibreria(ItfzGestionLibreria gestionLibreria) {
		this.gestionLibreria = gestionLibreria;
	}

	public int getTamListaLibro(){
		int tam=0;
		if(listaLibros!=null)
			tam=listaLibros.size();
		return tam;
	}

	public int getTamListaAutor(){
		int tam=0;
		if(listaAutores!=null)
			tam=listaAutores.size();
		return tam;
	}

	public int getTamListaEditorial(){
		int tam=0;
		if(listaEditoriales!=null)
			tam=listaEditoriales.size();
		return tam;
	}

	public List<Libro> consultarLibro(){
		if(libro.getIsbn().equals("")){
			if(libro.getTitulo().equals(""))
				listaLibros=this.gestionLibreria.consultarTodosLibro();
			else
				listaLibros=this.gestionLibreria.consultarTituloLibro(libro.getTitulo());
		}
		else {
			listaLibros=new ArrayList<Libro>();
			Libro libro1= this.gestionLibreria.consultarISBNLibro(libro.getIsbn());
			listaLibros.add(libro1);

		}
		return listaLibros;

	}


	public List<Autor> consultarAutor(){
		if(autor.getNombre().equals("")){
			if(autor.getNacionalidad().equals(""))
				listaAutores=this.gestionLibreria.consultarTodosAutores();
			else
				listaAutores=this.gestionLibreria.consultarNacAutor(autor.getNacionalidad());
		}
		else {
			listaAutores= this.gestionLibreria.consultarNomAutor(autor.getNombre());

		}
		return listaAutores;
	}



	public List<Editorial> consultarEditoriales(){
		if(editorial.getNif().equals("")){
			if(editorial.getNombre().equals(""))
				listaEditoriales=this.gestionLibreria.consultarTodasEditoriales();
			else{
				listaEditoriales=this.gestionLibreria.consultarNomEditorial(editorial.getNombre());
			}
		}
		else {
			listaEditoriales=new ArrayList<Editorial>();
			Editorial edi=this.gestionLibreria.consultarNifEditorial(editorial.getNif());
			listaEditoriales.add(edi);


		}
		return listaEditoriales;
	}



	public void modificarPrecio(String isbn,double precio){
		System.out.println("precio"+precio);
		gestionLibreria.modificarPrecio(isbn, precio);


	}

	public String altaLibro(){
		libro.addAutor(autor);
		libro.setEditorial(editorial);
		if(gestionLibreria.altaLibro(libro))
			return "confirmacion";
		else
			return "error";
	}

	public String altaAutor(){
		System.out.println(autor);
		if(gestionLibreria.altaAutor(autor))
			return "confirmacion";
		else
			return "error";
	}

	public String altaEditorial(){
		if(gestionLibreria.altaEditorial(editorial))
			return "confirmacion";
		else
			return "error";
	}



	public void eliminarLibro(String isbn){

		System.out.println("Eliminar Libro: "+isbn);
		gestionLibreria.eliminarLibro(isbn);

	}

	public void eliminarAutor(long id){

		System.out.println("Eliminar Autor: "+id);
		gestionLibreria.eliminarAutor(id);

	}

	public void eliminarEditorial(String nif){

		System.out.println("Eliminar Editorial: "+nif);
		gestionLibreria.eliminarEditorial(nif);

	}




}
