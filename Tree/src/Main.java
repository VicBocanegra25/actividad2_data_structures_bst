import java.util.ArrayList;

/* La clase Main() nos permitirá probar las operaciones del árbol de búsqueda binario.
* Primero instanciamos la clase Arbol.java y generamos un objeto del tipo Arbol(), al cual le insertaremos elementos.
* */
public class Main {
    public static void main(String[] args) {
        System.out.println("Vamos a generar un Árbol de Búsqueda Binario.\n");
        // Generamos una instancia de la clase Arbol()
        Arbol arbol = new Arbol();
        // Agregamos 5 nodos
        arbol.insertar(5); // Este nodo es la raíz
        arbol.insertar(2);
        arbol.insertar(7);
        arbol.insertar(9);
        System.out.println(arbol.insertar(1));

        // Las especificaciones nos piden no imprimir durante el recorrido, pero para comprobar que funcionan, los guardamos
        // En un array e imprimimos el array.
        // Hacemos el recorrido inorder
        System.out.println("Primer recorrido inorder");
        ArrayList inorderArray;
        inorderArray = arbol.inorder(arbol.nodoRaiz);
        System.out.println(inorderArray);

        // Hacemos el recorrido pre-order
        ArrayList preorderArray;
        preorderArray = arbol.preorder(arbol.nodoRaiz);
        System.out.println(preorderArray);

        // Hacemos el recorrido post-order
        ArrayList postorderArray;
        postorderArray = arbol.postorder(arbol.nodoRaiz);
        System.out.println(postorderArray);


        // Imprimimos el contenido en los tres tipos de recorrido
        System.out.println("\nEsta vez imprimimos el contenido con la función imprimir()\n");
        arbol.imprimir(0); // inorder
        arbol.imprimir(1); // preorder
        arbol.imprimir(2); // postorder
    }
}