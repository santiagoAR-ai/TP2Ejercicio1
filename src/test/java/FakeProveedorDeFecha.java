import org.example.ProveedorDeFecha;

import java.time.LocalDate;

public class FakeProveedorDeFecha implements ProveedorDeFecha {
    @Override
    public LocalDate fecha() {
        return LocalDate.of(2025, 3, 28);
    }
}
