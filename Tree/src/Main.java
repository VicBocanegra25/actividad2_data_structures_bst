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

        // Hacemos el recorrido inorder
        ArrayList inorderArray;
        inorderArray = arbol.inorder(arbol.nodoRaiz);
        System.out.println(inorderArray);


    }
}