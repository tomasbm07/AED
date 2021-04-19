package aed.tp3;

public class Node {
    Node left;
    Node right;
    Cliente cliente;

    public Node(Cliente c) {
        this.left = null;
        this.right = null;
        this.cliente = c;
    }

}
