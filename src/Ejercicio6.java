import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio6 {

    public void ejer6(File file, File filePure) {
        try {
            // cutTextCharacter(file, 3);// caracteres
            // cutTextLine(file, 3);// lineas
            ArrayList<File> contentFile = new ArrayList<>();
            contentFile.add(new File("resources/prueba/aa.txt"));
            contentFile.add(new File("resources/prueba/bb.txt"));
            contentFile.add(new File("resources/prueba/cc.txt"));

            concat(contentFile, "Copyarchi");
        } catch (IOException e) {
            System.out.println("Error de lectura de fichero");

        } catch (Exception e) {
            e.getMessage();
        }

    }

    public static void cutTextCharacter(File file, int num) throws Exception {

        try (FileReader fileRead = new FileReader(file)) {
            int i;
            int nameFile = 1;
            char[] buffer = new char[num];
            while ((i = fileRead.read(buffer)) != -1) {
                String newText = new String(buffer, 0, i);
                try (PrintWriter pw = new PrintWriter("resources/prueba" + nameFile + ".txt");) {
                    pw.println(newText);
                }
                nameFile++;
            }
        }
    }

    public void cutTextLine(File file, int num) throws Exception {
        int cont = 0;
        int nameFile = 1;
        ArrayList<String> lineas = new ArrayList<>();
        try (Scanner scFile = new Scanner(file)) {
            while (scFile.hasNext()) {
                cont++;
                lineas.add(scFile.nextLine());
                while (cont == num) {
                    try (PrintWriter pw = new PrintWriter("resources/prueba/Copyarchi" + nameFile + ".txt")) {
                        for (String lines : lineas) {
                            pw.println(lines);
                        }
                        nameFile++;
                        cont = 0;
                        lineas.clear();
                    }
                }
            }
        } finally {
            try (PrintWriter pw = new PrintWriter("resources/prueba/Copyarchi" + nameFile + ".txt")) {
                for (String lines : lineas) {
                    pw.println(lines);
                }

            }
        }

    }

    public void concat(ArrayList<File> contentFile, String name) throws Exception {

        String line;

        try (PrintWriter pw = new PrintWriter(new File("resources/prueba/TodosJuntos.txt"))) {
            for (int i = 0; i < contentFile.size(); i++) {
                try (Scanner sc = new Scanner(contentFile.get(i))) {// me interesa coger una linea entera, no caracter a
                                                                    // caracter
                    while (sc.hasNextLine()) {
                        line = sc.nextLine();
                        pw.println(line);
                    }
                }
            }
        }
        // le pasamos un array de ficheros

    }
}
