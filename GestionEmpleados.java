/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestionempleados;
import java.util.Scanner;
/**
 *
 * @author osbaldorubiomorales
 */
public class GestionEmpleados {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        ArbolBinario arbol = new ArbolBinario();

        // Lista de empleados (ID, Nombre)
        int[][] empleados = {
            {50, 0}, {30, 0}, {70, 0}, {20, 0}, {40, 0}, {60, 0}, {80, 0}
        };
        String[] nombres = {"Ana", "Luis", "María", "Carlos", "Sofía", "Pedro", "Lucía"};

        for (int i = 0; i < empleados.length; i++) {
            arbol.insertar(empleados[i][0], nombres[i]);
        }
        int opcion;
        do{
            System.out.println("----Menu de opciones----\n"
                    + "0. Insertar\n"
                    + "1. Buscar\n"
                    + "2. Eliminar\n"
                    + "3. Recorrido en INORDEN\n"
                    + "4. Recorrido en PREORDEN\n"
                    + "5. Recorrido en POSTORDEN\n"
                    + "6. Salir");
        
            System.out.print("Seleccione una opcion: ");
                opcion = scanner.nextInt();
                scanner.nextLine();
        
            switch (opcion) {
                case 0:
                    //Insercion de nuevo empleado
                    System.out.print("\nIngrese el ID del nuevo empleado: ");
                    int nuevoId = scanner.nextInt();
                    scanner.nextLine(); // limpiar buffer
                    System.out.print("Ingrese el nombre del empleado: ");
                    String nuevoNombre = scanner.nextLine();
                    arbol.insertar(nuevoId, nuevoNombre);
                    System.out.println("Empleado agregado -> ID: " + nuevoId + ", Nombre: " + nuevoNombre);
                    break;
                case 1:
                    // Búsqueda
                    System.out.println("\nIngresa el ID a buscar: ");
                    int idEmpleado = scanner.nextInt();
                    Nodo resultado = arbol.buscar(idEmpleado);
                    System.out.println(resultado != null ? resultado : "No encontrado");
                    break;
            
                case 2:
                    // Eliminación
                    System.out.println("\nIngrese el ID a eliminar: ");
                    int id = scanner.nextInt();
                    Nodo eliminado = arbol.eliminar(id);
                    if (eliminado != null) {
                           System.out.println("Empleado eliminado -> " + eliminado);
                    } else {
                        System.out.println("No se encontró ningún empleado con ese ID.");
                    }
                    break;
                    
                    
                case 3:
                    System.out.println("Recorrido INORDEN (ordenado):");
                    arbol.inorden(arbol.raiz);
                    break;
                    
                case 4:
                    System.out.println("\nRecorrido PREORDEN:");
                    arbol.preorden(arbol.raiz);
                    break;
                    
                case 5:
                     System.out.println("\nRecorrido POSTORDEN:");
                     arbol.postorden(arbol.raiz);
                     break;
                     
                case 6:
                    System.out.println("Saliendo del sistema....");
                    break;
                    
                default:
                    System.out.println("Opcion invalida");
                    
            }
        }while (opcion !=6);
        
        scanner.close();
                        
    }
}
    

