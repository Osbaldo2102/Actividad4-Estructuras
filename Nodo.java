/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionempleados;

/**
 *
 * @author osbaldorubiomorales
 */
public class Nodo {
    int id;
    String nombre;
    Nodo izq, der;

    public Nodo(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.izq = this.der = null;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nombre: " + nombre;
    }
}
