 
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
 

public class Ejercicio3 {

    public void ejer3() {
        File file = new File("C:/Users/Irissf/Desktop/prueba/texto1.txt");
        try {
            int count = findCharacter(file, 'a');
            System.out.println("El número de veces que aparece: "+count);
        } catch (Exception e) {
            System.out.println("Error");
        }
 
    }
 
    public static int findCharacter(File file, char character) throws IOException {
        //FileReader fileRead = null; //esta linea sobra con el de 
        int count = 0;
        try (FileReader fileRead = new FileReader(file)) {
            int i;
            while ((i = fileRead.read()) != -1) {
                if(character == i){
                    count++;  
                }
            }
        } 
        return count;
    }
}
