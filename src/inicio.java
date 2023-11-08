import java.util.Scanner;
import java.util.HashMap;

public class inicio {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MenuPrincipal menuPrincipal = new MenuPrincipal();

        while (true) {
            menuPrincipal.mostrarMenu();
            int mainChoice = scanner.nextInt();
            scanner.nextLine();
            menuPrincipal.elegirOpcion(mainChoice, scanner);
        }
    }
}

class MenuPrincipal {
    private diccionario Dic = new diccionario();
    private figuras Fig = new figuras();

    public void mostrarMenu() {
        System.out.println("Menú principal:");
        System.out.println("1. Diccionario");
        System.out.println("2. Figuras");
        System.out.println("3. Salir");
        System.out.print("Seleccione una opción: ");
    }

    public void elegirOpcion(int mainChoice, Scanner scanner) {
        switch (mainChoice) {
            case 1:
                Dic.menuDiccionario(scanner);
                break;
            case 2:
                Fig.menuFiguras(scanner);
                break;
            case 3:
                System.out.println("Saliendo del programa.");
                System.exit(0);
            default:
                System.out.println("Opción inválida. Vuelva a intentarlo.");
        }
    }
}

class diccionario {
    private HashMap<String, String> words = new HashMap<>();

    public void menuDiccionario(Scanner scanner) {
        while (true) {
            System.out.println("\nMenú de Diccionario:");
            System.out.println("1. Crear diccionario");
            System.out.println("2. Mostrar diccionario");
            System.out.println("3. Modificar diccionario");
            System.out.println("4. Borrar diccionario");
            System.out.println("5. Volver");
            System.out.print("Seleccione una opción: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    crearDiccionario(scanner);
                    break;
                case 2:
                    mostrarDiccionario();
                    break;
                case 3:
                    modificarDiccionario(scanner);
                    break;
                case 4:
                    borrarDiccionario(scanner);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opción inválida. Vuelva a intentarlo.");
            }
        }
    }

    public void crearDiccionario(Scanner scanner) {
        System.out.print("Cuántas palabras desea añadir: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Palabra: ");
            String palabra = scanner.nextLine();
            System.out.print("Valor: ");
            String valor = scanner.nextLine();
            words.put(palabra, valor);
        }

        System.out.println("Diccionario creado exitosamente.");
    }

    public void mostrarDiccionario() {
        System.out.println("Diccionario:");
        for (String palabra : words.keySet()) {
            System.out.println(palabra + ": " + words.get(palabra));
        }
    }

    public void modificarDiccionario(Scanner scanner) {
        System.out.print("Palabra a modificar: ");
        String palabra = scanner.nextLine();

        if (words.containsKey(palabra)) {
            System.out.print("Nuevo valor: ");
            String nuevoValor = scanner.nextLine();
            words.put(palabra, nuevoValor);
            System.out.println("Diccionario modificado exitosamente.");
        } else {
            System.out.println("La palabra no existe en el diccionario.");
        }
    }

    public void borrarDiccionario(Scanner scanner) {
        System.out.println("Menú de Borrar Diccionario:");
        System.out.println("1. Borrar todo el diccionario");
        System.out.println("2. Borrar valores específicos");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                words.clear();
                System.out.println("Diccionario borrado completamente.");
                break;
            case 2:
                System.out.print("Palabra a borrar: ");
                String palabra = scanner.nextLine();

                if (words.containsKey(palabra)) {
                    words.remove(palabra);
                    System.out.println("Palabra borrada del diccionario.");
                } else {
                    System.out.println("La palabra no existe en el diccionario.");
                }
                break;
            default:
                System.out.println("Opción inválida. Vuelva a intentarlo.");
        }
    }
}

class figuras {
    public void menuFiguras(Scanner scanner) {
        boolean returnToMain = false;
        while (!returnToMain) {
            System.out.println("\nMenú de Figuras:");
            System.out.println("1. Cilindro");
            System.out.println("2. Esfera");
            System.out.println("3. Cono");
            System.out.println("4. Cuadrado");
            System.out.println("5. Volver al menú principal");
            System.out.print("Seleccione una opción: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    calcularCilindro(scanner);
                    break;
                case 2:
                    calcularEsfera(scanner);
                    break;
                case 3:
                    calcularCono(scanner);
                    break;
                case 4:
                    calcularCuadrado(scanner);
                    break;
                case 5:
                    returnToMain = true;
                    break;
                default:
                    System.out.println("Opción inválida. Vuelva a intentarlo.");
            }
        }
    }

    public void calcularCilindro(Scanner scanner) {
        System.out.print("Ingrese el radio del cilindro: ");
        double radio = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Ingrese la altura del cilindro: ");
        double altura = scanner.nextDouble();
        scanner.nextLine();

        double area = 2 * Math.PI * radio * (radio + altura);
        double perimetro = 2 * Math.PI * radio;

        System.out.println("Área del cilindro: " + area);
        System.out.println("Perímetro del cilindro: " + perimetro);
    }

    public void calcularEsfera(Scanner scanner) {
        System.out.print("Ingrese el radio de la esfera: ");
        double radio = scanner.nextDouble();
        scanner.nextLine();

        double area = 4 * Math.PI * Math.pow(radio, 2);

        System.out.println("Área de la esfera: " + area);
    }

    public void calcularCono(Scanner scanner) {
        System.out.print("Ingrese el radio del cono: ");
        double radio = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Ingrese la altura del cono: ");
        double altura = scanner.nextDouble();
        scanner.nextLine();

        double area = Math.PI * radio * (radio + Math.sqrt(Math.pow(altura, 2) + Math.pow(radio, 2)));
        double perimetro = 2 * Math.PI * radio;

        System.out.println("Área del cono: " + area);
        System.out.println("Perímetro del cono: " + perimetro);
    }

    public void calcularCuadrado(Scanner scanner) {
        System.out.print("Ingrese el lado del cuadrado: ");
        double lado = scanner.nextDouble();
        scanner.nextLine();

        double area = Math.pow(lado, 2);
        double perimetro = 4 * lado;

        System.out.println("Área del cuadrado: " + area);
        System.out.println("Perímetro del cuadrado: " + perimetro);
    }
}