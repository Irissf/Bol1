 
import java.io.File;
 
public class Ejercicio2 {
    
    public void ejer2() {
        File file = new File("resources/prueba");
        allFilesAndDirectories(file);
    }
 
    public static void allFilesAndDirectories(File file) {
        //No sé ni como es que funciona, pero funciona ._.
        File[] fileComponents = file.listFiles();
        for (File file2 : fileComponents) {
            System.out.println(file2.getName());
            if (file2.isDirectory()) {
                allFilesAndDirectories(file2);
            }
 
            /**
             * Arriba podemos ver una versión más reducida de código, como vemos abajo, la primera línes del if y del else
             * era un println, por lo que si lo ponemos antes del if y cambiamos la condición deñ if reducimos lineas de código
             * y lo hacemos más ejectivo.
             * 
             * if (file2.isFile()) {
             *      System.out.println(file2.getName());
             * }else{
             *      System.out.println(file2.getName());
             *      allFilesAndDirectories(file2);
             * }
             */
 
        }
    }
}
