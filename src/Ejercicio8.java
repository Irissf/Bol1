import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/*
Programa que nos permita copiar archivos binarios
La copia se debe realizar sin buffer como con 
diferentes tamaños de buffer
*/

public class Ejercicio8 {
    public void ejer8(File fileInBin, File fileOutBin) {
        copyBinary(fileInBin, fileOutBin);
        copyBinaryWithBuffer(fileInBin, fileOutBin);
    }

    public static void copyBinary(File fileInBin, File fileOutBin) {
        try (FileInputStream fileIn = new FileInputStream(fileInBin); 
        FileOutputStream fileOut = new FileOutputStream(fileOutBin+"/copia.txt",true)) {
            //¿Y la extensión?
            int c;
            while ((c = fileIn.read()) != -1) {
                fileOut.write(c);
            }
        } catch (Exception e) {
            System.out.println("error");
        }
    }

    public void copyBinaryWithBuffer(File fileInBin, File fileOutBin) {
        try (FileInputStream fileIn = new FileInputStream(fileInBin); 
        FileOutputStream fileOut = new FileOutputStream(fileOutBin+"/copia2.txt",true)) {
            //¿Y la extensión?
            int c;
            byte[] buffer = new byte[10];
            //byte[] buffer = new byte[50];
            while ((c = fileIn.read(buffer)) != -1) {
                fileOut.write(buffer,0,c);
            }
        } catch (Exception e) {
            System.out.println("error");
        }
    }
}
