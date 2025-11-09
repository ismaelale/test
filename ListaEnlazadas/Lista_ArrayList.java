import java.util.ArrayList;
import java.util.Scanner;

class Datos{
    String titulo;
    String autor;
    String anio;
    boolean disponible;
    Datos siguiente;

    Datos(String titulo, String autor, String anio){
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
        this.disponible = true;
        this.siguiente = null;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public Datos getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Datos siguiente) {
        this.siguiente = siguiente;
    }

    
}

class Dao{

    ArrayList<Datos> listadatos = new ArrayList<>();
    Datos datos;

    public void AddBooks(String name, String autor, String anio){

        Datos nuevo = new Datos(name, autor, anio);

        if(datos == null){
            datos = nuevo;
        }
        else{
            Datos actual = datos;
            while(actual.siguiente != null){
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
            System.out.println("SE AGREGO CORRECTAMENTE");
        }

    }

    public void ViewBook(){

        if(datos == null){
            System.out.println("LIST EMPTY");
            return;
        }else{
            Datos actual = datos;
            while(actual != null){
                System.out.println("Titulo:  " + actual.titulo + " -- Autor:  " + actual.autor + " -- Año: " + actual.anio + " --- Disponible: SI");
                actual = actual.siguiente;
            }
        }
    }

    public void LendBook(String book){

        if(datos == null){
            System.out.println("LIST EMPTY");
            return;
        }

        boolean encontrado = false;
        Datos actual = datos;
        while(actual != null){
            if(actual.titulo.equals(book)){
                encontrado = true;
                listadatos.add(actual);
            }
            actual = actual.siguiente;
        }

        if(encontrado){
            System.out.println("AGREGADO");
        }

    }

    public void ViewsBooksLend(){
        
        for(Datos d : listadatos){
            System.out.println(d.titulo + d.autor + d.anio);
        }
    }

    public void ReturnBoo(String book){

        if(listadatos.isEmpty()){
            System.out.println("LIST EMPTY");
            return;
        }

        boolean encontrado = false;

        for(int i = 0; i < listadatos.size(); i++){
            Datos actual = listadatos.get(i);
            if(actual.titulo.equals(book)){
                actual.setDisponible(false);
                encontrado = true;
                listadatos.remove(i);
                System.out.println("LIBRO DEVUELTO");
            }
        }

        if(!encontrado){
            System.out.println("NO ENCONTRADO");
        }



    }

    public void LookForBook(String books){

        if(datos == null){
            System.out.println("ESTA VACIA");
            return;
        }

        boolean encontrado = false;
        Datos actual = datos;
        while(actual != null){
            if(actual.titulo.equals(books)){
                encontrado = true;
                System.out.println(actual.titulo + " - " + actual.autor + " - " + actual.anio);
            }   
            actual = actual.siguiente;
        }

        if(!encontrado){
            System.out.println("NO ENCONTRADO");
        }

    }

}

public class Lista_ArrayList{
    public static void main(String[] args){

        try(Scanner scan = new Scanner(System.in)){
            int opc;
            Dao dao = new Dao();
            do{
                System.out.println("\t\nSISTEMA DE BIBLIOTECA");
                System.out.println("1. BOOKS ADD");
                System.out.println("2. VIEWS BOOKS");
                System.out.println("3. Lend Book");
                System.out.println("4. View Book Lend");
                System.out.println("5. Return book");
                System.out.println("6. Look for book");
                opc = scan.nextInt();
                scan.nextLine();

                switch(opc){
                    case 1 -> {
                        System.out.println("\t\nBOOKS ADD");
                        System.out.println("NAME BOOK");
                        String name = scan.nextLine();
                        System.out.println("BOOK AUTOR");
                        String autor = scan.nextLine();
                        System.out.println("YEAR BOOK");
                        String year = scan.nextLine();
                        dao.AddBooks(name, autor, year);
                        break;
                    }
                    case 2 -> {
                        System.out.println("\t\nVIEWS BOOK");
                        dao.ViewBook();
                        break;
                    }
                    case 3 ->{
                        System.out.println("\t\nPRESTAR LIBRO");
                        System.out.println("LOOK FOR THE TITULE");
                        dao.ViewBook();
                        String name = scan.nextLine();
                        dao.LendBook(name);
                        break;                
                    }
                    case 4 ->{
                        System.out.println("\t\nVIEW BOOK LEND");
                        dao.ViewsBooksLend();
                        break;
                    }
                    case 5 ->{
                        System.out.println("\t\nRETURN BOOK");
                        System.out.println("TITULE BOOK");
                        dao.ViewsBooksLend();
                        String book = scan.nextLine();
                        dao.ReturnBoo(book);
                        break;
                    }
                    case 6 ->{
                        System.out.println("\t\nLOOK FOR BOOK");
                        System.out.println("Titule");
                        String book = scan.nextLine();
                        dao.LookForBook(book);
                        break;
                    }
                }

            }while(opc != 7);

        }


    }
}