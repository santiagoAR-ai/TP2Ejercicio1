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
        Concurso concurso = new Concurso(LocalDate.now(),
                LocalDate.now().plusDays(7),
                LocalDate.now());
        concurso.inscribirParticipante(participante);
        assertTrue(concurso.estaIncripto(participante));
        assertEquals(10, participante.getPuntos());
    }

    @Test
    public void test02() {
        Participante participante1 = new Participante("Sofia", "Perez");
        Participante participante2 = new Participante("Juan", "Pérez");
        Concurso concurso = new Concurso(LocalDate.now().minusDays(2),
                LocalDate.now().plusDays(7),
                LocalDate.now().plusDays(2));
        concurso.inscribirParticipante(participante1);
        concurso.inscribirParticipante(participante2);
        assertEquals(2, concurso.cantParticipante());
        assertTrue(concurso.estaIncripto(participante1));
        assertTrue(concurso.estaIncripto(participante2));
    }

    @Test
    public void test03() {
        Participante participante = new Participante("Carlos", "Gomez");
        Concurso concurso = new Concurso(LocalDate.now().minusDays(1),
                LocalDate.now().plusDays(5),
                LocalDate.now().plusDays(8));
        assertThrows(RuntimeException.class, () -> {
            concurso.inscribirParticipante(participante);
        });
        assertFalse(concurso.estaIncripto(participante));
    }
}
