package _movil_v1;

import Agenda.*;
import Llamadas.*;
import Sistema.*;
import Sms.*;
import static _movil_v1.constantes.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class _Main {

    public static void main(String[] args) {
        // INICIALIZAMOS Y DEFINICMOS VARIABLES DEL SISTEMA
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        int opcion, opcion2 = 1, opcionMax = 0, numeroSms = 0, numeroLlamadas = 0;
        datosTeclado teclado = new datosTeclado();

// INICIALIZAMOS Y DEFINICMOS OBJETOS REALES DEL SISTEMA
        Sistema s = new Sistema();
        Agenda a = new Agenda();
        s.importarAgenda(a);
        
        //SMS
        ArrayList<Sms> listaSMS = new ArrayList<Sms>(); //creamos el array de SMS
        listaSMS = s.importarSms();    //importamos SMS's del archivo binario

        //LLAMADAS
        ArrayList<Llamada> listaLlamadas = new ArrayList<Llamada>();
        listaLlamadas = s.importarLlamadas();
        
// MOSTRAMOS MENU CON METODOS ESTATICOS, 
// lo metemos en un bucle infinito, ya que
// solo la opcion apagarmovil, cierra la aplicacion
        do {
            opcionMax = imprimeMenu(0);// Principal
            opcion = teclado.numeroEntero("Opcion menu: ", 1, opcionMax);
            switch (opcion) {
                case 1: // ************** AGENDA
                    opcionMax = imprimeMenu(1);
                    opcion2 = teclado.numeroEntero("Opcion menu: ", 0, 4);
                    switch (opcion2) {
                        case 1: //1. Buscar Contacto

                            break;
                        case 2: //2. Agregar Contacto
                            a.nuevoContacto();
                            break;
                        case 3: // Ver toda la agenda 
                            a.verAgenda();                            
                            break;
                    }
                    break;
                case 2:
                    // ************** LLAMADAS
                    opcionMax = imprimeMenu(2);
                    opcion2 = teclado.numeroEntero("Opcion menu: ", 0, opcionMax);
                    switch (opcion2) {
                        case 1: //1.  ver todas las llamadas
                            verTodasLlamadas(listaLlamadas);
                            break;
                        case 2: //2.  ver llamada saliente

                            break;
                        case 3: //3. ver llamada entrante
                            break;
                        case 4: //4. borrar llamadas salientes
                            break;
                        case 5: //5. borrar llamadas entrantes
                            break;
                        case 6: //6. borrar todas las llamadas
                            break;
                        case 7: //7. hacer llamada
                            listaLlamadas.add(nuevaLlamada(br, numeroLlamadas));
                            numeroLlamadas++;
                            break;

                    }
                    break;
                case 3:
                    // ************** SMS
                    opcionMax = imprimeMenu(3);
                    opcion2 = teclado.numeroEntero("Opcion menu: ", 0, 6);
                    switch (opcion2) {
                        case 1: //1. ver mensaje
                            verMensaje(br, listaSMS);
                            break;
                        case 2: //2. mensajes enviados
                            buscarMensajes(br, "E", listaSMS);
                            break;
                        case 3: //3. mensajes recibidos
                            buscarMensajes(br, "S", listaSMS);
                            break;
                        case 4: // borrar mensaje
                            borrarMensaje(br, listaSMS);
                            break;
                        case 5: // enviar mensaje                            
                            listaSMS.add(nuevoSms(br, numeroSms));
                            numeroSms++;
                            break;
                        case 6: // ver todos los sms
                            for (int i = 0; i < listaSMS.size(); i++) {// mostrar arrayList
                                System.out.println(listaSMS.get(i).toString());
                            }
                            System.out.println("\n");
                            break;

                    }

                    break;
                case 4:
                    // ************** SISTEMA
                    opcionMax = imprimeMenu(4);
                    opcion2 = teclado.numeroEntero("Opcion menu: ", 0, opcionMax);
                    switch (opcion2) {
                        case 0: //"0. Volver"
                            break;
                        case 1: //"1. Apagar");
                            s.exportarSms(listaSMS);
                            s.exportarLlamadas(listaLlamadas);
                            s.exportarAgenda(a);
                            s.apagarMovil();
                            break;

                        case 2: // "2. Consultar datos del terminal"
                            s.actualizarFechaHora();
                            s.consultarDatosMovil();
                            teclado.pulsaTecla();
                            break;

                    }
                    break;
            }

        } while (opcion != 0);
    }

    //métodos de SMS
    public static Sms nuevoSms(BufferedReader br, int numSms) {
        System.out.println("Introduce el telefono al que deseas enviar el sms");
        String telf = " ", text = " ";
        try {
            telf = br.readLine();
        } catch (Exception e) {
            System.out.println("ERROR");
        }
        System.out.println("Introduce el texto");
        try {
            text = br.readLine();
        } catch (Exception e) {
            System.out.println("ERROR");
        }
        Sms sms = new Sms(numSms, "E", telf, text);
        return sms;
    }

    public static void buscarMensajes(BufferedReader br, String s, ArrayList a) {
        ArrayList<Sms> aL = a;
        for (int i = 0; i < a.size(); i++) {
            if (aL.get(i).getTipo().equals(s)) {
                System.out.println(aL.get(i).toString());
            }
        }
    }

    public static void borrarMensaje(BufferedReader br, ArrayList a) {
        ArrayList<Sms> aL = a;
        int x = 0;
        System.out.println("Introduce el ID del mensaje que quieres borrar");
        try {
            x = Integer.parseInt(br.readLine());
        } catch (Exception e) {
            System.out.println("ERROR");
        }
        for (int i = 0; i < a.size(); i++) {
            if (aL.get(i).getIdSms() == x) {
                aL.remove(i);
            }
        }

    }

    public static void verMensaje(BufferedReader br, ArrayList a) {
        ArrayList<Sms> aL = a;
        int x = 0;
        System.out.println("Introduce el ID del mensaje que quieres ver");
        try {
            x = Integer.parseInt(br.readLine());
        } catch (Exception e) {
            System.out.println("ERROR");
        }

        for (int i = 0; i < a.size(); i++) {
            if (aL.get(i).getIdSms() == x) {
                System.out.println(aL.get(i).toString());
            }
        }
        System.out.println("\n");
    }

    //MÉTODOS DE LLAMADAS
    public static Llamada nuevaLlamada(BufferedReader br, int numL) {
        System.out.println("Introduce el telefono al que deseas llamar");
        String telf = " ";
        try {
            telf = br.readLine();
        } catch (Exception e) {
            System.out.println("ERROR");
        }
        Llamada llamada = new Llamada(numL, "E", telf);
        return llamada;
    }

    public static void verTodasLlamadas(ArrayList a) {
        ArrayList aL = a;
        for (int i = 0; i < aL.size(); i++) {// mostrar arrayList
            System.out.println(aL.get(i).toString());
        }
        System.out.println("\n");
    }

    //MÉTODOS DE MENÚ
    public static int imprimeMenu(int opcion) {
        int valor = 0;
        switch (opcion) {
            case 0:
                System.out.println("1. Agenda");
                System.out.println("2. Llamadas");
                System.out.println("3. SMS");
                System.out.println("4. Sistema");
                valor = 4;
                break;
            case 1:
                //Opciones de la agenda
                System.out.println("0. Volver");
                System.out.println("1. Buscar Contacto");
                System.out.println("2. Agregar Contacto");
                System.out.println("3. Ver Agenda");
                // este despues tendra 4 opciones
                //   3.1 Eliminar Cont
                //  3.2 Editar Contacto
                //  3.3 Llamar Cont
                //  3.4 Enviar SMS Contacto

                valor = 3;
                break;

            case 2:
                //Opciones de las llamadas
                System.out.println("0. Volver");
                System.out.println("1. Ver todas las llamadas");
                System.out.println("2. Ver llamada saliente");
                System.out.println("3. Ver llamada entrante");
                System.out.println("4. Borrar todas las llamadas salientes");
                System.out.println("5. Borrar todas las llamadas entrantes");
                System.out.println("6. Borrar todas las llamadas");
                System.out.println("7. Llamar");
                valor = 7;
                break;

            case 3:
                //Opciones de los SMS
                System.out.println("0. Volver");
                System.out.println("1. Ver mensaje");
                System.out.println("2. Ver mensajes enviados");
                System.out.println("3. Ver mensajes recibidos");
                System.out.println("4. Borrar mensajes");
                System.out.println("5. Enviar mensaje");
                System.out.println("6. Ver todos los mensajes");
                valor = 5;
                break;

            case 4:
                //Opciones del sistema
                System.out.println("0. Volver");
                System.out.println("1. Apagar");
                System.out.println("2. Consultar datos del terminal");
                valor = 3;
                break;
        }
        return valor;
    }
}
