package org.example;

import java.time.LocalDate;

public interface RegistroDeInscripcion {
    public void registrar(LocalDate fechaInscripcion, int idParticipante, int idConcurso);
}