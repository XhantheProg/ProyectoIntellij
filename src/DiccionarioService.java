import java.util.Scanner;

public class DiccionarioService {


    public  static  void crearDiccionario(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe la palabra: ");
        String palabra = sc.nextLine();

        System.out.println("Escribe el valor: ");
        String valor = sc.nextLine();

        diccionario2 diccionario = new diccionario2();
        diccionario.setNombre(palabra);
        diccionario.setValor(valor);

        DiccionarioDAO.crearDiccionariodb(diccionario);

    }
    public  static void listarDiccionario(){
        DiccionarioDAO.mostrarDiccionario();
    }


}