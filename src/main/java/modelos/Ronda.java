package modelos;

public class Ronda {
  private int nroRonda;
  private Partido[] partidos;
  private int puntaje;
  
public Ronda(int nroRonda, Partido[] partidos, int puntaje) {
	super();
	this.nroRonda = nroRonda;
	this.partidos = partidos;
	this.puntaje = puntaje;
}

public int getNroRonda() {
	return nroRonda;
}

public void setNroRonda(int nroRonda) {
	this.nroRonda = nroRonda;
}

public Partido[] getPartidos() {
	return partidos;
}

public void setPartidos(Partido[] partidos) {
	this.partidos = partidos;
}

public int getPuntaje() {
	return puntaje;
}

public void setPuntaje(int puntaje) {
	this.puntaje = puntaje;
}
  
  
}
