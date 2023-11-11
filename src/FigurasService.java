import java.util.Scanner;

public class FigurasService {

    private static void añadirCuadrado() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el lado del cuadrado: ");
        double lado = scanner.nextDouble();
        scanner.nextLine();  // Consumir el salto de línea

        double area = Math.pow(lado, 2);
        double perimetro = 4 * lado;

        String figura = "Cuadrado - Área: " + area + ", Perímetro: " + perimetro;

        // Modificación: utilizar un método para almacenar en la base de datos
        FigurasDAO.guardarCuadradoEnDB(lado);

        System.out.println("Cuadrado añadido exitosamente.");
    }

    private static void añadirCilindro(getters_setters figuras) {
        System.out.println("Ingrese el radio del cilindro: ");
        double radio = figuras.getRadio();

        System.out.println("Ingrese la altura del cilindro: ");
        double altura = figuras.getAltura();


        double area = 2 * Math.PI * radio * (radio + altura);
        double perimetro = 2 * Math.PI * radio;

        String figura = "Cilindro - Área: " + area + ", Perímetro: " + perimetro;
        FigurasDAO.guardarFiguraEnDB(figura);

        System.out.println("Cilindro añadido exitosamente.");
    }

    private static void añadirCono(getters_setters figuras) {
        System.out.println("Ingrese el radio del cono: ");
        double radio = figuras.getRadio();


        System.out.println("Ingrese la altura del cono: ");
        double altura = figuras.getAltura();


        double area = Math.PI * radio * (radio + Math.sqrt(Math.pow(altura, 2) + Math.pow(radio, 2)));
        double perimetro = 2 * Math.PI * radio;

        String figura = "Cono - Área: " + area + ", Perímetro: " + perimetro;
        FigurasDAO.guardarFiguraEnDB(figura);

        System.out.println("Cono añadido exitosamente.");
    }

    private static void añadirEsfera(getters_setters figuras) {
        System.out.println("Ingrese el radio de la esfera: ");
        double radio = figuras.getRadio();


        double area = 4 * Math.PI * Math.pow(radio, 2);

        String figura = "Esfera - Área: " + area;
        FigurasDAO.guardarFiguraEnDB(figura);

        System.out.println("Esfera añadida exitosamente.");
    }
}