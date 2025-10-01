import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayList;

public class OrdenamientoPila7{
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        Stack<Libro> pila = new Stack<>();
        ArrayList<Libro> lista = new ArrayList<>();

        System.out.println("ESCRIBA FIN PARA FINALIZAR");

        while(true){
            System.out.println("\nESCRIBA EL TITULO DEL LIBRO: ");
            String titulo = scan.nextLine();

            if(titulo.equalsIgnoreCase("FIN")){
                break;
            }

            System.out.println("ESCRIBA EL AUTOR DEL LIBRO : " + titulo);
            String autor = scan.nextLine();

            pila.push(new Libro(titulo, autor));
        }

        System.out.println("\nAQUÍ SE MUESTRA LA PILA DE LOS AUTORES CON SUS RESPECTIVOS LIBROS: \n");
        for(Libro l : pila){
            System.out.println("Titulo: " + l.getTitulo() + " - Autor: " + l.getAutor());
        }


        //SACAREMOS EL CONTENIDO DE LA PILA PARA PASARLO A LA LISTA
        while(!pila.isEmpty()){
            lista.add(pila.pop());
        } 

        //ORDENAR LOS LIBROS ALFABETICAMENTE
        for(int i = 0; i < lista.size() - 1; i++){
            for(int j = 0; j < lista.size() - 1 - i; i++){
                if(lista.get(j).getAutor().compareTo(lista.get(j + 1).getAutor()) > 0){
                    Libro l = lista.get(j);
                    lista.set(j, lista.get(j + 1));
                    lista.set(j + 1, l);
                }
            }
        }

        System.out.println("\nLIBROS ORDENADOS ALFABETICAMENTE");
        for(Libro l : lista){
            System.out.println(l.getTitulo() + " - " + l.getAutor());
        }


    }
}

class Libro{
    private String titulo;
    private String autor;

    public Libro(String titulo, String autor){
        this.titulo = titulo;
        this.autor = autor;
    }

    public String getTitulo(){
        return titulo;
    }

    public String getAutor(){
        return autor;
    }
}