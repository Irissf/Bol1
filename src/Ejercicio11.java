import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio11 {

    public void ejer11(File file){
        File fileOriginal = new File(file + "/duaLipa.mp3");
        File fileCopy = new File(file + "/duaLipaCopy.mp3");
        //copyFileConBuffer(fileOriginal, fileCopy);
        copyFileSinBuffer(fileOriginal, fileCopy);
    }

    public void copyFileConBuffer(File fileOriginal, File fileCopy){
        

        try (FileReader fr = new FileReader(fileOriginal);BufferedReader br = new BufferedReader(fr);
        FileWriter fw = new FileWriter(fileCopy,true); BufferedWriter bw = new BufferedWriter(fw)) {
            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();//salto de linea
            }
        }catch(IOException e){
            System.out.println("fin del fichero");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void copyFileSinBuffer(File fileOriginal, File fileCopy){
        try (FileInputStream fileIn = new FileInputStream(fileOriginal); 
        FileOutputStream fileOut = new FileOutputStream(fileCopy,true)) {
            int c;
            //byte[] buffer = new byte[10];
            //byte[] buffer = new byte[100];
            byte[] buffer = new byte[1000];
            while ((c = fileIn.read(buffer)) != -1) {
                fileOut.write(buffer,0,c);
            }
        } catch (Exception e) {
            System.out.println("error");
        }
    }
}

