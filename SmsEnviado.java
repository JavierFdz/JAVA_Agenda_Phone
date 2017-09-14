package Sms;

import Agenda.Contacto;
import Sistema.Hora;

public class SmsEnviado extends Sms {
// ATRIBUTOS

    private Contacto receptor;

// CONTRUCTORES
    public SmsEnviado(String s, Contacto c) {
        super(s);
        receptor = c;
    }

// GET'S Y SET'S   
    public Contacto getReceptor() {
        return receptor;
    }

    public void setReceptor(Contacto c) {
        receptor = c;
    }

// OTROS METODOS DE UTILIDAD
    
    
}
