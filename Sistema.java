package Sistema;

import Agenda.Agenda;
import Agenda.Contacto;
import Llamadas.Llamada;
import Sms.Sms;
import _movil_v1.constantes;
import _movil_v1.datosTeclado;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Sistema implements constantes, Serializable {

// ATRIBUTOS
    private Hora h;
    private Fecha f;

// CONTRUCTORES
    public Sistema() {
        h = new Hora();
        f = new Fecha();
        System.out.println("El sistema se ha iniciado correctamente");
    }

// GET'S Y SET'S   
    public void setHora(Hora h) {
        this.h = h;
    }

    public void setFecha(Fecha f) {
        this.f = f;
    }

    public Fecha getFecha() {
        return this.f;
    }

    public Hora getHora() {
        return this.h;
    }

// OTROS METODOS DE UTILIDAD
    public void apagarMovil() {
        //Cerrar el programa
        System.exit(0);
    }

    public void actualizarFechaHora() {
        f.actualizar();
        h.actualizar();
    }

    public void consultarDatosMovil() {
        //Mostrar los datos del movil
        datosTeclado teclado = new datosTeclado();
        teclado.print("\nModelo: " + MODELO_MOVIL);
        teclado.print("\nFecha Sistema: " + getFecha());
        teclado.print("\nHora Sistema: " + getHora() + "\n\n");
    }

    //agenda  -- archivo binario        --> PASAR A TEXTO
    public void exportarAgenda(Agenda a) {  //escribir
        File f = new File(RUTA_AGENDA);
        if (f.exists()) {
            vaciarArchivo(RUTA_AGENDA);
        }

        try {
            FileWriter fw = new FileWriter(f, true);
            BufferedWriter bw = new BufferedWriter(fw);

            if (f.exists()) {
                for (int i = 0; i < a.getAgendaArray().size(); i++) {
                    bw.write(a.getAgendaArray().get(i).toString());
                    bw.newLine();
                }
                bw.flush();
                bw.close();
            }

        } catch (IOException ex) {
            Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Agenda importarAgenda(Agenda a) { //leer
        File f = new File(RUTA_AGENDA);

        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String cadena = br.readLine();

            while (cadena != null) {
                String n, ap, t;
                n = cadena.substring(0, cadena.indexOf(";"));
                cadena = cadena.substring(cadena.indexOf(";") + 1, cadena.length());
                ap = cadena.substring(0, cadena.indexOf(";"));
                cadena = cadena.substring(cadena.indexOf(";") + 1, cadena.length());
                t = cadena;

                a.agregarAgenda(new Contacto(n, ap, t));
                cadena = br.readLine();

            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
        }

        return a;

    }

    //llamadas
    public void exportarLlamadas(ArrayList l) {
        File f = new File(RUTA_LLAMADA);
        if (f.exists()) {
            vaciarArchivo(RUTA_LLAMADA);
        }
        try {
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(l);
            oos.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ArrayList importarLlamadas() {
        ArrayList<Llamada> llamada = new ArrayList<Llamada>();
        File f = new File(RUTA_LLAMADA);
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);

            llamada = (ArrayList) ois.readObject();
        } catch (Exception e) {

        }
        return llamada;

    }

    //sms
    public void exportarSms(ArrayList sms) { //escribir - FUNCIONA
        File f = new File(RUTA_SMS);
        if (f.exists()) {
            vaciarArchivo(RUTA_SMS);
        }
        try {
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(sms);
            oos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ArrayList importarSms() { //leer     - FUNCIONA
        File f = new File(RUTA_SMS);
        FileInputStream fis;
        ArrayList<Sms> arrayRecuperado = new ArrayList<Sms>();

        try {
            fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);

            arrayRecuperado = (ArrayList) ois.readObject();
        } catch (Exception ex) {
        }
        return arrayRecuperado;
    }

    public void vaciarArchivo(String s) {
        String s2 = s;
        BufferedWriter bw;
        try {
            bw = new BufferedWriter(new FileWriter(s2));
            bw.write("");
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
