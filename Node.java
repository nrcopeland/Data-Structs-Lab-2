public class Node<E extends Comparable<E>> {

    private E item;            // reference to the element stored at this node
    private Node<E> next;         // reference to the subsequent node in the list
    /**
     * Creates a node with the given element and next node.
     *
     * @param e  the element to be stored
     * @param n  reference to a node that should follow the new node
     */
    public Node(E e, Node<E> n) {
    	item = e;
      next = n;
    }
    
    public Node(E e) {
    	item = e;
      next = null;
    }
    // Accessor methods
    public E getItem() { return item; }
    public Node<E> getNext() { return next; }
    // Modifier methods
    public void setNext(Node<E> n) { next = n; }
  } //----------- end of nested Node class -----------