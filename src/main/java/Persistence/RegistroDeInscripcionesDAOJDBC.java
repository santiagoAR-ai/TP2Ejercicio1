package Persistence;

import org.example.RegistroDeInscripcion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class RegistroDeInscripcionesDAOJDBC implements RegistroDeInscripcion {
    @Override
    public void registrar(LocalDate fechaInscripcion, int idParticipante, int idConcurso) {
        try {
            Connection conn = ConnectionManager.getConnection();
            PreparedStatement statement = conn.prepareStatement(
                    "INSERT INTO inscripcion(fechaInscripcion,idParticipante,idConcurso)" + "VALUES (?,?,?)");
            statement.setDate(1, java.sql.Date.valueOf(fechaInscripcion));
            statement.setInt(2, idParticipante);
            statement.setInt(3, idConcurso);

            int cantidad = statement.executeUpdate();

            if (cantidad == 0) {
                throw new RuntimeException("No fue posible realizar la carga");
            }


        } catch (SQLException e) {
            throw new RuntimeException("Error");
        } finally {
            ConnectionManager.disconnect();
        }
    }
}