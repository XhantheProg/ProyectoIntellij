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



        public static void Borrardiccionario(String palabra) {
            Connexion db_conexion = new Connexion();
            try (Connection conexion = db_conexion.get_conConnection()) {
                PreparedStatement ps = null;
                try {
                    String query = "DELETE FROM diccionario WHERE palabra = ?";
                    ps = conexion.prepareStatement(query);
                    ps.setString(1, palabra);
                    ps.executeUpdate();
                    System.out.println("La palabra ha sido borrada");
                } catch (SQLException e) {
                    System.out.println(e);
                    System.out.println("La palabra no se pudo borrar");
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }

    public static void borrarTodo() {
        Connexion dbConexion = new Connexion();
        try (Connection conexion = dbConexion.get_conConnection()) {
            try {
                String query = "DELETE FROM diccionario";
                PreparedStatement ps = conexion.prepareStatement(query);
                ps.executeUpdate();
                System.out.println("El diccionario ha sido borrado completamente.");

            } catch (SQLException e) {
                System.out.println(e);
                System.out.println("No se pudo borrar el diccionario.");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }




    public static void modificarDiccionario(String palabra, String nuevoValor) {
        Connexion dbConexion = new Connexion();
        try (Connection conexion = dbConexion.get_conConnection()) {
            try {
                String query = "UPDATE diccionario SET valor = ? WHERE palabra = ?";
                PreparedStatement ps = conexion.prepareStatement(query);
                ps.setString(1, nuevoValor);
                ps.setString(2, palabra);
                int rowCount = ps.executeUpdate();

                if (rowCount > 0) {
                    System.out.println("Diccionario modificado exitosamente.");
                } else {
                    System.out.println("La palabra no existe en el diccionario.");
                }

            } catch (SQLException e) {
                System.out.println(e);
                System.out.println("No se pudo modificar el diccionario.");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

}


