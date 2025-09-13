/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionempleados;

/**
 *
 * @author osbaldorubiomorales
 */
public class ArbolBinario {
        Nodo raiz;

    public ArbolBinario() {
        this.raiz = null;
    }

    // Insertar nodo
    public void insertar(int id, String nombre) {
        raiz = insertarRec(raiz, id, nombre);
    }

    private Nodo insertarRec(Nodo nodo, int id, String nombre) {
        if (nodo == null) {
            return new Nodo(id, nombre);
        }
        if (id < nodo.id) {
            nodo.izq = insertarRec(nodo.izq, id, nombre);
        } else if (id > nodo.id) {
            nodo.der = insertarRec(nodo.der, id, nombre);
        }
        return nodo;
    }

    // Buscar nodo
    public Nodo buscar(int id) {
        return buscarRec(raiz, id);
    }

    private Nodo buscarRec(Nodo nodo, int id) {
        if (nodo == null || nodo.id == id) {
            return nodo;
        }
        if (id < nodo.id) {
            return buscarRec(nodo.izq, id);
        } else {
            return buscarRec(nodo.der, id);
        }
    }

    // Eliminar nodo
    public Nodo eliminar(int id) {
        Nodo[] eliminado = new Nodo[1];
        raiz = eliminarRec(raiz, id, eliminado);
        return eliminado[0];
    }

    private Nodo eliminarRec(Nodo nodo, int id, Nodo[] eliminado) {
        if (nodo == null) return null;

        if (id < nodo.id) {
            nodo.izq = eliminarRec(nodo.izq, id, eliminado);
        } else if (id > nodo.id) {
            nodo.der = eliminarRec(nodo.der, id, eliminado);
        } else {
            //Guardamos el nodo que sera eliminado
            eliminado[0] = new Nodo(nodo.id, nodo.nombre);
            
            // Caso 1: sin hijos
            if (nodo.izq == null && nodo.der == null) {
                return null;
            }
            // Caso 2: un hijo
            else if (nodo.izq == null) {
                return nodo.der;
            } else if (nodo.der == null) {
                return nodo.izq;
            }
            // Caso 3: dos hijos
            Nodo sucesor = minValue(nodo.der);
            // Guardamos el nodo original (el que realmente se pidió eliminar)
            if (eliminado[0] == null) {
                eliminado[0] = new Nodo(nodo.id, nodo.nombre);
            }

            // Copiamos los datos del sucesor al nodo actual
            nodo.id = sucesor.id;
            nodo.nombre = sucesor.nombre;

            // Eliminamos el sucesor en el subárbol derecho
            nodo.der = eliminarRec(nodo.der, sucesor.id, new Nodo[1]);
        }
        return nodo;
    }

    private Nodo minValue(Nodo nodo) {
        while (nodo.izq != null) {
            nodo = nodo.izq;
        }
        return nodo;
    }

    // Recorridos
    public void inorden(Nodo nodo) {
        if (nodo != null) {
            inorden(nodo.izq);
            System.out.println(nodo);
            inorden(nodo.der);
        }
    }

    public void preorden(Nodo nodo) {
        if (nodo != null) {
            System.out.println(nodo);
            preorden(nodo.izq);
            preorden(nodo.der);
        }
    }

    public void postorden(Nodo nodo) {
        if (nodo != null) {
            postorden(nodo.izq);
            postorden(nodo.der);
            System.out.println(nodo);
        }
    }
}
