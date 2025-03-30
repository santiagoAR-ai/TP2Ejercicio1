import org.example.RegistroDeInscripcion;

import java.time.LocalDate;

public class FakeRegistroDeInscripcion implements RegistroDeInscripcion {
    private String content;

    public boolean startWith(String start) {
        return this.content.startsWith(start);
    }

    @Override
    public void registrar(LocalDate fechaInscripcion, int idParticipante, int idConcurso) {
        this.content = fechaInscripcion.toString() + "||" + idParticipante + "||" + idConcurso;
    }
}