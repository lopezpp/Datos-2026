import java.util.Scanner;
public class Main {

    private static Puerto puerto;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("Ingrese número máximo de buques (≤10): ");
        int num = scanner.nextInt();
        scanner.nextLine();

        if (num < 1) num = 1;
        if (num > 10) num = 10;

        puerto = new Puerto(num);

        boolean salir = false;

        while (!salir) {

            mostrarMenuPrincipal();

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:
                    menuRegistroBuques();
                    break;

                case 2:
                    menuRegistroContenedores();
                    break;

                case 3:
                    mostrarPesoTotal();
                    break;

                case 4:
                    listarOrigenAgrupado();
                    break;

                case 5:
                    mostrarInfoContenedor();
                    break;

                case 6:
                    puerto.mostrarEsquema();
                    break;

                case 7:
                    salir = true;
                    System.out.println("Cerrando la aplicación...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }            
                
            
        }
    }

    private static void mostrarMenuPrincipal() {

        System.out.println("\n=== MENÚ PRINCIPAL ===");
        System.out.println("1. Registrar buque");
        System.out.println("2. Registrar contenedor");
        System.out.println("3. Mostrar peso total");
        System.out.println("4. Listar origenes");
        System.out.println("5. Mostrar contenedor por posición");
        System.out.println("6. Mostrar esquema");
        System.out.println("7. Salir");

        System.out.print("Seleccione: ");
    }

    private static void menuRegistroBuques() {

        System.out.print("Nombre del buque: ");
        String nombre = scanner.nextLine();

        Buque b = new Buque(nombre, null, 0);

        if (puerto.registrarBuque(b))
            System.out.println("Buque agregado");
        else
            System.out.println("No hay espacio para más buques");

        puerto.listarBuques();
    }

    private static void menuRegistroContenedores() {

        System.out.print("ID: ");
        String id = scanner.nextLine();

        System.out.print("Peso: ");
        double peso = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Origen: ");
        String origen = scanner.nextLine();

        System.out.print("Fila (1-10): ");
        int fila = scanner.nextInt() - 1;

        System.out.print("Columna (1-10): ");
        int col = scanner.nextInt() - 1;
        scanner.nextLine();

        Contenedor c = new Contenedor(id, peso, origen);

        if (puerto.registrarContenedor(c, fila, col))
            System.out.println("Contenedor registrado");
        else
            System.out.println("No se pudo registrar");

        puerto.mostrarEsquema();
    }

    private static void mostrarPesoTotal() {
        System.out.println("Peso total: " + puerto.pesoTotal() + " kg");
    }

    private static void listarOrigenAgrupado() {
        puerto.listarOrigenAgrupado();
    }

    private static void mostrarInfoContenedor() {

        System.out.print("Fila: ");
        int fila = scanner.nextInt() - 1;

        System.out.print("Columna: ");
        int col = scanner.nextInt() - 1;
        scanner.nextLine();

        Contenedor c = puerto.obtenerContenedor(fila, col);

        if (c == null)
            System.out.println("No hay contenedor");
        else
            System.out.println("ID: " + c.getId() + " Peso: " + c.getPeso() + " Origen: " + c.getOrigen());
    }
}