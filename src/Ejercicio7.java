import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Ejercicio7 {
    public void ejer7(File file) {
        try {
            divideAndOrder(file, 'D');
            System.out.println("=========================================================");
            divideAndOrder(file, 'd');
        } catch (Exception e) {
            System.out.println("error");
        }
    }

    // =========================== ABRIR FICHERO ===========================

    /**
     * Opciones para hacer con el archivo
     * 
     * @param file   el archivo
     * @param option la opción de lo que queremos
     * @throws Exception si hay error con el archivo
     */
    public static void divideAndOrder(File file, char option) throws Exception {
        int lines = 0;
        int words = 0;
        ArrayList<String> textInCollection = new ArrayList<>();
        try (Scanner scRead = new Scanner(file)) {
            while (scRead.hasNext()) {
                // System.err.println(scRead.nextLine());
                lines++;
                textInCollection.add(scRead.nextLine());

            }
        }
        switch (option) {
            case 'n':
                /*
                 * TODO Javi explicó una forma más eficiente de hacer esto, leyendo dos veces el
                 * archivo, uno para los nextline y otro para los next, darle una visual
                 */
                for (String lineOnTheText : textInCollection) {
                    String[] wordsInTheColect = lineOnTheText.split(" ");
                    words = words + wordsInTheColect.length;
                }
                System.out.printf("La cadena tiene %d lineas y %d palabras", lines, words);
                break;
            case 'A':
                Collections.sort(textInCollection);
                for (String stringWatch : textInCollection) {
                    System.out.println(stringWatch);
                }
                break;
            case 'D':
                Collections.sort(textInCollection, Collections.reverseOrder());
                for (String stringWatch : textInCollection) {
                    System.out.println(stringWatch);
                }
                break;
            case 'a':
                Collections.sort(textInCollection, String.CASE_INSENSITIVE_ORDER);
                for (String stringWatch : textInCollection) {
                    System.out.println(stringWatch);
                }
                break;
            case 'd':
                Collections.sort(textInCollection, String.CASE_INSENSITIVE_ORDER.reversed());
                for (String stringWatch : textInCollection) {
                    System.out.println(stringWatch);
                }
                break;

            default:
                break;
        }

    }

}
