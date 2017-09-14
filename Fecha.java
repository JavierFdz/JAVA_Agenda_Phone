package Sistema;

import _movil_v1.datosTeclado;
import java.io.Serializable;
import java.util.Calendar;

public class Fecha implements Serializable{
// ATRIBUTOS

    private int d;
    private int m;
    private int a;

// CONTRUCTORES
    public Fecha() {
        // inicializa fecha del sistema
        Calendar c = Calendar.getInstance();
        this.d = c.get(Calendar.DATE);
        this.m = c.get(Calendar.MONTH);
        this.a = c.get(Calendar.YEAR);
    }

    public Fecha(int d, int m, int a) {
        // inicializa fecha con datos
        this.d = d;
        this.m = m;
        this.a = a;
    }

// GET'S Y SET'S   
    public void setDia(int x) {
        d = x;
    }

    public int getDia() {
        return d;
    }

    //mes
    public void setMes(int x) {
        m = x;
    }

    public int getMes() {
        return m;
    }

    //anyo
    public void setAnyo(int x) {
        a = x;
    }

    public int getAnyo() {
        return a;
    }

// OTROS METODOS DE UTILIDAD
    public void modificarFecha() {

    }

    public String toString() {
        String s = this.getDia() + "/" + this.getMes() + "/" + this.getAnyo();

        return s;
    }

    public void actualizar() {
        // inicializa fecha del sistema

    }
}
