package Sistema;

import _movil_v1.datosTeclado;
import java.io.Serializable;
import java.util.Calendar;

public class Hora implements Serializable{
// ATRIBUTOS

    private int h;
    private int m;
    private int s;
    Calendar c = Calendar.getInstance();

// CONTRUCTORES
    public Hora() {
        // inicializa fecha del sistema

        h = c.get(Calendar.HOUR_OF_DAY);
        m = c.get(Calendar.MINUTE);
        s = c.get(Calendar.SECOND);
    }

    public Hora(int h, int m, int s) {
        // inicializa fecha con datos
        this.h = h;
        this.m = m;
        this.s = s;
    }

// GET'S Y SET'S   
    public void setHora(int a) {
        h = a;
    }

    public int getHora() {
        return h;
    }

    //Minutos
    public void setMinutos(int a) {
        m = a;
    }

    public int getMinutos() {
        return m;
    }

    //segundos
    public void setSegundos(int a) {
        s = a;
    }

    public int getSegundos() {
        return s;
    }

// OTROS METODOS DE UTILIDAD
    public void modificarHora() {

    }

    public String toString() {
        String s=this.getHora() + ":" + this.getMinutos() + ":" + this.getSegundos();
        return s;
    }

    public void actualizar() {
        // inicializa fecha del sistema

    }
}
