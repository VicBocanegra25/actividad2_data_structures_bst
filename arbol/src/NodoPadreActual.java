/* Una clase auxiliar que nos servirá para almacenar la tupla de nodos Padre/Hijo.
* Esta clase es necesaria porque al momento de eliminar un nodo, se requiere la referencia al nodo padre del que se va a
* eliminar. Debido a la naturaleza de los ABB, se requiere un sucesor siempre que se elimine un nodo con hijos.
* */
public class NodoPadreActual{
    public Nodo padre;
    public Nodo actual;

    public NodoPadreActual(Nodo padre, Nodo actual){
        this.padre = padre;
        this.actual = actual;
    }
}
