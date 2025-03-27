import Persistence.EnDiscoRegistroDeInscripcion;
import org.example.Concurso;
import org.example.Participante;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class TestEjercicio1 {
    @Test
    public void test01() {
        Participante participante = new Participante("Juan", "Pérez", 0);
        Concurso concurso = new Concurso(LocalDate.now(),
                LocalDate.now().plusDays(7),
                LocalDate.now(),
                2,
                new EnDiscoRegistroDeInscripcion("C:\\Users\\santi\\OneDrive\\Documentos\\TP2Ejercicio1\\archivo.txt"));
        concurso.inscribirParticipante(participante);
        assertTrue(concurso.estaIncripto(participante));
        assertEquals(10, participante.getPuntos());
        //assertTrue(concurso.estaInscriptoEnArchivo(participante));
    }

    @Test
    public void test02() {
        Participante participante1 = new Participante("Sofia", "Perez", 1);
        Participante participante2 = new Participante("Lautaro", "Pérez", 2);
        LocalDate fechaInicio = LocalDate.of(2025, 3, 1);
        LocalDate fechaCierre = LocalDate.of(2025, 3, 5);
        LocalDate fechaActual = LocalDate.of(2025, 3, 2);
        Concurso concurso = new Concurso(LocalDate.now(),
                LocalDate.now().plusDays(5),
                LocalDate.now().plusDays(1),
                2,
                new EnDiscoRegistroDeInscripcion("C:\\Users\\santi\\OneDrive\\Documentos\\TP2Ejercicio1\\archivo.txt"));
        concurso.inscribirParticipante(participante1);
        concurso.inscribirParticipante(participante2);
        assertEquals(2, concurso.cantParticipante());
        assertTrue(concurso.estaIncripto(participante1));
        assertTrue(concurso.estaIncripto(participante2));
    }

    @Test
    public void test03() {
        Participante participante = new Participante("Carlos", "Gomez", 3);
        LocalDate fechaInicio = LocalDate.of(2025, 3, 1);
        LocalDate fechaCierre = LocalDate.of(2025, 3, 5);
        LocalDate fechaActual = LocalDate.of(2025, 3, 7);
        Concurso concurso = new Concurso(LocalDate.now(),
                LocalDate.now().plusDays(5),
                LocalDate.now().plusDays(8),
                2,
                new EnDiscoRegistroDeInscripcion("C:\\Users\\santi\\OneDrive\\Documentos\\TP2Ejercicio1\\archivo.txt"));
        assertThrows(RuntimeException.class, () -> {
            concurso.inscribirParticipante(participante);
        });
        assertFalse(concurso.estaIncripto(participante));
    }

}
