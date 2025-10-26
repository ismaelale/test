import java.util.Scanner;

class Nodo {
    int valor;
    Nodo siguiente;

    Nodo(int valor) {
        this.valor = valor;
        this.siguiente = null;
    }
}

public class Nodo2Ejemplo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Nodo cabeza = null; // inicio de la lista
        int opcion;

        do {
            System.out.println("\n--- MENÚ LISTA ENLAZADA ---");
            System.out.println("1. Agregar número");
            System.out.println("2. Mostrar lista");
            System.out.println("3. Buscar número");
            System.out.println("4. Eliminar número");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scan.nextInt();

            switch (opcion) {
                case 1 -> {
                    System.out.print("Ingrese número a agregar: ");
                    int num = scan.nextInt();
                    Nodo nuevo = new Nodo(num);

                    if (cabeza == null) {
                        cabeza = nuevo; // primer nodo
                    } else {
                        Nodo actual = cabeza;
                        while (actual.siguiente != null) {
                            actual = actual.siguiente;
                        }
                        actual.siguiente = nuevo; // lo conecta al final
                    }
                    System.out.println("Número agregado correctamente.");
                }

                case 2 -> {
                    if (cabeza == null) {
                        System.out.println("La lista está vacía.");
                    } else {
                        Nodo actual = cabeza;
                        System.out.print("Contenido: ");
                        while (actual != null) {
                            System.out.print(actual.valor + " -> ");
                            actual = actual.siguiente;
                        }
                        System.out.println("null");
                    }
                }

                case 3 -> {
                    System.out.print("Ingrese número a buscar: ");
                    int buscado = scan.nextInt();
                    Nodo actual = cabeza;
                    boolean encontrado = false;

                    while (actual != null) {
                        if (actual.valor == buscado) {
                            encontrado = true;
                            break;
                        }
                        actual = actual.siguiente;
                    }

                    if (encontrado)
                        System.out.println("Número encontrado en la lista.");
                    else
                        System.out.println("Número no encontrado.");
                }

                case 4 -> {
                    System.out.print("Ingrese número a eliminar: ");
                    int eliminar = scan.nextInt();

                    if (cabeza == null) {
                        System.out.println("Lista vacía.");
                    } else if (cabeza.valor == eliminar) {
                        cabeza = cabeza.siguiente;
                        System.out.println("Primer elemento eliminado.");
                    } else {
                        Nodo actual = cabeza;
                        while (actual.siguiente != null && actual.siguiente.valor != eliminar) {
                            actual = actual.siguiente;
                        }

                        if (actual.siguiente != null) {
                            actual.siguiente = actual.siguiente.siguiente;
                            System.out.println("Elemento eliminado.");
                        } else {
                            System.out.println("Número no encontrado.");
                        }
                    }
                }

                case 5 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción inválida.");
            }

        } while (opcion != 5);

        scan.close();
    }
}
