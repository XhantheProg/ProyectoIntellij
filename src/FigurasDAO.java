import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FigurasDAO {

    public static void guardarCalculoCilindro(getters_setters figuras) {
        Connexion db_conexion = new Connexion();

        try (Connection conexion = db_conexion.get_conConnection()) {
            PreparedStatement ps = null;

            try {
                String query = "INSERT INTO cilindro (radio, altura) VALUES (?, ?)";
                ps = conexion.prepareStatement(query);
                ps.setDouble(1, figuras.getRadio());
                ps.setDouble(2, figuras.getAltura());
                ps.executeUpdate();
                System.out.println("Cálculo de cilindro guardado exitosamente.");

            } catch (SQLException e) {
                System.out.println(e);
                System.out.println("Error al guardar el cálculo de cilindro.");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    //
}
