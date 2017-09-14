package Agenda;

import _movil_v1.constantes;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Agenda  implements constantes, Serializable {
// ATRIBUTOS

    private ArrayList<Contacto> agenda; // para empezar decidimo implementarlo con un vector
    private InputStreamReader isr;
    private BufferedReader br;

// CONTRUCTORES
    public Agenda() {
        agenda = new ArrayList<Contacto>();
        isr = new InputStreamReader(System.in);
        br = new BufferedReader(isr);
    }

// GET'S Y SET'S   
    public ArrayList getAgendaArray() {
        return agenda;
    }
// OTROS METODOS DE UTILIDAD

    public void agregarAgenda(Contacto c) {
        agenda.add(c);

    }

    public void buscar(String criterio) {

    }

    public void verAgenda() {
        for (int i = 0; i < agenda.size(); i++) {
            System.out.println(agenda.get(i).toString());            
        }
         System.out.println("\n");
    }

    public void nuevoContacto() {
        String nom = " ", ape = " ", tel = " ";
        System.out.print("Introduce nombre:");
        try {
            nom = br.readLine();
        } catch (IOException ex) {
            Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.print("Introduce apellidos: ");
        try {
            ape = br.readLine();
        } catch (IOException ex) {
            Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.print("Introduce el teléfono: ");
        try {
            tel = br.readLine();
        } catch (IOException ex) {
            Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
        }

        agenda.add(new Contacto(nom, ape, tel));
    }

}
