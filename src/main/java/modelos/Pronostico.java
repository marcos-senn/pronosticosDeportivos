package modelos;

public class Pronostico {
    private Persona persona;
	private Partido partido;
    private Equipo equipo;
    private ResultadosEnum resultado;

    public Pronostico(Partido partido, Equipo equipo, ResultadosEnum resultado, Persona persona) {
        this.persona = persona;
    	this.partido = partido;
        this.equipo = equipo;
        this.resultado = resultado;
    }
    
    public Pronostico() {
		// TODO Auto-generated constructor stub
	}

	public Pronostico(Partido partido1, Equipo argentina, ResultadosEnum resultadosEnum) {
	}


	public String toString() {
    	return "Pronostico de "+persona+" [Partido: "+ partido+"\n Equipo: "+equipo+ " Resultado: "+resultado+"]";
    }
    
    public ResultadosEnum getResultado() {
        return resultado;
    }

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Partido getPartido() {
		return partido;
	}

	public void setPartido(Partido partido) {
		this.partido = partido;
	}

	public void setResultado(ResultadosEnum resultado) {
		this.resultado = resultado;
	}


    }


