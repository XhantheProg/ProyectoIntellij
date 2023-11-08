import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DiccionarioDAO{
    inicio miMenu = new inicio();
    public void crearDiccionario(Scanner scanner) {
        Connexion db_connect = new Connexion();
        try(Connection conexion = db_connect.get_conConnection()){
            PreparedStatement ps = null;
            // Crear un objeto de la clase menu
            inicio miMenu = new inicio();

            try {
                String query = "INSERT INTO `menuregis`.`diccionario` (`Nombre`, `Valor`) VALUES (?, ?)";
                ps = conexion.prepareStatement(query);

                // Acceder a los métodos de menu en el objeto miMenu
                ps.setString(1, String.valueOf(miMenu.getClass()));
                ps.setString(2, String.valueOf(miMenu.getClass()));

                ps.executeUpdate();
            } catch (SQLException ex) {
                System.out.println(ex);
            }

        }catch (SQLException e){
            System.out.println(e);
        }


    }


}