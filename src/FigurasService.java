import java.util.Scanner;

public class FigurasService {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            mostrarMenu();
            int mainChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (mainChoice) {
                case 1:
                    crearFigura();
                    break;
                case 2:
                    // Puedes añadir más opciones según tus necesidades
                    break;
                case 3:
                    System.out.println("Saliendo del programa.");
                    System.exit(0);
                default:
                    System.out.println("Opción inválida. Vuelva a intentarlo.");
            }
        }
    }

    public static void mostrarMenu() {
        System.out.println("Menú de Figuras:");
        System.out.println("1. Calcular Cilindro");
        System.out.println("2. Otra opción de figura");
        System.out.println("3. Salir");
        System.out.print("Seleccione una opción: ");
    }

    public static void crearFigura() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Calculando Cilindro:");

        System.out.print("Ingrese el radio del cilindro: ");
        double radio = sc.nextDouble();
        sc.nextLine(); // Consume newline

        System.out.print("Ingrese la altura del cilindro: ");
        double altura = sc.nextDouble();
        sc.nextLine(); // Consume newline

        // Puedes expandir esta parte según las necesidades de tu aplicación
        Figuras figuras = new Figuras();
        figuras.setRadio(radio);
        figuras.setAltura(altura);

        FigurasDAO.guardarCalculoCilindro(figuras);
    }
}
