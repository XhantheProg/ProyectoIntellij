import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
public class inicio {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MenuPrincipal menuPrincipal = new MenuPrincipal();

        while (true) {
            mostrarMenuInicio();
            int inicioChoice = scanner.nextInt();
            scanner.nextLine();

            switch (inicioChoice) {
                case 1:
                    menuPrincipal.mostrarMenuLiteratura(scanner);
                    break;
                case 2:
                    menuPrincipal.mostrarMenuMatematicas(scanner);
                    break;
                case 3:
                    System.out.println("Saliendo del programa.");
                    System.exit(0);
                default:
                    System.out.println("Opción inválida. Vuelva a intentarlo.");
            }
        }
    }

    public static void mostrarMenuInicio() {
        System.out.println("Biblioteca:");
        System.out.println("1. Literatura");
        System.out.println("2. Matemáticas");
        System.out.println("3. Salir");
        System.out.print("Seleccione una opción: ");
    }
}

class MenuPrincipal {
    private diccionario Dic = new diccionario();
    private diccionario.Figura Fig = new diccionario.Figura();

    public void mostrarMenu() {
        System.out.println("Menú principal:");
        System.out.println("1. Diccionario");
        System.out.println("2. Calculadora Geométrica");
        System.out.println("3. Salir");
        System.out.print("Seleccione una opción: ");
    }

    public void mostrarMenuLiteratura(Scanner scanner) {
        while (true) {
            System.out.println("\nMenú de Literatura:");
            System.out.println("1. Diccionario");
            System.out.println("2. Volver");
            System.out.print("Seleccione una opción: ");

            int literaturaChoice = scanner.nextInt();
            scanner.nextLine();

            switch (literaturaChoice) {
                case 1:
                    Dic.menuDiccionario(scanner);
                    break;
                case 2:
                    return;
                default:
                    System.out.println("Opción inválida. Vuelva a intentarlo.");
            }
        }
    }

