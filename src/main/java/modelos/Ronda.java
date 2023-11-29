package modelos;

public class Ronda {
  private int nroRonda;
  private Partido[] partidos;
 
  
public Ronda(int nroRonda, Partido[] partidos) {
	super();
	this.nroRonda = nroRonda;
	this.partidos = partidos;

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

  
}
