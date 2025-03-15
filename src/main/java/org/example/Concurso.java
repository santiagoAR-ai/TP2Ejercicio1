package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Concurso {
    private LocalDate fechaInicio;
    private LocalDate fechaCierre;
    private List<Participante> lista;
    private LocalDate fechaActual;

    public Concurso(LocalDate FechaInicio, LocalDate FechaCierre, LocalDate FechaActual) {
        if (FechaInicio.isAfter(FechaCierre)) {
            throw new RuntimeException("La fecha de inicio no tiene que ser despues de la de cierre");
        }
        this.fechaInicio = FechaInicio;
        this.fechaCierre = FechaCierre;
        lista = new ArrayList<>();
        this.fechaActual = FechaActual;
    }

    public void inscribirParticipante(Participante participante) {
        if (participante == null) {
            throw new RuntimeException("Debe ingresar un participante");
        }
        if (fechaActual.isAfter(fechaCierre)) {
            throw new RuntimeException("Ha pasada el periodo de incripscion");
        }
        if (fechaActual.isEqual(fechaInicio)) {
            participante.sumarPuntos(10);
        }
        lista.add(participante);
    }


    public boolean estaIncripto(Participante participante) {
        return lista.contains(participante);
    }
}