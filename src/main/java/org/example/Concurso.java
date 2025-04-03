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
    private int id;
    private RegistroDeInscripcion registroEnDisco;
    private IMailService mailService;

    public Concurso(LocalDate fechaInicio, LocalDate fechaCierre,
                    LocalDate fechaActual, int id,
                    RegistroDeInscripcion registroEnDisco, IMailService mailService) {
        if (fechaInicio.isAfter(fechaCierre)) {
            throw new RuntimeException("La fecha de inicio no tiene que ser despues de la de cierre");
        }
        if (fechaCierre.isBefore(fechaInicio)) {
            throw new RuntimeException("La fecha de cierre tiene que ser despues del inicio");
        }
        this.fechaInicio = fechaInicio;
        this.fechaCierre = fechaCierre;
        lista = new ArrayList<>();
        this.fechaActual = fechaActual;
        this.id = id;
        this.registroEnDisco = registroEnDisco;
        this.mailService= mailService;
    }

    public void inscribirParticipante(Participante participante) {
        if (fechaActual.isAfter(fechaCierre)) {
            throw new RuntimeException("Ha pasada el periodo de incripscion");
        }
        if (fechaActual.isEqual(fechaInicio)) {
            participante.sumarPuntos(10);
        }
        lista.add(participante);
        this.registroEnDisco.registrar(this.fechaActual, participante.getId(), this.id);
        this.mailService.enviarCorreo(participante.getEmail(),"Inscripción",
                "Usted ha realizado la inscripción..." );
    }

    public boolean estaIncripto(Participante participante) {
        return lista.contains(participante);
    }


    public int cantParticipante() {
        return lista.size();
    }

    private int getId() {
        return this.id;
    }
}