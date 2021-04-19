package aed.tp3;

public class Tree {
    Node root;

    public Tree() {
        this.root = null;
    }

    public void insert(Cliente c) {
        this.root = add(this.root, c);
    }

    private Node add(Node node, Cliente c) {
        // Simple Case: If tree is empty
        if (node == null)
            return new Node(c);

        // Bring the closest leaf node to root
        node = splay(node, c);

        // If key is already present, then return
        if (node.cliente.nome.equals(c.nome)) {
            System.out.println("Ja existe!");
            return node;
        }

        // Otherwise allocate memory for new node
        Node aux = new Node(c);

        // If root's key is greater, make
        // root as right child of newnode
        // and copy the left child of root to newnode
        if (node.cliente.nome.compareTo(c.nome) > 0) {
            aux.right = node;
            aux.left = node.left;
            node.left = null;
        }

        // If root's key is smaller, make
        // root as left child of newnode
        // and copy the right child of root to newnode
        else {
            aux.left = node;
            aux.right = node.right;
            node.right = null;
        }

        return aux; // newnode becomes new root
    }

    //ZAG
    private Node rotateLeft(Node node) {
        Node aux = node.right;
        node.right = aux.left;
        aux.left = node;
        return aux;
    }

    //ZIG
    private Node rotateRight(Node node) {
        Node aux = node.left;
        node.left = aux.right;
        aux.right = node;
        return aux;
    }

    private Node splay(Node node, Cliente c) {
        if (node == null || node.cliente.nome.equals(c.nome))
            return node;

        // Key lies in left subtree
        if (node.cliente.nome.compareTo(c.nome) > 0) {
            // Key is not in tree, we are done
            if (node.left == null)
                return node;

            // Zig-Zig (Left Left)
            if (node.left.cliente.nome.compareTo(c.nome) > 0) {
                // First recursively bring the
                // key as root of left-left
                node.left.left = splay(node.left.left, c);

                // Do first rotation for root,
                // second rotation is done after else
                node = rotateRight(node);
            } else if (node.left.cliente.nome.compareTo(c.nome) < 0) { // Zig-Zag (Left Right)
                // First recursively bring
                // the key as root of left-right
                node.left.right = splay(node.left.right, c);

                // Do first rotation for root.left
                if (node.left.right != null)
                    node.left = rotateLeft(node.left);
            }
            // Do second rotation for root
            return (node.left == null) ? node : rotateRight(node);
        } else {// Key lies in right subtree
            // Key is not in tree, we are done
            if (node.right == null) return node;

            // Zig-Zag (Right Left)
            if (node.right.cliente.nome.compareTo(c.nome) > 0) {
                // Bring the key as root of right-left
                node.right.left = splay(node.right.left, c);

                // Do first rotation for root.right
                if (node.right.left != null)
                    node.right = rotateRight(node.right);
            } else if (node.right.cliente.nome.compareTo(c.nome) < 0) { // Zag-Zag (Right Right)
                // Bring the key as root of
                // right-right and do first rotation
                node.right.right = splay(node.right.right, c);
                node = rotateLeft(node);
            }

            // Do second rotation for root
            return (node.right == null) ? node : rotateLeft(node);
        }

    }

    public void search(String nome) {
        this.root = auxSearch(this.root, new Cliente("", nome, 0));
        //System.out.println("Got: " + this.root.cliente);
    }

    private Node auxSearch(Node node, Cliente c) {
        return splay(node, c);
    }

    public void print() {
        printTree(root);
    }

    private void printTree(Node node) {
        if (node != null) {
            printTree(node.left);
            System.out.println(" " + node.cliente);
            printTree(node.right);
        }
    }

    public void reset(){
        this.root = null;
    }

}