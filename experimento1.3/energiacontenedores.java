import java.util.Random;

public class EnergiaContenedores {
    public static void main(String[] args) {

        Random random = new Random();

        int[] energiaContenedores = new int[12];

        // Llenar el arreglo con números aleatorios entre 50 y 150
        for (int i = 0; i < energiaContenedores.length; i++) {
            energiaContenedores[i] = random.nextInt(100) + 50;
        }

        System.out.println("Valores generados:");
        for (int num : energiaContenedores) {
            System.out.print(num + " ");
        }

        // Crear segundo arreglo para múltiplos de 10
        int[] multiplosDe10 = new int[12];
        int contador = 0;

        for (int num : energiaContenedores) {
            if (num % 10 == 0) {
                multiplosDe10[contador] = num;
                contador++;
            }
        }

        System.out.println("\n\nMúltiplos de 10:");
        for (int i = 0; i < contador; i++) {
            System.out.print(multiplosDe10[i] + " ");
        }
    }
}