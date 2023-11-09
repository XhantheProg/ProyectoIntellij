import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DiccionarioDAO {
    public static void crearDiccionariodb(diccionario2 diccionario) {
        Connexion db_connect = new Connexion();
        try (Connection conexion = db_connect.get_conConnection()) {
            PreparedStatement ps = null;

            try {
                String query = "INSERT INTO `menuregis`.`diccionario` (`palabra`, `valor`) VALUES (?, ?)";
                ps = conexion.prepareStatement(query);
                ps.setString(1, diccionario.getNombre());
                ps.setString(2, diccionario.getValor());
                ps.executeUpdate();
            } catch (SQLException ex) {
                System.out.println(ex);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public static void mostrarDiccionario() {
        Connexion db_conexion = new Connexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try (Connection conexion = db_conexion.get_conConnection()) {
            String query = "SELECT * FROM diccionario";
            ps = conexion.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Palabra: " + rs.getString("palabra"));
                System.out.println("Significado: " + rs.getString("valor"));
                System.out.println(" *** ");
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void borrarCliente(int id) {
        Connexion db_conexion = new Connexion();
        try (Connection conexion = db_conexion.get_conConnection()) {
            PreparedStatement ps = null;
            try {
                String query = "DELETE FROM diccionario WHERE  id= ?";
                ps = conexion.prepareStatement(query);
                ps.setInt(1, id);
                ps.executeUpdate();
                System.out.println("El cliente a sido borrado");

            } catch (SQLException e) {
                System.out.println(e);
                System.out.println("El cliente no se puedo borrar");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    /*public static void actualizarCliente(Cliente cliente) {
        Conexion db_conexion = new Conexion();
        try (Connection conexion = db_conexion.get_conConnection()) {
            PreparedStatement ps;
            try {
                String query = "UPDATE cliente SET nombre= ?, email=? , telefono= ? WHERE  id=?";
                ps = conexion.prepareStatement(query);
                ps.setString(1, cliente.getNombre());
                ps.setString(2, cliente.getEmail());
                ps.setString(3, cliente.getTelefono());
                ps.setInt(4, cliente.getId());
                ps.executeUpdate();
                System.out.println("Se actualizo correctamente");

            } catch (SQLException e) {
                System.out.println(e);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }*/
}


