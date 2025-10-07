import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

public class EjercicioFinalArrayPrueba{

    public static void main(String[] args){

        Metodos metodos = new Metodos();

        int opc;
        
        try(Scanner scan = new Scanner(System.in)){
            
            do{            
                System.out.println("\n=========SISTEMA DE ESTUDIANTES=========");
                System.out.println("1. AGREGAR ESTUDIANTES");
                System.out.println("2. MOSTRAR TODOS LOS ESTUDIANTES ");
                System.out.println("3. BUSCAR ESTUDIANTE POR NOMBRE"); 
                System.out.println("4. ACTUALIZAR CALIFICACIÓN");
                System.out.println("5. ELIMINAR ESTUDIANTE");
                System.out.println("6. MOSTRAR PROMEDIO GENERAL");
                System.out.println("7. MOSTRAR ESTUDIANTE CON MEJOR Y PEOR NOTA");
                System.out.println("8. SALIR");
                opc = scan.nextInt();
                scan.nextLine();
            
                switch(opc){
                    case 1: 
                        //AGREGAR ESTUDIANTES A LA LISTA
                        System.out.println("Ingrese el nombre del Estudiante");
                        String nombre_estudiantee = scan.nextLine();
                        System.out.println("Ingrese la nota del estudiante");
                        double nota_estudiante = scan.nextDouble();
                        scan.nextLine();

                        metodos.Agregar(nombre_estudiantee, nota_estudiante);
                        break;
                    case 2: 
                        //ESTUDIANTES INGRESADOS
                        System.out.println("\nEstudiantes");
                        metodos.Mostrar();
                        break;
                    case 3:
                        //BUSQUEDA DE ESTUDIANTE POR NOMBRE
                        
                        System.out.println("Alumno a buscar");
                        String nombre_buscqueda = scan.nextLine();
                        Estudiantee ee = metodos.Buscar(nombre_buscqueda);
                        if(ee != null){
                            System.out.println("Encontrado: " + ee.getNombre() + " ==== " + ee.getNota());
                        }
                        else{
                            System.out.println("No encontrado");
                        }

                        break;                   
                    case 4:
                    //ACTUALIZACION DE NOTA DE X ESTUDIANTE
                        System.out.println("Busque estudiante para actualizar nota");
                        String estudiante_actualizar = scan.nextLine();

                        System.out.println("Nueva nota");
                        double nota_nueva = scan.nextDouble();
                        scan.nextLine();

                        metodos.Actualizar(estudiante_actualizar, nota_nueva);

                        break;                
                    case 5:
                        //ELIMINACION DE ESTUDIANTE
                        System.out.println("\nELIMINACION DE ESTUDIANTE");
                        System.out.println("Escriba el nombre tal y como aparece en el sistema, para eliminar");
                        String eliminar_estudiante = scan.nextLine();

                        metodos.Eliminar(eliminar_estudiante);
                        

                        break;                    
                    case 6:
                        //PROMEDIO DE TODAS LAS NOTAS
                        System.out.println("\nPROMEDIO DE TODAS LAS NOTAS");
                        metodos.promedio();

                        break;                
                    case 7: 
                        //Mejor y peor
                        metodos.mejorpeor();
                        break;               
                    case 8:
                        break;
                
                }
            }while(opc != 8);
        
        
        }
    }

}

class Estudiantee{
    private String nombre;
    private double nota;

    public Estudiantee(String nombre, double nota){
        this.nombre = nombre;
        this.nota = nota;
    }

    public String getNombre(){
        return nombre;
    }

    public Double getNota(){
        return nota;
    }

    public void setNota(double nota){
        this.nota = nota;
    }
}

class Metodos{

    ArrayList<Estudiantee> lista = new ArrayList<>();

    public void Agregar(String nombre, double nota){
        lista.add(new Estudiantee(nombre, nota));
        System.out.println("Estudiante Agregado Correctamente");
    }

    public void Mostrar(){
        for(Estudiantee e : lista){
            System.out.println(e.getNombre() + "  ====  " + e.getNota());
        }
    }

    public Estudiantee Buscar(String nombre){
        
        for(Estudiantee e : lista){
            if(e.getNombre().equalsIgnoreCase(nombre)){
                return e;
            }
        }

        return null;
    }

    public void Actualizar(String nombre, double nueva_nota){
        Estudiantee lista_estudiante = Buscar(nombre);

        if(lista_estudiante != null){
            lista_estudiante.setNota(nueva_nota);
            System.out.println("Nota Actualizada");
        }else{
            System.out.println("Nota no Actualizada");
        }

    }

    public void Eliminar(String eliminar_nombre){
        Iterator<Estudiantee> estudiante_eliminar = lista.iterator();
        boolean persona_eliminada = false;

        while(estudiante_eliminar.hasNext()){
            Estudiantee e = estudiante_eliminar.next();
            if(e.getNombre().equalsIgnoreCase(eliminar_nombre)){
                estudiante_eliminar.remove();
                persona_eliminada = true;
            }
        }

        if(persona_eliminada){
            System.out.println("Persona eliminada");
        }
        else{
            System.out.println("Persona no eliminada");
        }
    }

    public void promedio(){
        if(lista.isEmpty()){
            System.out.println("No hay estudiantes");
            return;
        }

        double suma = 0.0;
        for(Estudiantee e : lista){
            suma += e.getNota();
        }

        double promedio = suma / lista.size();
        System.out.println(promedio);

    }

    public void mejorpeor(){
        double peor = lista.get(0).getNota();
        double mejor = lista.get(0).getNota();
        String mejor_alumno = lista.get(0).getNombre();
        String peor_alumno = lista.get(0).getNombre();

        for(Estudiantee e: lista){
            if(e.getNota() > mejor){
                mejor = e.getNota();
                mejor_alumno = e.getNombre();
            }
            else if(e.getNota() < peor){
                peor = e.getNota();
                peor_alumno = e.getNombre();
            }
        }

        System.out.println("Peor nota: " + peor_alumno + " === " + peor + "%");
        System.out.println("Mejor nota: " + mejor_alumno + " === " + mejor + "%");

    }

}

