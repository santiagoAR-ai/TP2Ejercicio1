package org.example;

import Persistence.EnDiscoRegistroDeInscripcion;
import Persistence.RegistroDeInscripcionesDAOJDBC;
import Persistence.ServiceMail;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // en el main no va ninguna comprobacion, los asserts y fakes solo se hacen en los tests
        Participante participante = new Participante("Juan", "Pérez",
                0,"santiagoabdala270@gmail.com");
        var enBD = new RegistroDeInscripcionesDAOJDBC();
        var mail= new ServiceMail("05b1cdffe5297b","2e74a25c291adf",
                "true","true",
                "sandbox.smtp.mailtrap.io","587");
        Concurso concurso = new Concurso(LocalDate.now(),
                LocalDate.now().plusDays(7),
                LocalDate.now(),
                2,
                new EnDiscoRegistroDeInscripcion("C:\\Users\\santi\\OneDrive\\Documentos\\TP2Ejercicio1\\archivo.txt"),
                mail);
        concurso.inscribirParticipante(participante);
    }
}