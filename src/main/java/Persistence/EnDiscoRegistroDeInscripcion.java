package Persistence;

import org.example.RegistroDeInscripcion;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;

public class EnDiscoRegistroDeInscripcion implements RegistroDeInscripcion {
    private String ruta;

    public EnDiscoRegistroDeInscripcion(String ruta) {
        this.ruta = ruta;
    }

    @Override
    public void registrar(LocalDate fechaInscripcion, int idParticipante, int idConcurso) {
        String registro = fechaInscripcion.toString() + "||" + idParticipante + "||" + idConcurso;
        try {
            Files.write((Paths.get(this.ruta)),
                    registro.getBytes(),
                    StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException("No se pudo persistir", e);
        }
    }
}