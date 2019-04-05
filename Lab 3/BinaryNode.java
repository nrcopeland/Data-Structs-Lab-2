public class BinaryNode<E> {
	private E element; // an element stored at this node
	private BinaryNode<E> parent; // a reference to the parent node (if any)
	private BinaryNode<E> left; // a reference to the left child (if any)
	private BinaryNode<E> right; // a reference to the right child (if any)

	/**
	 * Constructs a node with the given element and neighbors.
	 *
	 * @param e          the element to be stored
	 * @param above      reference to a parent node
	 * @param leftChild  reference to a left child node
	 * @param rightChild reference to a right child node
	 */
	public BinaryNode(E e, BinaryNode<E> above, BinaryNode<E> leftChild, BinaryNode<E> rightChild) {
		element = e;
		parent = above;
		left = leftChild;
		right = rightChild;
	}

	public BinaryNode(E e) {
		element = e;
		parent = null;
		left = null;
		right = null;
	}

	// accessor methods
	public E getElement() {
		return element;
	}

	public BinaryNode<E> getParent() {
		return parent;
	}

	public BinaryNode<E> getLeft() {
		return left;
	}

	public BinaryNode<E> getRight() {
		return right;
	}

	// update methods
	public void setElement(E e) {
		element = e;
	}

	public void setParent(BinaryNode<E> parentNode) {
		parent = parentNode;
	}

	public void setLeft(BinaryNode<E> leftChild) {
		left = leftChild;
	}

	public void setRight(BinaryNode<E> rightChild) {
		right = rightChild;
	}

}
