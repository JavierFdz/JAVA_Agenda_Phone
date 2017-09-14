package Sms;

import Sistema.Fecha;
import Sistema.Hora;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;

public class Sms implements Serializable {

// ATRIBUTOS
    private String texto;
    private String tipo;    //entrante ó saliente
    private String telefono;
    private Fecha f;
    private Hora h;
    private int id;
// CONTRUCTORES

    public Sms(String s) {
        texto = s;
        f = new Fecha();
        h = new Hora();
    }

    public Sms(int ident, String tip, String tel, String tex) {
        tipo = tip;
        telefono = tel;
        texto = tex;
        id = ident;
        f = new Fecha();
        h = new Hora();
    }
// GET'S Y SET'S   

    public String getTexto() {
        return texto;
    }

    public void setTexto(String t) {
        texto = t;
    }

    public void setFecha(Fecha f) {
        this.f = f;
    }

    public void setHora(Hora h) {
        this.h = h;
    }

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

    public int getIdSms() {
        return id;
    }

    public String getFecha() { // OTROS METODOS DE UTILIDAD
        String s = f + " ";
        return s;
    }
    
    public String getHora(){
        String s = h + " ";
        return s;
    }

    public String toString() {
        String s = this.getIdSms() + ";" + this.getTipo() + ";" + this.getTelefono() + ";" + this.getTexto() + ";" + this.getFecha()
                + ";" + this.getHora();
        return s;
    }
}
