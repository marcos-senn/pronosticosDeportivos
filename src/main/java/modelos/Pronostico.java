package modelos;

public class Pronostico {
    private Partido partido;
    private Equipo equipo;
    private ResultadosEnum resultado;

    public Pronostico(Partido partido, Equipo equipo, ResultadosEnum resultado) {
        this.partido = partido;
        this.equipo = equipo;
        this.resultado = resultado;
    }
    
    public String toString() {
    	return "Pronostico [Partido: "+ partido+"\n Equipo: "+equipo+ " Resultado: "+resultado+"]";
    }
    
    public ResultadosEnum getResultado() {
        return resultado;
    }
    }