    public void mostrarMenuMatematicas(Scanner scanner) {
        while (true) {
            System.out.println("\nMenú de Matemáticas:");
            System.out.println("1. Calculadora Geométrica");
            System.out.println("2. Volver");
            System.out.print("Seleccione una opción: ");

            int matematicasChoice = scanner.nextInt();
            scanner.nextLine();

            switch (matematicasChoice) {
                case 1:
                    Fig.menuFiguras(scanner);  // Cambiado de 'MenuFiguras' a 'menuFiguras'
                    break;
                case 2:
                    return;
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
                        modificarDiccionario();
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
            DiccionarioService.crearDiccionario();
        }

        public void mostrarDiccionario() {
            System.out.println("Diccionario:");
            DiccionarioService.listarDiccionario();
        }

        public static void modificarDiccionario() {
            Scanner sc = new Scanner(System.in);
            System.out.print("Palabra a modificar: ");
            String palabra = sc.nextLine();

            System.out.print("Nuevo valor: ");
            String nuevoValor = sc.nextLine();

            DiccionarioDAO.modificarDiccionario(palabra, nuevoValor);
        }

        public void borrarDiccionario(Scanner scanner) {
            System.out.println("Menú de Borrar Diccionario:");
            System.out.println("1. Borrar todo el diccionario");
            System.out.println("2. Borrar valores específicos");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    DiccionarioDAO.borrarTodo();
                    System.out.println("Diccionario borrado completamente.");
                    break;
                case 2:
                    System.out.print("Palabra a borrar: ");
                    String palabra = scanner.nextLine();
                    DiccionarioDAO.Borrardiccionario(palabra);
                    break;
                default:
                    System.out.println("Opción inválida. Vuelva a intentarlo.");
            }
        }






        public static class Figura {

            private static ArrayList<String> figurasAñadidas = new ArrayList<>();


            private void mostrarMenuMatematicas(Scanner scanner) {
                while (true) {
                    System.out.println("\nMenú de Matemáticas:");
                    System.out.println("1. Calculadora Geométrica");
                    System.out.println("2. Volver");
                    System.out.print("Seleccione una opción: ");

                    int matematicasChoice = scanner.nextInt();
                    scanner.nextLine();

                    switch (matematicasChoice) {
                        case 1:
                            menuFiguras(scanner);
                            break;
                        case 2:
                            return;
                        default:
                            System.out.println("Opción inválida. Vuelva a intentarlo.");
                    }
                }
            }

            private void menuFiguras(Scanner scanner) {
                boolean returnToMain = false;
                while (!returnToMain) {
                    System.out.println("\nMenú de Figuras:");
                    System.out.println("1. Añadir Figura");
                    System.out.println("2. Borrar Figura");
                    System.out.println("3. Buscar Figura");
                    System.out.println("4. Mostrar Figuras");
                    System.out.println("5. Volver");
                    System.out.print("Seleccione una opción: ");

                    int choice = scanner.nextInt();
                    scanner.nextLine();

                    switch (choice) {
                        case 1:
                            añadirFigura(scanner);
                            break;
                        case 2:
                            borrarFigura(scanner);
                            break;
                        case 3:
                            buscarFigura(scanner);
                            break;
                        case 4:
                            mostrarFiguras();
                            break;
                        case 5:
                            returnToMain = true;
                            break;
                        default:
                            System.out.println("Opción inválida. Vuelva a intentarlo.");
                    }
                }
            }

            public void añadirFigura(Scanner scanner) {
                while (true) {
                    System.out.println("\nCual Figura quiere añadir? :");
                    System.out.println("1. Añadir Cuadrado");
                    System.out.println("2. Añadir Cilindro");
                    System.out.println("3. Añadir Cono");
                    System.out.println("4. Añadir Esfera");
                    System.out.println("5. Volver");
                    System.out.print("Seleccione una opción: ");

                    int matematicasChoice = scanner.nextInt();
                    scanner.nextLine();

                    switch (matematicasChoice) {
                        case 1:
                            añadirCuadrado(scanner);
                            break;
                        case 2:
                            añadirCilindro(scanner);
                            break;
                        case 3:
                            añadirCono(scanner);
                            break;
                        case 4:
                            añadirEsfera(scanner);
                            break;
                        case 5:
                            return;
                        default:
                            System.out.println("Opción inválida. Vuelva a intentarlo.");
                    }
                }
            }

            private void añadirCuadrado(Scanner scanner) {
                FigurasService.;
            }

            private void añadirCilindro(Scanner scanner) {
                System.out.println("Ingrese el radio del cilindro: ");
                double radio = scanner.nextDouble();
                scanner.nextLine();

                System.out.println("Ingrese la altura del cilindro: ");
                double altura = scanner.nextDouble();
                scanner.nextLine();

                FigurasDAO.guardarCilindroEnDB(radio, altura);
            }

            private void añadirCono(Scanner scanner) {
                System.out.println("Ingrese el radio del cono: ");
                double radio = scanner.nextDouble();
                scanner.nextLine();

                System.out.println("Ingrese la altura del cono: ");
                double altura = scanner.nextDouble();
                scanner.nextLine();

                FigurasDAO.guardarConoEnDB(radio, altura);
            }

            private void añadirEsfera(Scanner scanner) {
                System.out.println("Ingrese el radio de la esfera: ");
                double radio = scanner.nextDouble();
                scanner.nextLine();

                FigurasDAO.guardarEsferaEnDB(radio);
            }



            private static void borrarFigura(Scanner scanner) {
                System.out.println("Seleccione una opción para borrar:");
                System.out.println("1. Borrar por ID");
                System.out.println("2. Borrar todo");
                int borrarChoice = scanner.nextInt();
                scanner.nextLine();

                switch (borrarChoice) {
                    case 1:
                        borrarPorID(scanner);
                        break;
                    case 2:
                        borrarTodo();
                        break;
                    default:
                        System.out.println("Opción inválida.");
                }
            }

            private static void borrarPorID(Scanner scanner) {
                System.out.println("Ingrese el ID de la figura a borrar: ");
                int id = scanner.nextInt();
                scanner.nextLine();

                if (id >= 0 && id < figurasAñadidas.size()) {
                    String figuraBorrada = figurasAñadidas.remove(id);
                    System.out.println("Figura borrada: " + figuraBorrada);
                } else {
                    System.out.println("ID inválido. No se encontró ninguna figura con ese ID.");
                }
            }

            private static void borrarTodo() {
                figurasAñadidas.clear();
                System.out.println("Todas las figuras han sido borradas.");
            }

            private static void buscarFigura(Scanner scanner) {
                System.out.println("Seleccione una opción para buscar:");
                System.out.println("1. Buscar por figura específica");
                System.out.println("2. Buscar por ID");
                int buscarChoice = scanner.nextInt();
                scanner.nextLine();

                switch (buscarChoice) {
                    case 1:
                        buscarFiguraEspecifica(scanner);
                        break;
                    case 2:
                        buscarPorID(scanner);
                        break;
                    default:
                        System.out.println("Opción inválida.");
                }
            }

            private static void buscarFiguraEspecifica(Scanner scanner) {
                System.out.println("Seleccione una figura para buscar:");
                System.out.println("1. Cuadrado");
                System.out.println("2. Cilindro");
                System.out.println("3. Cono");
                System.out.println("4. Esfera");
                int figuraChoice = scanner.nextInt();
                scanner.nextLine();

                switch (figuraChoice) {
                    case 1:
                        mostrarFigurasEspecificas("Cuadrado");
                        break;
                    case 2:
                        mostrarFigurasEspecificas("Cilindro");
                        break;
                    case 3:
                        mostrarFigurasEspecificas("Cono");
                        break;
                    case 4:
                        mostrarFigurasEspecificas("Esfera");
                        break;
                    default:
                        System.out.println("Opción inválida.");
                }
            }

            private static void mostrarFigurasEspecificas(String figuraEspecifica) {
                System.out.println("\nFiguras de tipo " + figuraEspecifica + ":");
                for (String figura : figurasAñadidas) {
                    if (figura.contains(figuraEspecifica)) {
                        System.out.println(figura);
                    }
                }
            }

            private static void buscarPorID(Scanner scanner) {
                System.out.println("Ingrese el ID de la figura a buscar: ");
                int id = scanner.nextInt();
                scanner.nextLine();

                if (id >= 0 && id < figurasAñadidas.size()) {
                    String figuraEncontrada = figurasAñadidas.get(id);
                    System.out.println("Figura encontrada: " + figuraEncontrada);
                } else {
                    System.out.println("ID inválido. No se encontró ninguna figura con ese ID.");
                }
            }

            private static void mostrarFiguras() {
                System.out.println("\nFiguras Añadidas:");
                for (int i = 0; i < figurasAñadidas.size(); i++) {
                    System.out.println("ID " + i + ": " + figurasAñadidas.get(i));
                }
            }
        }

    }
}

