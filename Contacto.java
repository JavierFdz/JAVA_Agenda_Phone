package Agenda;

import java.io.Serializable;

public class Contacto implements Serializable{
// ATRIBUTOS
    private String nombre;
    private String apellidos;
    private String tel; // OBLIGATOIRO
 // CONTRUCTORES


    public Contacto(String t){
        tel=t;
        nombre="";
        apellidos="";
    }
    public Contacto(String n, String a, String t){
        nombre=n;
        apellidos=a;
        tel=t;
    }
 // GET'S Y SET'S   
    public String getNombre(){
        return nombre;
    }
    public String getApellidos(){
        return apellidos;
    }
    public String getTel(){
        return tel;
    }
    
 // OTROS METODOS DE UTILIDAD
    public void rellenar(){
        // pide el nombre y el apellido, pero no son obligatorios
    }
    
    public String toString(){
        String s= this.getNombre() +";" +this.getApellidos()+";" +this.getTel();
        return s;
    }
}