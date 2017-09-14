package Sms;

import Agenda.Contacto;

public class SmsRecibido extends Sms {
// ATRIBUTOS

    private Contacto destinatario;
// CONTRUCTORES

    public SmsRecibido(String t, Contacto c) {
        super(t);
        destinatario = c;
    }
// GET'S Y SET'S   

    public Contacto getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Contacto c) {
        destinatario = c;
    }

// OTROS METODOS DE UTILIDAD
}
