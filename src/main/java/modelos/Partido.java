package modelos;

public class Partido {
    private Equipo equipo1;
    private Equipo equipo2;
    private int golesEquipo1;
    private int golesEquipo2;

    public Partido(Equipo equipo1, Equipo equipo2, int goles1, int goles2) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.golesEquipo1 = goles1;
        this.golesEquipo2 = goles2;
    }

  

	public Partido() {
		// TODO Auto-generated constructor stub
	}



	public String toString() {
        return "Partido[Resultado: Equipo 1: " + equipo1 + " Goles: " + golesEquipo1 + " | Equipo 2: " + equipo2 + " Goles: " + golesEquipo2 + "]";
    }


	public void agregarGolEquipo1() {
        golesEquipo1++;
    }

    public void agregarGolEquipo2() {
        golesEquipo2++;
    }

    public ResultadosEnum resultado() {
        if (golesEquipo1 > golesEquipo2) {
            return ResultadosEnum.GANA_EQUIPO1;
        } else if (golesEquipo1 < golesEquipo2) {
            return ResultadosEnum.GANA_EQUIPO2;
        } else {
            return ResultadosEnum.EMPATE;
        }
    }

    public void setEquipo1(Equipo equipo1) {
		this.equipo1 = equipo1;
	}
    public void setEquipo2(Equipo equipo2) {
		this.equipo2 = equipo2;
	}
    
    public Equipo getEquipo1() {
        return equipo1;
    }

    public Equipo getEquipo2() {
        return equipo2;
    }

    public int getGolesEquipo1() {
        return golesEquipo1;
    }

    public int getGolesEquipo2() {
        return golesEquipo2;
    }

	public void setGolesEquipo1(int cantgoles1) {
		this.golesEquipo1 = cantgoles1;		
	}

	public void setGolesEquipo2(int cantgoles2) {
		this.golesEquipo2 = cantgoles2;		
	}
	
	
}
