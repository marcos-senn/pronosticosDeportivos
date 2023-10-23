package modelos;

public class Partido {
    private Equipo equipo1;
    private Equipo equipo2;
    private int golesEquipo1;
    private int golesEquipo2;

    public Partido(Equipo equipo1, Equipo equipo2) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.golesEquipo1 = 0;
        this.golesEquipo2 = 0;
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
}
