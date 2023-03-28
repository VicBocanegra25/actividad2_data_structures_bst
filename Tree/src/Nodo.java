/* Una implementación de la clase Nodo, que nos permitirá almacenar los elementos del árbol de búsqueda binario.
@date: 27/03/2023
@author: Víctor Bocanegra

*/

public class Nodo{

    int dato;
    Nodo hijoDerecho, hijoIzquierdo;

    // La clase Nodo almacena un dato y las referencias a los nodos hijos (derecho e izquierdo)
    public Nodo(int _dato){
        // Este es el constructor inicial del nodo, recibe un entero como dato
        this.dato = _dato;
        // El propio nodio tiene referencias a los nodos hijos, pero inicialmente se colocan como punteros nulos
        this.hijoDerecho = null;
        this.hijoIzquierdo = null;

    }
}