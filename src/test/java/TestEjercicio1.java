import org.example.Concurso;
import org.example.Participante;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class TestEjercicio1 {
    @Test
    public void test01() {
        Participante participante = new Participante("Juan", "Pérez");
        LocalDate FechaInicio = LocalDate.of(2025, 3, 1);
        LocalDate FechaCierre = LocalDate.of(2025, 3, 5);
        LocalDate FechaActual = LocalDate.of(2025, 3, 1);
        Concurso concurso = new Concurso(FechaInicio, FechaCierre, FechaActual);
        concurso.inscribirParticipante(participante);
    }

    @Test
    public void test02() {
        Participante participante = new Participante("Sofia", "Perez");
        LocalDate FechaInicio = LocalDate.of(2025, 3, 1);
        LocalDate FechaCierre = LocalDate.of(2025, 3, 5);
        LocalDate FechaActual = LocalDate.of(2025, 3, 2);
        Concurso concurso = new Concurso(FechaInicio, FechaCierre, FechaActual);
        concurso.inscribirParticipante(participante);

    }

    @Test
    public void test03() {
        Participante participante = new Participante("Carlos", "Gomez");
        LocalDate FechaInicio = LocalDate.of(2025, 3, 1);
        LocalDate FechaCierre = LocalDate.of(2025, 3, 5);
        LocalDate FechaActual = LocalDate.of(2025, 3, 7);
        Concurso concurso = new Concurso(FechaInicio, FechaCierre, FechaActual);
        concurso.inscribirParticipante(participante);
    }
}
