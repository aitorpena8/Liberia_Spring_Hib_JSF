package app.negocio;

import java.util.List;

import app.modelo.Autor;
import app.modelo.Editorial;
import app.modelo.Libro;
import app.modelo.LibroNoEncontradoException;

public interface ItfzGestionLibreria {

	/**
	 * Inserta un libro
	 * 
	 * @param libro el libro a insertar
	 * @return boolean indica si la operacion se ha realizado o no correctamente
	 * 
	 */
	public boolean altaLibro(Libro libro);
	/**
	 * Eliminar un libro
	 * 
	 * @param ISBN el ISBN del libro a eliminar
	 * @return boolean true/false indica si la operacion se ha realizado o no correctamente
	 */
	public boolean eliminarLibro(String ISBN);
	/**
	 * Obtiene una lista de todos los libro
	 * 
	 * @return  La lista de libros
	 * 
	 */
	public List<Libro> consultarTodosLibro();
	/**
	 * 
	 * Obtiene el libro especificado por su ISBN
	 * 
	 * @param ISBN el identificador del libro a obtener
	 * @return el libro recuperado o null si no se ha encontrado

	 */
	public Libro consultarISBNLibro(String ISBN);
	/**
	 * Obtener libro(s) por su titulo o parte de el. Si hay más de una coincidencia devolvera una lista de aquellos que cumplen la condicion
	 * 
	 * @param titulo cadena de texto que contenga un titulo de libro o una parte de el
	 * @return lista de uno o mas libros que cuyo(s) titulos contengan el texto proprocinado o null si no se a encontrado

	 */
	public List<Libro> consultarTituloLibro(String titulo);
	/**
	 * Modificar el precio de un libro proporcionnado el ISBN y el nuevo precio del libro
	 * 
	 * @param isbn identificador del libro a modificar
	 * @param precio nuevo precio 
	 * @return boolean true/false indica si la operacion se ha realizado o no correctamente
	 */
	public boolean modificarPrecio(String isbn,double precio);


	public boolean eliminarAutor(long id);


	public boolean altaAutor(Autor autor);

	public boolean eliminarEditorial(String nif);

	public boolean altaEditorial(Editorial editorial);

	public List<Autor> consultarTodosAutores();
	public List<Autor> consultarNomAutor(String nom);
	public List<Autor> consultarNacAutor(String nac);

	public List<Editorial> consultarTodasEditoriales();
	public Editorial consultarNifEditorial(String nif);
	public List<Editorial> consultarNomEditorial(String nom);

	public List<String> consultarAutorNacionalidades();



}
