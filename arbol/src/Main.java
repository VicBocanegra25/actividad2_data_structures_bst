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
        arbol.insertar(3);
        arbol.insertar(4);
        arbol.insertar(1);

        // Las especificaciones nos piden no imprimir durante el recorrido, pero para comprobar que funcionan, los guardamos
        // En un array e imprimimos el array.
        // Hacemos el recorrido inorder
        System.out.println("Primer recorrido: inorder");
        ArrayList inorderArray;
        inorderArray = arbol.inorder(arbol.nodoRaiz);
        System.out.println(inorderArray);

        // Hacemos el recorrido pre-order
        System.out.println("Segundo recorrido: preorder");

        ArrayList preorderArray;
        preorderArray = arbol.preorder(arbol.nodoRaiz);
        System.out.println(preorderArray);

        // Hacemos el recorrido post-order
        System.out.println("Primer recorrido postorder");
        ArrayList postorderArray;
        postorderArray = arbol.postorder(arbol.nodoRaiz);
        System.out.println(postorderArray);

        // Imprimimos el contenido en los tres tipos de recorrido
        System.out.println("\nEsta vez imprimimos el contenido con la función imprimir()\n");
        arbol.imprimir(0); // inorder
        arbol.imprimir(1); // preorder
        arbol.imprimir(2); // postorder

        // Realizamos la búsqueda de los elementos en el árbol
        System.out.println("\nBuscamos si existen los números del 1 al 5 en el árbol: \n");
        for (int i = 0; i < 6; i++){
            System.out.printf("%d - %b\n", i, arbol.busqueda(i));
        }

        // Imprimimos los nodos más grandes y más pequeños del árbol
        System.out.printf("\nEl nodo más pequeño en el árbol contiene el valor: %d\n", arbol.valorMinimo());
        System.out.printf("El nodo más grande en el árbol contiene el valor: %d\n", arbol.valorMaximo());

        // Representando el árbol en su estado actual
        System.out.println("\nRepresentación del árbol: \n");
        System.out.println(arbol.displayTree());

        // Eliminando un nodo sin hijos, un nodo con un hijo y un nodo con dos hijos
        System.out.println("\nProbando el método de borrado en nodos con y sin hijos.\n");
        System.out.println("Buscando al elemento 4");
        arbol.busqueda(4);
        arbol.borrar(4);
        System.out.println("Borrando el elemento 4");
        arbol.busqueda(4);
        System.out.println(arbol.displayTree());

        System.out.println("Buscando al elemento 7");
        arbol.busqueda(7);
        arbol.borrar(7);
        System.out.println("Borrando el elemento 7");
        arbol.busqueda(7);
        System.out.println(arbol.displayTree());

        System.out.println("Buscando al elemento 2");
        arbol.busqueda(2);
        arbol.borrar(2);
        System.out.println("Borrando el elemento 2");
        arbol.busqueda(2);
        System.out.println(arbol.displayTree());


    }
}