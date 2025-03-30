import Persistence.ConnectionManager;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class FakeRegistroDeInscripcionBD {
    @Test
    public void testConnection() {
        Connection connection = null;
        connection = ConnectionManager.getConnection();
        assertNotNull(connection, "La conexión debería ser válida y no nula.");
    }
}