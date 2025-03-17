import org.example.Concurso;
import org.example.Participante;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class TestEjercicio1 {
    @Test
    public void test01() {
        Participante participante = new Participante("Juan", "Pérez");
        LocalDate fechaInicio = LocalDate.of(2025, 3, 1);
        LocalDate fechaCierre = LocalDate.of(2025, 3, 5);
        LocalDate fechaActual = LocalDate.of(2025, 3, 1);
        Concurso concurso = new Concurso(fechaInicio, fechaCierre, fechaActual);
        concurso.inscribirParticipante(participante);
        assertTrue(concurso.estaIncripto(participante));
    }

    @Test
    public void test02() {
        Participante participante1 = new Participante("Sofia", "Perez");
        Participante participante2 = new Participante("Juan", "Pérez");
        LocalDate fechaInicio = LocalDate.of(2025, 3, 1);
        LocalDate fechaCierre = LocalDate.of(2025, 3, 5);
        LocalDate fechaActual = LocalDate.of(2025, 3, 2);
        Concurso concurso = new Concurso(fechaInicio, fechaCierre, fechaActual);
        concurso.inscribirParticipante(participante1);
        concurso.inscribirParticipante(participante2);
        assertEquals(2, concurso.cantParticipante());

    }

    @Test
    public void test03() {
        Participante participante = new Participante("Carlos", "Gomez");
        LocalDate fechaInicio = LocalDate.of(2025, 3, 1);
        LocalDate fechaCierre = LocalDate.of(2025, 3, 5);
        LocalDate fechaActual = LocalDate.of(2025, 3, 7);
        Concurso concurso = new Concurso(fechaInicio, fechaCierre, fechaActual);
        assertThrows(RuntimeException.class, () -> {
            concurso.inscribirParticipante(participante);
        });

    }
}
