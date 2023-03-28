/*
Una implementación de un árbol de búsqueda binario. Utiliza la clase Nodo.java para generar los nodos.
Se implementan operaciones de inserción, borrado, tres recorridos (inorder, preorder, postorder) e impresión.
@author: Víctor Bocanegra
@date: 27/03/2023
*/


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
                System.out.println("No se encontró el elemento. ");
                return false;
            }
            // En este caso sí se encontró al elemento
            else if (actual.dato == _data) {
                System.out.println("Se encontró al elemento. ");
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
}
