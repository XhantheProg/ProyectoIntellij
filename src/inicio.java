public class inicio {
    public static void main(String[] args) {
        System.out.println("hola");
        Connexion conexion = new Connexion();
        try{
            conexion.ger_conConnection();

        }catch (Exception e){
            System.out.println(e);
        }
    }
}
