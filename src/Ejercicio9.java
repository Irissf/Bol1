import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//https://www.youtube.com/watch?v=UxkYNqbt_hg
//https://www.youtube.com/watch?v=rbbs8F3N0Wg

public class Ejercicio9 {

    public void ejer9(File file) {
        try {
            File fileNew = new File(file + "/alumnosCopia.dat");
            File fileOld = new File(file + "/alumnos.dat");
            actionsRealizeInFileData(1, fileNew, fileOld);
            actionsRealizeInFileData(4, fileNew, fileOld);
            actionsRealizeInFileData(2, fileNew, fileOld);

        } catch (EOFException e) {
            System.out.println("fin del archivo");
        } catch (Exception e) {
            System.err.println("Error");
        }
    }

    public void actionsRealizeInFileData(int option, File fileNew, File fileOld) throws IOException {

        String nombre = "alumno";
        String fecha = "198";
        String codigo = "10";

        switch (option) {
            case 1:

                for (int i = 0; i < 10; i++) {
                    try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileOld, true))) {
                        // (file + "/alumnos.dat", true)para que añada a continuación y no borra
                        // escritura de datos
                        dos.writeUTF(nombre + i);
                        dos.writeInt(Integer.parseInt(fecha + i));
                        dos.writeInt(Integer.parseInt(codigo + i));
                    }
                }

                break;
            case 2:
                try (DataInputStream dis = new DataInputStream(new FileInputStream(fileOld))) {
                    while (true) {
                        System.out.printf("%s año %d con codigo %d\n", dis.readUTF(), dis.readInt(), dis.readInt());
                    }
                }
                // break;
            case 3:
                try {
                    deleteOrChangeRegister(fileNew, fileOld, true);
                } catch (Exception e) {
                    System.out.println("Error");
                }
                

            case 4:
                try {
                    deleteOrChangeRegister(fileNew, fileOld, false);
                } catch (Exception e) {
                    System.out.println("Error");
                }
                break;

            default:
                break;
        }

    }

    public void deleteOrChangeRegister(File fileNew, File fileOld, boolean option) throws Exception {

        String name = "";
        String date = "";
        String code = "";
        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileOld));
                DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileNew, true))) {
            while (true) {
                // probar a meter directamente el valor en la escritura
                name = dis.readUTF();
                date = Integer.toString(dis.readInt());
                code = Integer.toString(dis.readInt());
                if (Integer.parseInt(code) == 103) {
                    if (option) {
                        code = "666";
                        dos.writeUTF(name);
                        dos.writeInt(Integer.parseInt(date));
                        dos.writeInt(Integer.parseInt(code));
                    }
                } else {
                    dos.writeUTF(name);
                    dos.writeInt(Integer.parseInt(date));
                    dos.writeInt(Integer.parseInt(code));
                }

            }
        } catch (EOFException e) {
            fileOld.delete();
            fileNew.renameTo(new File(fileOld.getPath()));
        }

    }

}
