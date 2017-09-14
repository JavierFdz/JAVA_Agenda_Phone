package Llamadas;

import Sistema.*;
import java.io.Serializable;

public class Llamada implements Serializable{
// ATRIBUTOS

    private Hora duracion;
    private Fecha fecha;
    private String tipo;//entrante o saliente
    private String telefono;
    private int id;

// CONTRUCTORES
    public Llamada(Hora d) {
        //fecha=new Fecha();
        duracion = d;
    }

    public Llamada(int iden, String tel, String tip) {
        id = iden;
        telefono = tel;
        tipo = tip;
        fecha=new Fecha();
    }

// GET'S Y SET'S
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String s) {
        tipo = s;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String s) {
        telefono = s;
    }

    public int getId() {
        return id;
    }

    public void setId(int x) {
        id = x;
    }
    public Fecha getFecha(){
        return fecha;
    }
    public String getFecha2(){
        String s = fecha + " ";
        return s;
    }

// OTROS METODOS DE UTILIDAD
    public String toString() {
        String s = this.getId() + ";" + this.getTipo() + ";" + this.getTelefono() + ";" + this.getFecha2();
        return s;
    }
}
