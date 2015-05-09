package app.persistencia;

import java.util.List;

import app.modelo.Autor;
import app.modelo.Editorial;
import app.modelo.Libro;
import app.modelo.LibroNoEncontradoException;

/**
 * @author aitorpena
 *
 */
/**
 * @author aitorpena
 *
 */
public interface ItfzLibrosDao {
	/**
	 * Inserta un libro en la BBDD 
	 * 
	 * @param libro el libro a insertar
	 * @return boolean indica si la operacion se ha realizado o no correctamente
	 * 
	 */

	public boolean altaLibro(Libro libro);
	/**
	 * Eliminar un libro de la BBDD identificado por el ISBN
	 * 
	 * @param ISBN el ISBN del libro a eliminar
	 * @return boolean true/false indica si la operacion se ha realizado o no correctamente
	 */
	public boolean eliminarLibro(String ISBN);
	/**
	 * Obtiene una lista de todos los libros de la BBDD
	 * 
	 * @return  La lista de libros
	 * 
	 */
	public List<Libro> consultarTodos();
	/**
	 * 
	 * Obtiene el libro especificado por su ISBN de la BBDD 
	 * 
	 * @param ISBN el identificador del libro a obtener
	 * @return el libro recuperado
	 * @throws LibroNoEncontradoException error que se lanza en caso de que no haya un libro en la BBDD con dicho ISBN
	 */
	public Libro consultarISBN(String ISBN) throws LibroNoEncontradoException;
	/**
	 * Obtener libro(s) por su titulo o parte de el. Si hay más de una coincidencia devolvera una lista de aquellos que cumplen la condicion
	 * 
	 * @param titulo cadena de texto que contenga un titulo de libro o una parte de el
	 * @return lista de uno o mas libros que cuyo(s) titulos contengan el texto proprocinado
	 * @throws LibroNoEncontradoException error que se lanza en caso de que no haya un libro en la BBDD con dicho ISBN 
	 */
	public List<Libro> consultarTitulo(String titulo) throws LibroNoEncontradoException;
	/**
	 * Modificar el precio de un libro de la BBDD proporcionado el ISBN y el nuevo precio del libro
	 * 
	 * @param isbn identificador del libro a modificar
	 * @param precio nuevo precio 
	 * @return boolean true/false indica si la operacion se ha realizado o no correctamente
	 */
	public boolean modificarPrecio(String isbn,double precio);


	public boolean altaAutor(Autor autor);
	public boolean eliminarAutor(long id);

	public boolean altaEditorial(Editorial editorial);
	public boolean eliminarEditorial(String nif);

	public List<Autor> consultarTodosAutores();
	public List<Autor> consultarNomAutor(String nom);
	public List<Autor> consultarNacAutor(String nac);
	public List<Editorial> consultarTodasEditoriales();

	public Editorial consultarNifEditorial(String nif);
	public List<Editorial> consultarNomEditorial(String nac);
	
	public List<String> consultarAutorNacionalidades();

}
