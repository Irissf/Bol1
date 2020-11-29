import java.io.File;
import java.io.IOException;
import java.util.Scanner;
 
public class Ejercicio5 {
    public void ejer5() {
        File file = new File("C:/Users/Irissf/Desktop/prueba/texto1.txt");//ponerlo como parámetro o como variable clase
        try {
            showLineWithText("uno", file);
        } catch (Exception e) {
            System.out.println("archivo no valido");
        }
    }
 
    public void showLineWithText(String text, File file) throws IOException{
        String textOfFile;
        int line = 0;
        try (Scanner sc = new Scanner(file)) {//me interesa coger una linea entera, no caracter a caracter
            while(sc.hasNextLine()){
                textOfFile = sc.nextLine();
                line++;
                int textExist = textOfFile.indexOf(text);//tengo que llevar la cuenta de las fila
                //https://muchocodigo.com/como-saber-si-un-string-esta-dentro-de-otro-en-java/ y apuntes de Java de primer año, FIcheros
                if (textExist != -1) {
                    System.out.printf("Linea: %d %s\n",line,textOfFile);
                }
            }
        } 
    }
}
