import java.util.Scanner;

import java.util.Iterator;

import java.util.ArrayList;

public class Ejercicio3ArrayPrueba{
    public static void main(String[] args){

        int opc;
        Gestiones_Empleado gestion_empleado = new Gestiones_Empleado();

        try(Scanner scan = new Scanner(System.in)){

            do{
                System.out.println("\nEMPLOYEE SYSTEM");
                System.out.println("=========================MAIN MENU=========================");
                System.out.println("1. Add Employee");
                System.out.println("2. Show Employees");
                System.out.println("3. Look For Employees");
                System.out.println("4. Update Employees");
                System.out.println("5. Delete Employees");
                System.out.println("6. General Summary");
                System.out.println("7. Exit");
                opc = scan.nextInt();
                scan.nextLine();

                switch(opc){

                    case 1 ->{
                        System.out.println("Enter coding Employee");
                        int coding_employee = scan.nextInt();
                        scan.nextLine();
                        System.out.println("Enter Employee_ ");
                        String name_employee = scan.nextLine();
                        System.out.println("Enter Position Employee");
                        String position = scan.nextLine();
                        System.out.println("Enter Salary");
                        double salary = scan.nextDouble();
                        scan.nextLine();
                        gestion_empleado.Employee_Add(coding_employee, name_employee, position, salary);
                        break;
                    }
                    case 2 ->{
                        gestion_empleado.Show_Employee();
                        break;
                    }
                    case 3 ->{
                        System.out.println("\nLOOK FOR EMPLOYEE");
                        int coding = scan.nextInt();
                        scan.nextLine();
                        Empleado empleado = gestion_empleado.LookFor_Employee(coding);
                        System.out.println("Coding Employee : " + empleado.getCodigo_empleado());
                        System.out.println("Name Employee : " + empleado.getNombre_empleado());
                        System.out.println("Position : " + empleado.getCargo_empleado());
                        System.out.println("Salary : " + empleado.getSalario_empleado());
                        break;
                    }
                    case 4 ->{

                        String new_position = "";
                        double new_salary = 0.0;
                        
                        System.out.println("\nACTUALIZACION");
                        System.out.println("Codigo del empleado");
                        int coding = scan.nextInt();
                        scan.nextLine();
                        System.out.println("Que desea actualizar, (Cargo o Salario)");
                        String decision = scan.nextLine();

                        if(decision.equalsIgnoreCase("Cargo")){
                            System.out.println("Enter New position");
                            new_position = scan.nextLine();
                            gestion_empleado.Update_Employee(coding, new_position, new_salary, decision);
                        }else if(decision.equalsIgnoreCase("Salario")){
                            System.out.println("Enter new Salary");
                            new_salary = scan.nextDouble();
                            scan.nextLine();
                            gestion_empleado.Update_Employee(coding, new_position, new_salary, decision);
                        }
                        break;

                    }   
                    case 5 ->{
                        System.out.println("ELIMINAR EMPLEADO");
                        System.out.println("INGRESE EL CODIGO DE USUARIO");
                        int coding = scan.nextInt();
                        scan.nextLine();
                        gestion_empleado.Delete_Employee(coding);
                        break;
                    }
                    case 6 ->{

                    }
                    
                    default -> {
                        System.out.println("ENTER VALID DATA");
                        break;
                    }
                    
                }



            }while(opc != 7);

            


        }//final del try

    }
}

class Empleado{

    private int codigo_empleado;
    private String nombre_empleado;
    private String cargo_empleado;
    private double salario_empleado;
    
    public Empleado(int codigo_empleado, String nombre_empleado, String cargo_empleado, double salario_empleado) {
        this.codigo_empleado = codigo_empleado;
        this.nombre_empleado = nombre_empleado;
        this.cargo_empleado = cargo_empleado;
        this.salario_empleado = salario_empleado;
    }

    public int getCodigo_empleado() {
        return codigo_empleado;
    }

    public String getNombre_empleado() {
        return nombre_empleado;
    }

    public String getCargo_empleado() {
        return cargo_empleado;
    }

    public double getSalario_empleado() {
        return salario_empleado;
    }

    public void setCargo_empleado(String cargo_empleado) {
        this.cargo_empleado = cargo_empleado;
    }

    public void setSalario_empleado(double salario_empleado) {
        this.salario_empleado = salario_empleado;
    }

    

    

}

class Gestiones_Empleado{

    ArrayList<Empleado> lista_empleado = new ArrayList<>();

    public void Employee_Add(int coding_used, String employee_name, String employeed_position, double salary_employee){
        lista_empleado.add(new Empleado(coding_used, employee_name, employeed_position, salary_employee));
        System.out.println("Agregado");
    }

    public void Show_Employee(){

        if(lista_empleado.isEmpty()){
            System.out.println("NO DATA ENTERED");
            return;
        }

        for(Empleado empleado : lista_empleado){
            System.out.println("Coding : "  + empleado.getCodigo_empleado());
            System.out.println("Name : "  + empleado.getNombre_empleado());
            System.out.println("Position : "  + empleado.getCargo_empleado());
            System.out.println("Salary : "  + empleado.getSalario_empleado());
        }

    }

    public Empleado LookFor_Employee(int coding_used){

        if(lista_empleado.isEmpty())
        {
            System.out.println("LA LISTA ESTA VACÍA");
            return null;
        }

        for(Empleado empleado : lista_empleado){
            if(empleado.getCodigo_empleado() == coding_used){
                return empleado;
            }
        }

        return null;
    } 

    public void Update_Employee(int coding_used, String new_position, double new_salary, String decision){
        if(lista_empleado.isEmpty()){
            System.out.println("LISTA VACÍA");
            return;
        }

        for(Empleado empleado : lista_empleado){
            if(empleado.getCodigo_empleado() == coding_used){
                if(decision.equalsIgnoreCase("Cargo")){
                    empleado.setCargo_empleado(new_position);
                    System.out.println("Actualizado");
                }
                else if(decision.equalsIgnoreCase("Salario")){
                    empleado.setSalario_empleado(new_salary);
                    System.out.println("Actualizado");
                }
            }else{
                System.out.println("NO ACTUALIZADO");
            }
        }

    }

    public void Delete_Employee(int coding_used){
        Iterator<Empleado> empleado_eliminado = lista_empleado.iterator();
        boolean persona_eliminada = false;

        if(lista_empleado.isEmpty()){
            System.out.println("LISTA ESTA VACÍA");
            return;
        }

        while(empleado_eliminado.hasNext()){
            Empleado empleado = empleado_eliminado.next();
            if(empleado.getCodigo_empleado() == coding_used){
                persona_eliminada = true;
                empleado_eliminado.remove();
            }
        }

        if(persona_eliminada){
            System.out.println("SE HA ELIMINADO EXITOSAMENTE");
        }
        else{
            System.out.println("NO SE HA ELIMINADO");
        }

    }

    public void General_Summary(){

    }



}
