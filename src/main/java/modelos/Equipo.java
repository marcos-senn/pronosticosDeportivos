package modelos;

public class Equipo {
	private String nombre;
	private String descripcion;
	
	public Equipo(String nombre, String descripcion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	public String toString() {
		return nombre + descripcion;
	}
	//Getters
	public String getNombre() {
		return this.nombre;
	}
	
	public String getDescripcion() {
		return this.nombre;
	}
	
	//Setters
	public void setNombre(String nombre) {
		 this.nombre = nombre;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
