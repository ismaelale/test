import java.util.LinkedList;
import java.util.List;

class Persona{

    int indice;
    String nombre;
    int edad;

    Persona(int indice, String nombre, int edad){
        this.indice = indice;
        this.nombre = nombre;
        this.edad = edad;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    

}

public class LinkedListPractica{
    public static void main(String[] args){

        List<Persona> lista = new LinkedList<>();

        lista.add(new Persona(1, "Juan", 30));
        lista.add(new Persona(2, "Pedro", 30));

        lista.add(0, new Persona(3, "Ismael", 22));

        for(Persona p : lista){
            System.out.println(p.getEdad() + " " + p.getNombre() + " " + p.getIndice());
        }
    }
}