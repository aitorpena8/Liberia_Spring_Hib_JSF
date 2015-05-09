package app.cliente;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import app.modelo.Libro;
import app.negocio.ItfzGestionLibreria;

public class Main {
	public static void main(String args[]){
		ApplicationContext contenedor=new ClassPathXmlApplicationContext("spring.xml");

		ItfzGestionLibreria gestorLibreria=contenedor.getBean("gestor",ItfzGestionLibreria.class);
		Libro libro1=contenedor.getBean("libro1",Libro.class);
		Libro libro2=contenedor.getBean("libro2",Libro.class);
		Libro libro3=contenedor.getBean("libro3",Libro.class);
		Libro libro4=contenedor.getBean("libro4",Libro.class);

		gestorLibreria.altaLibro(libro1);
		gestorLibreria.altaLibro(libro2);
		gestorLibreria.altaLibro(libro3);
		gestorLibreria.altaLibro(libro4);

		System.out.println(" \nTodos los libros:");
		List<Libro> lista=gestorLibreria.consultarTodosLibro();
		for(Libro libro:lista)
			System.out.println(libro);

		System.out.println("\nEliminar libro: " +libro2.getTitulo());
		gestorLibreria.eliminarLibro(libro2.getIsbn());


		lista=gestorLibreria.consultarTodosLibro();
		for(Libro libro:lista)
			System.out.println(libro);

		double nuevoPrecio=6;
		System.out.println("\nCambiar precio libro: " +libro1.getTitulo()+", "+libro1.getPrecio()+"/"+nuevoPrecio);
		gestorLibreria.modificarPrecio(libro1.getIsbn(), nuevoPrecio);


		lista=gestorLibreria.consultarTodosLibro();
		for(Libro libro:lista)
			System.out.println(libro);


		String isbn="978-84-08-09310-7";
		Libro libro5=gestorLibreria.consultarISBNLibro("978-84-08-09310-7");

		if(libro5!=null)
			System.out.println("\nEl isbn: "+isbn+" pertenece al libro: "+libro5.getTitulo());

		String palabra="viento";

		List<Libro> listaLibros=gestorLibreria.consultarTituloLibro(palabra);
		System.out.println("\n Se han encontrado los siguientes libros cuyos titulos contienen la palabra '"+palabra+"':");
		for(Libro libro:listaLibros)
			System.out.println(libro);


	}

}
