package org.example;

import Persistence.EnDiscoRegistroDeInscripcion;
import Persistence.RegistroDeInscripcionesDAOJDBC;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // en el main no va ninguna comprobacion, los asserts y fakes solo se hacen en los tests
        Participante participante = new Participante("Juan", "Pérez", 0);
        RegistroDeInscripcion enBD = new RegistroDeInscripcionesDAOJDBC();
        Concurso concurso = new Concurso(LocalDate.now(),
                LocalDate.now().plusDays(7),
                LocalDate.now(),
                2,
                new EnDiscoRegistroDeInscripcion("C:\\Users\\santi\\OneDrive\\Documentos\\TP2Ejercicio1\\archivo.txt"),
                new ProveedorDeFecha() {
                    @Override
                    public LocalDate fecha() {
                        return LocalDate.now();
                    }
                },
                enBD);
        concurso.inscribirParticipante(participante);
    }
}
