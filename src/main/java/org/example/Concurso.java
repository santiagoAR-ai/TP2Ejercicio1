package org.example;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
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
    private RegistroDeInscripcion registro;

    public Concurso(LocalDate fechaInicio, LocalDate fechaCierre, LocalDate fechaActual, int id,RegistroDeInscripcion registro) {
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
        this.id=id;
        this.registro=registro;
    }

    public void inscribirParticipante(Participante participante) {
        if (fechaActual.isAfter(fechaCierre)) {
            throw new RuntimeException("Ha pasada el periodo de incripscion");
        }
        if (fechaActual.isEqual(fechaInicio)) {
            participante.sumarPuntos(10);
        }
        String nombreYFecha= participante.getNombre() +"||"+fechaActual.toString() + "\n" ;
        this.registro.registrar(nombreYFecha);
    }

    public boolean estaIncripto(Participante participante) {
        return lista.contains(participante);
    }
/*
    public boolean estaInscriptoEnArchivo(Participante participante){
        String archivo = "inscripciones.txt";
        String linea;
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            while ((linea = reader.readLine()) != null) {
                // Suponiendo que las líneas son: "Fecha: 2025-03-23, ID Participante: 123, ID Concurso: 456"
                String[] datos = linea.split(",");
                String idEnArchivo = datos[1].trim().split(":")[1].trim(); // Extraer el ID del participante desde el formato "ID Participante: 123"

                // Comparamos el id del participante con el id leído del archivo
                if (idEnArchivo.equals(String.valueOf(participante.getId()))) {
                    System.out.println("Participante encontrado: " + linea);
                    return true;  // Si lo encontramos, devolvemos true
                }
            }
        } catch (IOException e) {
            e.printStackTrace();  // Manejo de excepciones si el archivo no se puede leer
        }
        return false;  // Si no lo encontramos
    }
*/

    public int cantParticipante() {
        return lista.size();
    }

    private int getId(){return this.id;}
}