import java.rmi.StubNotFoundException;
import java.util.ArrayList;
import java.util.List;

class Libros{

    String nombre_libro;
    String autor_libro;

    Libros(String nombre_libro, String autor_libro){
        this.nombre_libro = nombre_libro;
        this.autor_libro = autor_libro;
    }

    public String getNombre_libro() {
        return nombre_libro;
    }

    public String getAutor_libro() {
        return autor_libro;
    }
}

class Usuario{

    Usuario siguientee;
    String nombre_usuario;
    ArrayList<Libros> lista_libros;

    Usuario(String nombre_usuario){
        this.nombre_usuario = nombre_usuario;
        this.lista_libros = new ArrayList<>();
        this.siguientee = null;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public ArrayList<Libros> getLista_libros() {
        return lista_libros;
    }



}

class Biblioteca{

    Usuario cabeza;
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    List<Libros> lista_libros = new ArrayList<>();

    //AGREAGR LIBROS A LA LISTA
    public void AgregarLibros(String nombre_libro, String autor_libro){
        Libros libros_agregados = new Libros(nombre_libro, autor_libro);
        lista_libros.add(libros_agregados);
    }

    //VER LISTA DE LIBROS
    public void VerLibros(){

        for(Libros l : lista_libros){
            System.out.println();
            System.out.println(l.nombre_libro);
            System.out.println(l.autor_libro);
            System.out.println();
        }

    }


    //PRESTAR LIBROS A USUARIOS
    public void AgregarUsuarios(String nombre_libro, String nombre_usuario){

        if(lista_libros.isEmpty()){
            System.out.println("NO HAY LIBROS");
            return;
        }

        boolean libro_encontrado = false;

        for(Libros l : lista_libros){
            if(l.getNombre_libro().equalsIgnoreCase(nombre_libro)){

                libro_encontrado = true;

                Usuario usuario_nuevo = new Usuario(nombre_usuario);
                usuario_nuevo.getLista_libros().add(l);
                usuarios.add(usuario_nuevo);

                if(cabeza == null){
                    cabeza = usuario_nuevo;
                }
                else{
                    Usuario actual = cabeza;
                    while(actual.siguientee != null){
                        actual = actual.siguientee;
                    }
                    actual.siguientee = usuario_nuevo;
                }
                System.out.println("Agregado");
            }
        }

        if(!libro_encontrado){
            System.out.println("NO ENCONTRADO");
            return;
        }

    }

    public void ListaEstudiantesAgregados(){
        for(Usuario u : usuarios){
            System.out.println();
            System.out.println(u.nombre_usuario);
            for(Libros l : u.lista_libros){
                System.out.println(l.nombre_libro);
            }
            System.out.println();
        }
    }

    public void DevolverLibro(String nombre_usuario, String nombre_libro){

        Usuario actual = cabeza;
        Usuario anterior = null;
        boolean usuario_encontrado = false;

        while(actual != null){
            if(actual.getNombre_usuario().equalsIgnoreCase(nombre_usuario)){

                usuario_encontrado = true;
                

                Libros libro_eliminar = null;
                for(Libros l : actual.lista_libros){
                    if(l.nombre_libro.equals(nombre_libro)){
                        libro_eliminar = l;
                        break;
                    }
                }

                if(libro_eliminar != null){
                    actual.lista_libros.remove(libro_eliminar);

                    if(anterior == null){
                        cabeza = actual.siguientee;
                    }else{
                        anterior.siguientee = actual.siguientee;
                    }

                    usuarios.removeIf(u -> u.getNombre_usuario().equalsIgnoreCase(nombre_usuario));

                }

                

            }

            anterior = actual;
            actual = actual.siguientee;
            
        }


        if(!usuario_encontrado){
            System.out.println("ALUMNO NO ENCONTRADO");
        }

    }



}

public class LinkedListPractica3{
    public static void main(String[] args){
        
        Biblioteca b = new Biblioteca();
        b.AgregarLibros("ME IMPORTA", "MAQUIAVELO");
        b.AgregarLibros("ESTOICISMO", "ARISTOTELES");
        b.AgregarLibros("PENSAR", "SOCRATES");
        b.AgregarLibros("PENSAMIENTO", "PLATON");

        b.VerLibros();
        b.AgregarUsuarios("ME IMPORTA", "ISMAEL");
        b.AgregarUsuarios("PENSAMIENTO", "CRIS");
        b.ListaEstudiantesAgregados();

        b.DevolverLibro("ISMAEL", "ME IMPORTA");
        System.out.println();
        System.out.println("LISTA ACTUALIZADA");
        b.ListaEstudiantesAgregados();
    }
}