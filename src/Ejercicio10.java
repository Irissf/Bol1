import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

//Fallo, no funciona el readFile, no llega a entrar en el try pero si en la funcion

public class Ejercicio10 {
    public void ejer10(File file) {

        File fileIn = new File(file + "/empresa.dat");
        File fileCopy = new File(file + "/EmpresaCopia.Dat");

        ArrayList<ADepart> departs = new ArrayList<>();
        ArrayList<APersona> people = new ArrayList<>();

        departs.add(new ADepart(11, "Finanzas"));
        departs.add(new ADepart(15, "Marketing"));
        people.add(new APersona("444", "Oscar", 11));
        people.add(new APersona("333", "Pepe", 15));
        people.add(new APersona("111", "Sofia", 14));
        people.add(new APersona("322", "Lara", 13));

        // introduceObjectsFirst(fileIn, departs, people);
        // try {
        //     addObjectsNews(fileIn);
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }
        // deleteRegister(fileIn, fileCopy, 15);
        readFile(fileIn);
        
    }

    public void introduceObjectsFirst(File file, ArrayList<ADepart> departs, ArrayList<APersona> people) {

        try (FileOutputStream fos = new FileOutputStream(file); ObjectOutputStream out = new ObjectOutputStream(fos)) {
            for (APersona aPersona : people) {
                out.writeObject(aPersona);
            }
            for (ADepart aDepart : departs) {
                out.writeObject(aDepart);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addObjectsNews(File file) throws Exception {
        // https://es.stackoverflow.com/questions/45694/como-anexar-objectos-con-objectoutputstream-sin-borrar-contenido-fichero
        ObjectOutputStream out = null;

        try (FileOutputStream fos = new FileOutputStream(file, true)) {
            
            if (file.length() == 0) {
                out = new ObjectOutputStream(fos);
            } else {
                System.out.println("entro");
                out = new AppendingObjectOutputStream(fos);
            }

            out.writeObject(new APersona("1234", "karra", 344));
            out.writeObject(new ADepart(33, "tecno"));

        } finally {
            if (out != null) {
                out.close();
            }
        }

    }

    public void readFile(File file) {

        try (FileInputStream fis = new FileInputStream(file); ObjectInputStream ois = new ObjectInputStream(fis)) {
            ADepart depart;
            APersona persona;
            while (true) { //no entra aqui
                
                Object obj = ois.readObject();
                if (obj.getClass() == ADepart.class) { 
                   
                    depart = (ADepart) obj;
                    System.out.println("Departamento: " + depart.getNombre() + " con id: " + depart.getId());
                } else {
                    
                    persona = (APersona) obj;
                    System.out.println("Trabajador: " + persona.getNombre() + " con id: " + persona.getId() + " dni: "
                            + persona.getDni());
                }
            }

        } catch (IOException e) {
            System.out.println("fin del archivo");
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void deleteRegister(File file,File fileCopy, int id){
        ObjectOutputStream os = null;
        try (FileInputStream fis = new FileInputStream(file);ObjectInputStream ois = new ObjectInputStream(fis); 
            FileOutputStream fos = new FileOutputStream(fileCopy,true);){
            ADepart depart;
            APersona persona;

            if (file.length() == 0) {
                os = new ObjectOutputStream(fos);
            } else {
                System.out.println("entro");
                os = new AppendingObjectOutputStream(fos);
            }

            while (true) {
                Object obj = ois.readObject();
                if (obj.getClass() == ADepart.class) {
                    depart = (ADepart) obj;
                   if(depart.getId() != id){
                        os.writeObject(depart);
                   }
                } else {
                    persona = (APersona) obj;
                    if(persona.getId() != id){
                        os.writeObject(persona);
                   }             
                }
            }
        }catch(IOException e){
            System.out.println("Fin del fichero");
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            file.delete();
            fileCopy.renameTo(new File(file.getPath()));
        }
    }
}
