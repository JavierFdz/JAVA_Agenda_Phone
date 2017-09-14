package _movil_v1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;


public class datosTeclado {

    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);

    public int numeroEntero(String texto, int min, int max) {
        int num = 0;

        do {
            System.out.print("\nIntroduce " + texto + " debe estar entre " + min + " y " + max+": ");
            try {
                num = Integer.parseInt(br.readLine());
            } catch (Exception ex) {
                num = -1;
            }
            if (num < min || num > max) {
                System.out.println("Valor Incorrecto");
            }

        } while (num < min || num > max);
        return num;
    }
    
     public void pulsaTecla()  {
      String s="";
        System.out.print("\nPulsa una tecla para continuar...");
        try {
            s=br.readLine();
        } catch (Exception e) {
            s="";
        }
          
    }
    public void print(String s){
        System.out.print(s);
    }

}
