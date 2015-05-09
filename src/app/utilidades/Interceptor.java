package app.utilidades;

import app.modelo.Libro;



public class Interceptor {
	
	/**
	 * Funcion que se ejecuta tras insertar correctamente el libro en la BBDD (AOP)
	 * @param libro el libro insertado en la BBDD
	 */
	public void interceptarAltaLibro(Libro libro) {
		System.out.println("El libro '"+libro.getTitulo()+"' se ha insertado correctamente en la BBDD");
	}

}
