""" Una implementación de un árbol de búsqueda binario. Utiliza la clase Nodo.java para generar los nodos.
@author: Víctor Bocanegra
@date: 27/03/2023


"""
public class Arbol {
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
        if (this.nodo_raiz == null){
            this.nodoRaiz = nodo;
            return this.nodoRaiz;
        } else {
            // Si ya existe una raíz, la tomamos como referencia temporal en la variable/nodo actual
            Nodo actual = this.nodoRaiz;
            Nodo padre = null;
            while(true){
                padre = actual;

            }
        }

    }
}
