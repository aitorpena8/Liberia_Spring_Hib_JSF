package app.modelo;

public class Direccion {
	
	private String calle;
	private int numero;
	private String poblacion;
	private int cp;
	private String provincia;
	public Direccion() {
		// TODO Auto-generated constructor stub
	}
	
	public Direccion(String calle, int numero, String poblacion, int cp,
			String provincia) {

		this.calle = calle;
		this.numero = numero;
		this.poblacion = poblacion;
		this.cp = cp;
		this.provincia = provincia;
	}

	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getPoblacion() {
		return poblacion;
	}
	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}
	public int getCp() {
		return cp;
	}
	public void setCp(int cp) {
		this.cp = cp;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	
	@Override
	public String toString() {
		return calle+" "+numero+"º "+cp+" "+poblacion+" "+provincia;
	}
	

}
