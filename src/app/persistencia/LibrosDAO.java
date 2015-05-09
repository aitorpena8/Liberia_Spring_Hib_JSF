package app.persistencia;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate4.HibernateTemplate;

import app.modelo.Autor;
import app.modelo.Editorial;
import app.modelo.Libro;
import app.modelo.LibroNoEncontradoException;

/**
 * @author aitorpena
 *
 */
public class LibrosDAO implements ItfzLibrosDao {

	private HibernateTemplate plantilla;
	private Session session;

	public void inicializa() {
		session = plantilla.getSessionFactory().openSession();
	}

	public void libera() {
		session.close();
	}

	public HibernateTemplate getPlantilla() {
		return plantilla;
	}

	public void setPlantilla(HibernateTemplate plantilla) {
		this.plantilla = plantilla;
	}

	public boolean altaLibro(Libro libro) {

		Transaction tx = session.getTransaction();
		try {
			tx.begin();
			session.save(libro);
			tx.commit();
			return true;
		} catch (DataAccessException dae) {
			System.err.println("altaLibro:DataAccessException "
					+ dae.getMessage());
			tx.rollback();
			return false;
		}

	}

	public boolean eliminarLibro(String ISBN) {
		String hql = "DELETE FROM Libro libro WHERE libro.isbn=:ISBN";

		Transaction tx = session.beginTransaction();
		try {

			Query q = session.createQuery(hql);
			q.setParameter("ISBN", ISBN);
			int n = q.executeUpdate();
			tx.commit();
			if (n == 1) {
				System.out
						.println("eliminarLibro(): libro eliminado correctamente");
				return true;
			} else {
				System.err
						.println("eliminarLibro(): El libro NO se ha eliminado correctamente");
				return true;
			}

		} catch (DataAccessException dae) {
			System.err.println("eliminarLibro():DataAccessException: "
					+ dae.getMessage());
			tx.rollback();
			return false;
		}

	}

	public List<Libro> consultarTodos() {
		String hql = "SELECT libro FROM Libro libro";

		try {
			Query q = session.createQuery(hql);
			List<Libro> listaLibros = (List<Libro>) q.list();
			return listaLibros;
		} catch (DataAccessException dae) {
			System.err.println("consultarTodos():DataAccessException: "
					+ dae.getMessage());
			return null;
		}

	}

	public Libro consultarISBN(String ISBN) throws LibroNoEncontradoException {
		String hql = "SELECT libro FROM Libro libro WHERE libro.isbn=:ISBN";

		try {
			Query q = session.createQuery(hql);
			q.setParameter("ISBN", ISBN);
			List<Libro> listaLibros = (List<Libro>) q.list();
			if (listaLibros == null || listaLibros.size() == 0) {

				throw new LibroNoEncontradoException(
						"No hay ningun libro con isbn:" + ISBN);
			} else {
				return listaLibros.get(0);
			}
		} catch (DataAccessException dae) {
			System.err.println("consultarISBN():DataAccessException: "
					+ dae.getMessage());
			return null;
		}

	}

	public List<Libro> consultarTitulo(String titulo)
			throws LibroNoEncontradoException {
		String hql = "SELECT libro FROM Libro libro WHERE libro.titulo LIKE :TITULO";

		try {
			Query q = session.createQuery(hql);
			q.setParameter("TITULO", "%" + titulo + "%");
			List<Libro> listaLibros = (List<Libro>) q.list();
			if (listaLibros == null)
				throw new LibroNoEncontradoException(
						"No hay ningun libro con titulo:" + titulo);
			return listaLibros;
		} catch (DataAccessException dae) {
			System.err.println("consultarTitulo():DataAccessException: "
					+ dae.getMessage());
			return null;
		}

	}

	public boolean modificarPrecio(String isbn, double precio) {
		String hql = "UPDATE Libro libro SET libro.precio=:PRECIO WHERE libro.isbn=:ISBN";

		Transaction tx = session.beginTransaction();
		try {

			Query q = session.createQuery(hql);
			q.setParameter("PRECIO", precio);
			q.setParameter("ISBN", isbn);
			int n = q.executeUpdate();
			tx.commit();
			if (n == 1) {
				System.out
						.println("modificarPrecio(): precio modificado correctamente");
				return true;
			} else {
				System.err
						.println("modificarPrecio(): El precio NO se ha modificado correctamente");
				return true;
			}

		} catch (DataAccessException dae) {
			System.err.println("modificarPrecio():DataAccessException: "
					+ dae.getMessage());
			if (tx != null)
				tx.rollback();
			return false;
		}

	}

	@Override
	public boolean altaAutor(Autor autor) {
		Transaction tx = session.getTransaction();
		try {
			tx.begin();
			session.save(autor);
			tx.commit();
			return true;
		} catch (DataAccessException dae) {
			System.err.println("altaAutor():DataAccessException "
					+ dae.getMessage());
			tx.rollback();
			return false;
		}
	}

	@Override
	public boolean altaEditorial(Editorial editorial) {
		Transaction tx = session.getTransaction();
		try {
			tx.begin();
			session.save(editorial);
			tx.commit();
			return true;
		} catch (DataAccessException dae) {
			System.err.println("altaEditorial():DataAccessException "
					+ dae.getMessage());
			tx.rollback();
			return false;
		}
	}

