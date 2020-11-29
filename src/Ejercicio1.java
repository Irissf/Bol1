import java.io.File;

public class Ejercicio1 {
    public void ejer1(File file) {

        // menu para fichero o directorios
        if (file.isDirectory()) {
            System.out.println("Ficheros:");
            mostrarFicheros(file);// fichero
            System.out.println("Archivos:");
            mostrarArchivos(file);// directorios
        }else{
            System.out.println("No es un directorio");
        }

    }

    public static void mostrarFicheros(File file) {

        File[] contentFile = file.listFiles();
        for (File fileNames : contentFile) {
            if (fileNames.isDirectory()) {
                System.out.println(fileNames.getName());
            } 
        }

    }

    public static void mostrarArchivos(File file) {

        File[] contentFile = file.listFiles();
        for (File fileNames : contentFile) {
            if (fileNames.isFile()) {
                System.out.println(fileNames.getName());
            } 
        }

    }

}
