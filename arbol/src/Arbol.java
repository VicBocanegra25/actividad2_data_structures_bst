/*
Una implementación de un árbol de búsqueda binario. Utiliza la clase Nodo.java para generar los nodos.
Se implementan operaciones de inserción, borrado, tres recorridos (inorder, preorder, postorder) e impresión.
@author: Víctor Bocanegra
@date: 27/03/2023
*/


import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

/* Nuestra clase principal se construye utilizando nodos.
Adicionalmente, se guarda la propiedad nodoRaiz para mantener registro de la raíz del árbol durante las operaciones.
Debido a las especificaciones, durante el recorrido NO se imprime el contenido del árbol, por lo que se agregan arrays
que contendrán los elementos en el orden solicitado.
* */
public class Arbol {
    Nodo nodoRaiz;
    ArrayList<Integer> inorder = null;
    ArrayList<Integer> preorder = null;
    ArrayList<Integer> postorder = null;
    // El constructor del árbol guarda una referencia al nodo raíz
    public Arbol(){
        // La referencia inicial es un puntero nulo
        this.nodoRaiz = null;
        // Iniciamos nuestros arrays vacíos
        this.inorder = new ArrayList<Integer>();
        this.preorder = new ArrayList<Integer>();
        this.postorder = new ArrayList<Integer>();
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
    public ArrayList<Integer> inorder(Nodo _nodoRaiz){
        // Nos servirá como referencia para recorrer el árbol
        Nodo actual = _nodoRaiz;
        // Si el árbol está vacío, no hay elementos qué imprimir
        if (actual == null){
            return this.inorder;
        }
        // Llamamos de forma recursiva primero al hijo izquierdo
        inorder(actual.hijoIzquierdo);
        // Y agregamos el contenido a la lista global
        this.inorder.add(actual.dato);
        // Una vez que terminamos con el izquierdo, hacemos recursión con el derecho
        inorder(actual.hijoDerecho);

        return this.inorder;
    }
    /* La operación preorder() realiza un recorrido siguiendo el patrón raíz, izquierdo, derecho
    * Utiliza una estrategia recursiva para realizar el recorrido.
    @params:
        nodoRaiz: La raíz del árbol que vamos a recorrer
    @ returns
        ArrayList: Un array con los elementos del árbol en preorder
    * */
    public ArrayList<Integer> preorder(Nodo _nodoRaiz){
        // Nos servirá como referencia para recorrer el árbol
        Nodo actual = _nodoRaiz;
        // Si el árbol está vacío, no hay elementos qué imprimir
        if (actual == null){
            return this.preorder;
        }
        // Agregamos la raíz a la lista global
        this.preorder.add(actual.dato);
        // Llamamos de forma recursiva primero al hijo izquierdo
        preorder(actual.hijoIzquierdo);
        // Una vez que terminamos con el izquierdo, hacemos recursión con el derecho
        preorder(actual.hijoDerecho);

        return this.preorder;
    }

    /* La operación postorder() realiza un recorrido siguiendo el patrón izquierdo, derecho, raíz
    * Utiliza una estrategia recursiva para realizar el recorrido.
    @params:
        nodoRaiz: La raíz del árbol que vamos a recorrer
    @ returns
        ArrayList: Un array con los elementos del árbol en postorder
    * */
    public ArrayList<Integer> postorder(Nodo _nodoRaiz){
        // Nos servirá como referencia para recorrer el árbol
        Nodo actual = _nodoRaiz;
        // Si el árbol está vacío, no hay elementos qué imprimir
        if (actual == null){
            return this.postorder;
        }

        // Llamamos de forma recursiva primero al hijo izquierdo
        postorder(actual.hijoIzquierdo);
        // Una vez que terminamos con el izquierdo, hacemos recursión con el derecho
        postorder(actual.hijoDerecho);
        // Agregamos la raíz a la lista global
        this.postorder.add(actual.dato);

        return this.postorder;
    }

    /* Los siguientes tres métodos son necesarios para evitar que se dupliquen los elementos al imprimirlos debido a la
    naturaleza del algoritmo de recorrido (que agrega los elementos al array global en cada paso.
    Su función es resetear el estado de los arrays cuando se llaman a imprimir, impidiendo que existan duplicados si se
    vuelve a recorrer el árbol.
    * */
    public ArrayList<Integer> inorderTraversal() {
        this.inorder = new ArrayList<Integer>();
        return inorder(this.nodoRaiz);
    }

    public ArrayList<Integer> preorderTraversal() {
        this.preorder = new ArrayList<Integer>();
        return preorder(this.nodoRaiz);
    }

    public ArrayList<Integer> postorderTraversal() {
        this.postorder = new ArrayList<Integer>();
        return postorder(this.nodoRaiz);
    }
    /* Por las especificaciones, durante el recorrido *NO* se imprime el contenido del árbol.
    Sin embargo, nuestro árbol cuenta con su propia operación imprimir(), que le permite al usuario elegir en qué orden
    quiere realizar la impresión.
    @params:
        int _opcion: un número entre el 0 y el 2 en donde 0 es Inorder, 1 es Preorder y 2 es Postorder
    @returns:
        void: No regresa nada, pero imprime en la consola el contenido del árbol en el orden solicitado

    */
    public void imprimir(int _opcion){
        String orden = null;
        // Hacemos uso de la operación switch:case para regresar el contenido del árbol en el orden solicitado
        switch  (_opcion) {
            case 0:
                orden = inorderTraversal().toString();
                break;
            case 1:
                orden = preorderTraversal().toString();
                break;
            case 2:
                orden = postorderTraversal().toString();
                break;
        }
        System.out.println(orden);
    }

    /*BONUS: Función de búsqueda.
     * El árbol binario de búsqueda debe implementar una función que nos permita encontrar un elemento en la estructura.
     * Se practica un recorrido haciendo comparaciones entre el elemento a buscar y el elemento actual.
     * @parms:
     *   int _data: El elemento a encontrar ( se corrobora si existe o no )
     * @returns:
     *   boolean: Un booleano true/false dependiendo del resultado de las comparaciones
     * */
    public boolean busqueda(int _data) {
        // Nos servirá para atravesar el nodo y realizar comparaciones
        Nodo actual = this.nodoRaiz;
        // Realizamos el recorrido del árbol en busca del elemento solicitado
        while (true) {
            // Si el árbol está vacío o se llegó al final del recorrido sin encontrarlo
            if (actual == null) {
                System.out.println("No se encontró el elemento. \n");
                return false;
            }
            // En este caso sí se encontró al elemento
            else if (actual.dato == _data) {
                System.out.println("Se encontró al elemento. \n");
                return true;
            }
            // Si el elemento actual es mayor que el elemento a buscar, nos vamos hacia la izquierda
            else if (actual.dato > _data) {
                actual = actual.hijoIzquierdo;
            } else {
                actual = actual.hijoDerecho;
            }
        }
    }

    /* BONUS. Las funciones valorMinimo y valorMaximo nos permiten encontrar los elementos más grandes o más pequeños
    * en el árbol. Gracias a las propiedades del BTS, basta con recorrer el árbol hasta la izquierda (para el pequeño) o
    * hasta la derecha (para el mayor).
    * params:
    *   Ninguno
    * returns:
    *   int: el valor más grande o el más pequeño respectivamente
    * */
    public int valorMinimo() {
        Nodo actual = this.nodoRaiz;
        // Lanzamos una excepción si el usuario intenta llamar esta función en un árbol vacío
        if (actual == null) {
            throw new IllegalStateException("The tree is empty");
        }
        // Recorremos el árbol hasta llegar al que está más a la izquierda
        while (actual.hijoIzquierdo != null) {
            actual = actual.hijoIzquierdo;
        }
        return actual.dato;
    }
    public int valorMaximo() {
        Nodo actual = this.nodoRaiz;
        // Lanzamos una excepción si el usuario intenta llamar esta función en un árbol vacío
        if (actual == null) {
            throw new IllegalStateException("The tree is empty");
        }
        // Recorremos el árbol hasta llegar al que está más a la derecha
        while (actual.hijoDerecho != null) {
            actual = actual.hijoDerecho;
        }
        return actual.dato;
    }

    /* La función borrar() considera tres casos: 1) Cuando el nodo a borrar no tiene hijos. 2) Cuando el nodo a borrar
    tiene sólo un hijo. 3) Cuando el nodo a borrar tiene dos hijos.
    En cualquier caso, es necesario determinar cuál es el nodo padre del nodo a eliminar, por ello, se implementa una función
    auxiliar llamada: nodosPadreActual() que nos otorgará la referencia al nodo actual y al nodo padre.
    Esto es necesario porque en los casos donde el nodo a borrar tiene hijos, se debe determinar un nodo sucesor y realizar
    la sustitución del nodo a borrar (el nodo padre de el nodo actual ahora será el nodo padre del hijo del que se borra).
    *
    params:
        int data: El valor que contiene el nodo actual
    returns:
        NodoPadreActual: Una tupa de nodos: El padre y el actual.
    */
    public NodoPadreActual nodosPadreActual(int data) {
        // Inicializamos ambas referencias a los nodos, padre es nulo en estos momentos
        Nodo padre = null;
        Nodo actual = this.nodoRaiz;

        if (actual == null) {
            return new NodoPadreActual(padre, null);
        }
        // Recorremos todo el árbol en busca del nodo actual (El que contiene el dato que buscamos)
        while (true) {
            if (actual.dato == data) {
                return new NodoPadreActual(padre, actual);
            } else if (actual.dato > data) {
                padre = actual;
                actual = actual.hijoIzquierdo;
            } else {
                padre = actual;
                actual = actual.hijoDerecho;
            }
        }
    }
    /* La operación borrar() hace uso de la operación nodosPadreActual para tener una referencia del nodo a borrar y de su
    nodo padre.
    params:
        int data: El valor del nodo a borrar
    returns:
        boolean: true si todo salió en orden, false si no se pudo borrar el nodo
    * */

    public boolean borrar(int data){
        // En la variable nodos, se encuentran el nodo padre y el actual
        NodoPadreActual nodos = nodosPadreActual(data);
        // Si no existen referencias al nodo padre y al actual (el que vamos a borrar)
        if (nodos.padre == null && nodos.actual == null){
            return false;
        }
        // Es necesario llevar la cuenta de cuántos hijos tiene el nodo a borrar
        int numeroHijos = 0;
        // Si el nodo a borrar tiene tanto hijo izquierdo, como derecho, entonces nos encontramos con el caso 2
        if (nodos.actual.hijoIzquierdo != null && nodos.actual.hijoDerecho != null){
            numeroHijos = 2;
        } else if (nodos.actual.hijoIzquierdo == null && nodos.actual.hijoDerecho == null){
            numeroHijos = 0; // Los punteros a los hijos son nulos, por lo tanto, el nodo a borrar no tiene hijos (caso 1)
        } else {
            // Cualquier otra combinación quiere decir que el nodo cuenta con un solo hijo
            numeroHijos = 1;
        }
        // Primer caso, el nodo a borrar no tiene hijos
        switch (numeroHijos){
            case 0:
                // Es posible que el nodo a borrar sea la raíz
                if (nodos.padre != null){
                    // Si el nodo a borrar está en un subárbol derecho
                    if (nodos.padre.hijoDerecho == nodos.actual){
                        nodos.padre.hijoDerecho = null;
                    }
                } else {
                    nodos.padre.hijoIzquierdo = null;
                    // Si el nodo a borrar no tiene padre, entonces estamos frente al nodo raíz y para borrarlo, apuntamos a null
                    this.nodoRaiz = null;
                }
                break;
            case 1:
                // siguienteNodo es una referencia al hijo del nodo que vamos a eliminar
                Nodo siguienteNodo = null;
                if (nodos.actual.hijoIzquierdo != null){
                    siguienteNodo = nodos.actual.hijoIzquierdo;
                } else {
                    siguienteNodo = nodos.actual.hijoDerecho;
                }
                // En caso de que se quiera borrar la raíz, pero esta sí tenga un hijo
                if (nodos.padre != null){
                    if (nodos.padre.hijoIzquierdo == nodos.actual){
                        nodos.padre.hijoIzquierdo = siguienteNodo;
                    } else {
                        nodos.padre.hijoDerecho = siguienteNodo;
                    }
                } else {
                    this.nodoRaiz = siguienteNodo;
                }
                break;
            case 2:
                // Cuando se quiere eliminar un nodo con dos hijos, se debe buscar un sucesor utilizando un recorrido in-order
                Nodo padreNodoMasIzquierda = nodos.actual;
                Nodo nodoMasIzquierda = nodos.actual.hijoDerecho;
                // Necesitamos encontrar el el nodo cuyo valor sea más pequeño dentro del subarbol derecho
                while (nodoMasIzquierda.hijoIzquierdo != null){
                    padreNodoMasIzquierda = nodoMasIzquierda;
                    nodoMasIzquierda = nodoMasIzquierda.hijoIzquierdo;
                }
                // Se actualiza el valor del nodo que está a punto de ser eliminado con el sucesor
                nodos.actual.dato = nodoMasIzquierda.dato;
                if (padreNodoMasIzquierda.hijoIzquierdo == nodoMasIzquierda){
                    padreNodoMasIzquierda.hijoIzquierdo = nodoMasIzquierda.hijoDerecho;
                } else {
                    padreNodoMasIzquierda.hijoDerecho = nodoMasIzquierda.hijoDerecho;
                }
        }
        return true;
    }

    /* Las siguientes funciones displayTree() y display() son funciones auxiliares que nos permiten desplegar los árboles
    en forma gráfica (impresos en la consola). Se utilizarán simplemente para debuggear y para mostrar las operaciones de
    borrado y el efecto que tienen en los árboles que creemos.
    displayTree() no recibe parámetros, pero regresa un objeto StringBuilder.
    display() recibe un nodo(la raíz), una profundidad y una posición inicial.
    * */
    public String displayTree() {
        StringBuilder sb = new StringBuilder();
        display(this.nodoRaiz, 0, "Raíz");
        return sb.toString();
    }
    public void display(Nodo node, int depth, String position) {
        if (node != null) {
            display(node.hijoDerecho, depth + 1, "Derecho");
            String padding = new String(new char[depth * 4]).replace('\0', ' ');
            System.out.println(padding + (position.equals("Raíz") ? "" : (position + " ")) + node.dato);
            display(node.hijoIzquierdo, depth + 1, "Izquierdo");
        }
    }
}
