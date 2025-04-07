import Persistence.RegistroDeInscripcionesDAOJDBC;
import org.example.Concurso;
import org.example.Participante;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class TestEjercicio1 {
    @Test
    public void test01() {
        Participante participante = new Participante("Juan", "Pérez",
                0,"santiagoabdala270@gmail.com");
        var enMemoria = new FakeRegistroDeInscripcion();
        var servicefake= new ServiceMailFake();
        Concurso concurso = new Concurso(LocalDate.now(),
                LocalDate.now().plusDays(7),
                LocalDate.now(), 2,
                enMemoria,
                servicefake);
        concurso.inscribirParticipante(participante);

        assertTrue(concurso.estaIncripto(participante));
        assertEquals(10, participante.getPuntos());
        assertEquals("santiagoabdala270@gmail.com - Inscripción: Usted ha realizado la inscripción...",
                servicefake.mail());

    }

    @Test
    public void test02() {
        Participante participante1 = new Participante("Sofia", "Perez", 1,"santiagoabdala270@gmail.com");
        Participante participante2 = new Participante("Lautaro", "Pérez", 2,"santiagoabdala270@gmail.com");
        var enMemoria = new FakeRegistroDeInscripcion();
        var servicefake= new ServiceMailFake();
        Concurso concurso = new Concurso(LocalDate.now(),
                LocalDate.now().plusDays(5),
                LocalDate.now().plusDays(1),
                2,enMemoria,
                servicefake
                );
        concurso.inscribirParticipante(participante1);
        concurso.inscribirParticipante(participante2);
        assertEquals(2, concurso.cantParticipante());
        assertTrue(concurso.estaIncripto(participante1));
        assertTrue(concurso.estaIncripto(participante2));
        assertEquals("santiagoabdala270@gmail.com - Inscripción: Usted ha realizado la inscripción...",
                servicefake.mail());
    }

    @Test
    public void test03() {
        Participante participante = new Participante("Carlos", "Gomez", 3,"santiagoabdala270@gmail.com");
        var enMemoria = new FakeRegistroDeInscripcion();
        var servicefake= new ServiceMailFake();
        Concurso concurso = new Concurso(LocalDate.now(),
                LocalDate.now().plusDays(5),
                LocalDate.now().plusDays(8),
                2,enMemoria,
                servicefake);
        assertThrows(RuntimeException.class, () -> {
            concurso.inscribirParticipante(participante);
        });
        assertFalse(concurso.estaIncripto(participante));
    }

}