	@Override
	public List<Autor> consultarTodosAutores() {
		String hql = "SELECT autor FROM Autor autor";

		try {
			Query q = session.createQuery(hql);
			List<Autor> listaAutores = (List<Autor>) q.list();
			return listaAutores;
		} catch (DataAccessException dae) {
			System.err.println("consultarTodosAutores():DataAccessException: "
					+ dae.getMessage());
			return null;
		}
	}

	@Override
	public List<Editorial> consultarTodasEditoriales() {
		String hql = "SELECT editorial FROM Editorial editorial";

		try {
			Query q = session.createQuery(hql);
			List<Editorial> listaEditoriales = (List<Editorial>) q.list();
			return listaEditoriales;
		} catch (DataAccessException dae) {
			System.err
					.println("consultarTodasEditoriales():DataAccessException: "
							+ dae.getMessage());
			return null;
		}
	}

	@Override
	public boolean eliminarAutor(long id) {
		String hql = "DELETE FROM Autor autor WHERE autor.id=:id";

		Transaction tx = session.beginTransaction();
		try {

			Query q = session.createQuery(hql);
			q.setParameter("id", id);
			int n = q.executeUpdate();
			tx.commit();
			if (n == 1) {
				System.out
						.println("eliminarAutor(): autor eliminado correctamente");
				return true;
			} else {
				System.err
						.println("eliminarAutor(): El autor NO se ha eliminado correctamente");
				return true;
			}

		} catch (DataAccessException dae) {
			System.err.println("eliminarAutor():DataAccessException: "
					+ dae.getMessage());
			tx.rollback();
			return false;
		}

	}

	@Override
	public boolean eliminarEditorial(String nif) {
		String hql = "DELETE FROM Editorial editorial WHERE editorial.nif=:nif";

		Transaction tx = session.beginTransaction();
		try {

			Query q = session.createQuery(hql);
			q.setParameter("nif", nif);
			int n = q.executeUpdate();
			tx.commit();
			if (n == 1) {
				System.out
						.println("eliminarEditorial(): editorial eliminada correctamente");
				return true;
			} else {
				System.err
						.println("eliminarEditorial(): La editorial NO se ha eliminado correctamente");
				return true;
			}

		} catch (DataAccessException dae) {
			System.err.println("eliminarEditorial():DataAccessException: "
					+ dae.getMessage());
			tx.rollback();
			return false;
		}

	}

	@Override
	public List<Autor> consultarNomAutor(String nom) {
		String hql = "SELECT autor FROM Autor autor WHERE autor.nombre LIKE :NOMBRE";

		try {
			Query q = session.createQuery(hql);
			q.setParameter("NOMBRE", "%" + nom + "%");
			List<Autor> listaAutores = (List<Autor>) q.list();
			return listaAutores;
		} catch (DataAccessException dae) {
			System.err.println("consultarNomAutor():DataAccessException: "
					+ dae.getMessage());
			return null;
		}

	}

	@Override
	public List<Autor> consultarNacAutor(String nac) {
		String hql = "SELECT autor FROM Autor autor WHERE autor.nacionalidad LIKE :NAC";
		try {
			Query q = session.createQuery(hql);
			q.setParameter("NAC", "%" + nac + "%");
			List<Autor> listaAutores = (List<Autor>) q.list();
			return listaAutores;
		} catch (DataAccessException dae) {
			System.err.println("consultarNacAutor():DataAccessException: "
					+ dae.getMessage());
			return null;
		}
	}

	@Override
	public Editorial consultarNifEditorial(String nif) {
		String hql = "SELECT editorial FROM Editorial editorial WHERE editorial.nif=:NIF";

		try {
			Query q = session.createQuery(hql);
			q.setParameter("NIF", nif);
			List<Editorial> listaEditorial = (List<Editorial>) q.list();
			if (listaEditorial == null || listaEditorial.size() == 0) {
				return null;

			} else {
				return listaEditorial.get(0);
			}

		} catch (DataAccessException dae) {
			System.err.println("consultarNifEditorial():DataAccessException: "
					+ dae.getMessage());
			return null;
		}

	}

	@Override
	public List<Editorial> consultarNomEditorial(String nom) {
		String hql = "SELECT editorial FROM Editorial editorial WHERE editorial.nombre LIKE :NOMBRE";
		try {
			Query q = session.createQuery(hql);
			q.setParameter("NOMBRE", "%" + nom + "%");
			List<Editorial> listaEditoriales = (List<Editorial>) q.list();
			return listaEditoriales;
		} catch (DataAccessException dae) {
			System.err.println("consultarNomEditorial():DataAccessException: "
					+ dae.getMessage());
			return null;
		}
	}

	@Override
	public List<String> consultarAutorNacionalidades() {
		String hql = "SELECT DISTINCT autor.nacionalidad FROM Autor autor";
		try {
			Query q = session.createQuery(hql);
			List<String> listaNacionalidades = (List<String>) q.list();
			return listaNacionalidades;
		} catch (DataAccessException dae) {
			System.err
					.println("consultarAutorNacionalidades():DataAccessException: "
							+ dae.getMessage());
			return null;
		}
	}

}
