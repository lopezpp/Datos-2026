public class Matrices {
    public static void main(String[] args) {

        // Creación de la matriz 3x3
        int[][] m = new int[3][3];

        // Llenar la matriz (ejemplo: números consecutivos)
        int contador = 1;

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                m[i][j] = contador++;
            }
        }

        // Mostrar posiciones y elementos
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.println("m[" + i + "][" + j + "] = " + m[i][j]);
            }
        }
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