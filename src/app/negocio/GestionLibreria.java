package app.negocio;

import java.util.List;










import javax.annotation.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.RequestScoped;

import org.springframework.context.annotation.Scope;

import app.modelo.Autor;
import app.modelo.Editorial;
import app.modelo.Libro;
import app.modelo.LibroNoEncontradoException;
import app.persistencia.ItfzLibrosDao;
@ManagedBean
@ApplicationScoped
public class GestionLibreria implements ItfzGestionLibreria {


	private ItfzLibrosDao librosDAO;

	public ItfzLibrosDao getLibrosDAO() {
		return librosDAO;
	}

	public void setLibrosDAO(ItfzLibrosDao librosDAO) {
		this.librosDAO = librosDAO;
	}




	public boolean altaLibro(Libro libro) {
		return librosDAO.altaLibro(libro);

	}


	public boolean eliminarLibro(String ISBN) {
		return librosDAO.eliminarLibro(ISBN);
	}


	public List<Libro> consultarTodosLibro() {
		return librosDAO.consultarTodos();
	}


	public Libro consultarISBNLibro(String ISBN) {
		try {
			return librosDAO.consultarISBN(ISBN);
		} catch (LibroNoEncontradoException e) {
			System.err.println("consultarISBN():LibroNoEncontradoException "+e.getMessage());;
			return null;
		}
	}


	public List<Libro> consultarTituloLibro(String titulo) {
		try {
			return librosDAO.consultarTitulo(titulo);
		} catch (LibroNoEncontradoException e) {
			System.err.println("consultarTitulo():LibroNoEncontradoException "+e.getMessage());;
			return null;
		}
	}


	public boolean modificarPrecio(String isbn, double precio) {
		return librosDAO.modificarPrecio(isbn, precio);
	}

	@Override
	public boolean altaAutor(Autor autor) {
		return librosDAO.altaAutor(autor);
	}

	@Override
	public boolean altaEditorial(Editorial editorial) {
		return librosDAO.altaEditorial(editorial);
	}

	@Override
	public List<Autor> consultarTodosAutores() {
		return librosDAO.consultarTodosAutores();
	}
	@Override
	public List<Editorial> consultarTodasEditoriales() {
		return librosDAO.consultarTodasEditoriales();
	}

	@Override
	public boolean eliminarAutor(long id) {
		return librosDAO.eliminarAutor(id);
	}

	@Override
	public boolean eliminarEditorial(String nif) {
		return librosDAO.eliminarEditorial(nif);
	}

	@Override
	public List<Autor> consultarNomAutor(String nom) {
		return librosDAO.consultarNomAutor(nom);
	}

	@Override
	public List<Autor> consultarNacAutor(String nac) {
		return librosDAO.consultarNacAutor(nac);
	}

	@Override
	public Editorial consultarNifEditorial(String nif) {
		return librosDAO.consultarNifEditorial(nif);
	}

	@Override
	public List<Editorial> consultarNomEditorial(String nom) {
		return librosDAO.consultarNomEditorial(nom);
	}

	@Override
	public List<String> consultarAutorNacionalidades() {
		return librosDAO.consultarAutorNacionalidades();
	}

}
