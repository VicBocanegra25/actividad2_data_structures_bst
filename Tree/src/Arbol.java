/*
Una implementación de un árbol de búsqueda binario. Utiliza la clase Nodo.java para generar los nodos.
@author: Víctor Bocanegra
@date: 27/03/2023
*/


import java.lang.reflect.Array;
import java.util.ArrayList;

public class Arbol {
    Nodo nodoRaiz;
    // El constructor del árbol guarda una referencia al nodo raíz
    public Arbol(){
        // La referencia inicial es un puntero nulo
        this.nodoRaiz = null;
    }

    /* La operación insertar() nos sirve para agregar nuevos elementos al árbol. Para respetar las propiedades de un
    árbol de búsqueda, la operación de insertar compara el nuevo elemento con los ya existentes.
    Si el elemento es mayor, lo inserta a la derecha, de lo contrario, lo hacia la izquierda.
    @params:
        int _dato: El valor que contendrá el nuevo nodo a insertar
    @returns:
        Nodo: Nos regresa el nuevo nodo que acabamos de insertar
    * */
    public Nodo insertar(int _dato){
        // Generamos el nuevo nodo con el argumento que recibió la función
        Nodo nodo = new Nodo(_dato);
        // Revisamos si el árbol ya cuenta con una raíz, si no es así, este nodo se convertirá en el nodo raíz.
        if (this.nodoRaiz == null){
            this.nodoRaiz = nodo;
            return nodo;
        } else {
            // Si ya existe una raíz, la tomamos como referencia temporal en la variable/nodo actual
            Nodo actual = this.nodoRaiz;
            Nodo padre = null;
            // Recorremos el nodo hasta llegar al último nodo hijo y encontramos la posición para insertarlo
            while(true){
                padre = actual;
                // Si el valor del nuevo nodo es más pequeño que el padre, va a la izquierda
                if (nodo.dato < padre.dato){
                    actual = actual.hijoIzquierdo;
                    // Si hemos llegado a un nodo hoja, el nuevo nodo se convertirá en el hijo izquierdo del nodo actual
                    if (actual == null){
                        padre.hijoIzquierdo = nodo;
                        return nodo;
                    }
                } else {
                    actual = actual.hijoDerecho;
                    // Mismo caso, llegamos a un nodo hoja, pero debemos insertar el nuevo nodo a la derecha
                    if (actual == null){
                        padre.hijoDerecho = nodo;
                        return nodo;
                    }
                }

            }
        }

    }

    /* La operación inorder() realiza un recorrido siguiendo el patrón izquierdo, raíz, derecho
    * Utiliza una estrategia recursiva para realizar el recorrido.
    @params:
        nodoRaiz: La raíz del árbol que vamos a recorrer
    @ returns
        ArrayList: Un array con los elementos del árbol en inorder
    * */
    public ArrayList inorder(Nodo _nodoRaiz){
        ArrayList lista = new ArrayList();
        // Nos servirá como referencia para recorrer el árbol
        Nodo actual = _nodoRaiz;
        // Si el árbol está vacío, no hay elementos qué imprimir
        if (actual == null){
            return lista;
        }
        // Llamamos de forma recursiva primero al hijo izquierdo
        inorder(actual.hijoIzquierdo);
        lista.add(actual.dato);
        System.out.println(actual.dato);
        // Una vez que terminamos con el izquierdo, hacemos recursión con el derecho
        inorder(actual.hijoDerecho);

        return lista;
    }
}
