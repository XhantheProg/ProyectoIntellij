import java.util.Scanner;

public class DiccionarioService {


    public  static  void crearDiccionario(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe la palabra: ");
        String palabra = sc.nextLine();

        System.out.println("Escribe el valor: ");
        String valor = sc.nextLine();

        getters_setters diccionario = new getters_setters();
        diccionario.setNombre(palabra);
        diccionario.setValor(valor);

        DiccionarioDAO.crearDiccionariodb(diccionario);

    }
    public  static void listarDiccionario(){
        DiccionarioDAO.mostrarDiccionario();
    }

    public static void BorrarDiccionario() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe la palabra a borrar: ");
        String palabra = sc.nextLine();
        DiccionarioDAO.Borrardiccionario(palabra);
    }

    public static void modificarDiccionario() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Palabra a modificar: ");
        String palabra = sc.nextLine();

        System.out.print("Nuevo valor: ");
        String nuevoValor = sc.nextLine();

        DiccionarioDAO.modificarDiccionario(palabra, nuevoValor);
    }


}
