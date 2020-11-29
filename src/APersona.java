import java.io.Serializable;

public class APersona implements Serializable{
    private String nombre;
    private int id;
    private String dni;

    public APersona(String dni, String nombre, int id){
        setDni(dni);
        setNombre(nombre);
        setId(id);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
}
