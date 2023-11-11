import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FigurasDAO {

    public static void guardarCuadradoEnDB(getters_setters figura) {
        Connexion dbConexion = new Connexion();
        try (Connection conexion = dbConexion.get_conConnection()) {
            PreparedStatement ps= null;
            try {
                String query = "INSERT INTO `menuregis`.`figuras` (`lado`) VALUES (?)";
                ps = conexion.prepareStatement(query);
                ps.setFloat(1, figura.getLado());
                ps.executeUpdate();
                System.out.println("Figura guardada exitosamente en la base de datos.");

            } catch (SQLException e) {
                System.out.println(e);
                System.out.println("No se pudo guardar la figura en la base de datos.");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void guardarCilindroEnDB(double radio, double altura) {
        double area = 2 * Math.PI * radio * (radio + altura);
        double perimetro = 2 * Math.PI * radio;

        String figura = "Cilindro - Área: " + area + ", Perímetro: " + perimetro;
        guardarFiguraEnDB(figura);
        System.out.println("Cilindro añadido exitosamente.");
    }

    public static void guardarConoEnDB(double radio, double altura) {
        double area = Math.PI * radio * (radio + Math.sqrt(Math.pow(altura, 2) + Math.pow(radio, 2)));
        double perimetro = 2 * Math.PI * radio;

        String figura = "Cono - Área: " + area + ", Perímetro: " + perimetro;
        guardarFiguraEnDB(figura);
        System.out.println("Cono añadido exitosamente.");
    }

    public static void guardarEsferaEnDB(double radio) {
        double area = 4 * Math.PI * Math.pow(radio, 2);
        String figura = "Esfera - Área: " + area;

        guardarFiguraEnDB(figura);
        System.out.println("Esfera añadida exitosamente.");
    }

    public static void guardarFiguraEnDB(String figura) {
        Connexion dbConexion = new Connexion();
        try (Connection conexion = dbConexion.get_conConnection()) {
            try {
                String query = "INSERT INTO `menuregis`.`figuras` (`cuadrado`, `cono`, `cuadrado`, `esfera`, `area`, `perimetro`, `redio`) VALUES (?, ?, ?, ?, ?, ? ,?)";
                PreparedStatement ps = conexion.prepareStatement(query);
                ps.setString(1, figura);
                ps.executeUpdate();
                System.out.println("Figura guardada exitosamente en la base de datos.");

            } catch (SQLException e) {
                System.out.println(e);
                System.out.println("No se pudo guardar la figura en la base de datos.");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }



    /*public static void guardarCalculoCilindro(getters_setters figuras) {
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
    }*/
    //
}
