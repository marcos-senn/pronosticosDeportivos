package modelos;

import java.util.ArrayList;

public class Persona {
  private String nombre;
  private String apellido;
  private Ronda ronda;
  private Pronostico pronost;
  private int puntaje;

  public Persona(String nombre, String apellido, Ronda ronda, Pronostico pronost, int puntaje) {
	super();
	this.nombre = nombre;
	this.apellido = apellido;
	this.ronda = ronda;
	this.pronost = pronost;
	this.puntaje = puntaje;
}

public Persona() {
	// TODO Auto-generated constructor stub
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public String getApellido() {
	return apellido;
}

public void setApellido(String apellido) {
	this.apellido = apellido;
}

public Ronda getRonda() {
	return ronda;
}

public void setRonda(Ronda ronda) {
	this.ronda = ronda;
}

public Pronostico getPronost() {
	return pronost;
}

public void setPronost(Pronostico pronost) {
	this.pronost = pronost;
}

public int getPuntaje() {
	return puntaje;
}
	@Override
	public String toString() {
		return nombre;
	}
public void setPuntaje(int puntaje) {
	this.puntaje = puntaje;
}


	public void setPronosticos(ArrayList<Pronostico> pronosticos) {
	}
}
