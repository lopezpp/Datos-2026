import java.util.HashMap;
import java.util.Map;

public class Puerto {

    private Buque[] buques;
    private Contenedor[][] matriz;

    public Puerto(int capacidadBuques) {
        buques = new Buque[capacidadBuques];
        matriz = new Contenedor[10][10];

        cargarEjemplos(); // llena toda la matriz
    }

    private void cargarEjemplos() {

        String[] origenes = {"China", "Brasil", "Colombia", "USA", "Japón", "India", "Alemania", "Francia", "Italia", "España"  };

        int contador = 1;

        for (int i = 0; i < 10; i++) {

            for (int j = 0; j < 10; j++) {

                String id = "C" + contador;
                double peso = 1000 + (contador * 50);
                String origen = origenes[contador % origenes.length];

                matriz[i][j] = new Contenedor(id, peso, origen);

                contador++;
            }
        }
    }

    public boolean registrarBuque(Buque b) {
        for (int i = 0; i < buques.length; i++) {
            if (buques[i] == null) {
                buques[i] = b;
                return true;
            }
        }
        return false;
    }

    public void listarBuques() {
        for (int i = 0; i < buques.length; i++) {
            if (buques[i] != null) {
                System.out.println((i + 1) + ". " + buques[i].getNombre());
            } else {
                System.out.println((i + 1) + ". (vacío)");
            }
        }
    }

    public boolean registrarContenedor(Contenedor c, int fila, int col) {

        if (fila < 0 || fila >= 10 || col < 0 || col >= 10)
            return false;

        if (matriz[fila][col] != null)
            return false;

        if (fila > 0 && matriz[fila - 1][col] == null)
            return false;

        matriz[fila][col] = c;
        return true;
    }

    public Contenedor obtenerContenedor(int fila, int col) {

        if (fila < 0 || fila >= 10 || col < 0 || col >= 10)
            return null;

        return matriz[fila][col];
    }

    public double pesoTotal() {

        double total = 0;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {

                if (matriz[i][j] != null)
                    total += matriz[i][j].getPeso();
            }
        }

        return total;
    }

    public void listarOrigenAgrupado() {

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {

                if (matriz[i][j] != null) {

                    String origen = matriz[i][j].getOrigen();

                    map.put(origen, map.getOrDefault(origen, 0) + 1);
                }
            }
        }

        for (var e : map.entrySet()) {
            System.out.println(e.getKey() + ": " + e.getValue());
        }
    }

    public void mostrarEsquema() {

        System.out.println("\nESQUEMA DEL PUERTO (10x10)");

        for (int i = 0; i < 10; i++) {

            for (int j = 0; j < 10; j++) {

                if (matriz[i][j] == null)
                    System.out.print("V ");
                else
                    System.out.print("O ");
            }

            System.out.println();
        }
    }
}