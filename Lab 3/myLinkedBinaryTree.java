import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class myLinkedBinaryTree<E extends Comparable<E>> {
	protected BinaryNode<E> root = null; // root of the tree
	protected int size = 0;
	private Comparator<E> theComparator;// number of nodes in the tree
	private ArrayList<E> treeContents = new ArrayList<E>();

	public myLinkedBinaryTree() {
		root = null;
		theComparator = null;
	}

	public myLinkedBinaryTree(Comparator<E> comp) {
		root = null;
		theComparator = comp;
	}

	private int compare(E x, E y) {// makes it possible to
		if (theComparator == null)
			return x.compareTo(y);
		else
			return theComparator.compare(x, y);
	}

	// constructor
	protected BinaryNode<E> validate(BinaryNode<E> p) throws IllegalArgumentException {
		if (!(p instanceof BinaryNode))
			throw new IllegalArgumentException("Not valid BinaryNode type");
		BinaryNode<E> node = (BinaryNode<E>) p; // safe cast
		if (node.getParent() == node) // our convention for defunct node
			throw new IllegalArgumentException("p is no longer in the tree");
		return node;
	}

	// accessor methods
	public int size() {
		System.out.print("The size of this tree is: ");
		BinaryNode<E> curr = root;
		return size(curr);
	}

	/* computes number of nodes in tree */
	private int size(BinaryNode<E> curr) {
		if (curr == null)
			return 0;
		else
			return (size(curr.getLeft()) + 1 + size(curr.getRight()));
	}

	/**
	 * Returns the root BinaryNode of the tree (or null if tree is empty).
	 * 
	 * @return root BinaryNode of the tree (or null if tree is empty)
	 */

	public BinaryNode<E> root() {
		return root;
	}

	/**
	 * Returns the BinaryNode of p's parent (or null if p is root).
	 *
	 * @param p A valid BinaryNode within the tree
	 * @return BinaryNode of p's parent (or null if p is root)
	 * @throws IllegalArgumentException if p is not a valid BinaryNode for this
	 *                                  tree.
	 */
	public BinaryNode<E> parent(BinaryNode<E> p) throws IllegalArgumentException {
		BinaryNode<E> node = validate(p);
		return node.getParent();
	}

	/**
	 * Returns the BinaryNode of p's left child (or null if no child exists).
	 *
	 * @param p A valid BinaryNode within the tree
	 * @return the BinaryNode of the left child (or null if no child exists)
	 * @throws IllegalArgumentException if p is not a valid BinaryNode for this tree
	 */
	public BinaryNode<E> left(BinaryNode<E> p) throws IllegalArgumentException {
		BinaryNode<E> node = validate(p);
		return node.getLeft();
	}

	/**
	 * Returns the BinaryNode of p's right child (or null if no child exists).
	 *
	 * @param p A valid BinaryNode within the tree
	 * @return the BinaryNode of the right child (or null if no child exists)
	 * @throws IllegalArgumentException if p is not a valid BinaryNode for this tree
	 */
	public BinaryNode<E> right(BinaryNode<E> p) throws IllegalArgumentException {
		BinaryNode<E> node = validate(p);
		return node.getRight();
	}

	// update methods supported by this class
	/**
	 * Places element e at the root of an empty tree and returns its new BinaryNode.
	 *
	 * @param e the new element
	 * @return the BinaryNode of the new element
	 * @throws IllegalStateException if the tree is not empty
	 */
	public BinaryNode<E> addRoot(E e) throws IllegalStateException {
		if (!isEmpty())
			throw new IllegalStateException("Tree is not empty");
		root = new BinaryNode<E>(e, null, null, null);
		size = 1;
		return root;
	}

	private boolean isEmpty() {
		// TODO Auto-generated method stub
		if (root == null)
			return true;
		return false;
	}

	/**
	 * Creates a new left child of BinaryNode p storing element e and returns its
	 * BinaryNode.
	 *
	 * @param p the BinaryNode to the left of which the new element is inserted
	 * @param e the new element
	 * @return the BinaryNode of the new element
	 * @throws IllegalArgumentException if p is not a valid BinaryNode for this tree
	 * @throws IllegalArgumentException if p already has a left child
	 */
	public BinaryNode<E> addLeft(BinaryNode<E> p, E e) throws IllegalArgumentException {
		BinaryNode<E> parent = validate(p);
		if (parent.getLeft() != null)
			throw new IllegalArgumentException("p already has a left child");
		BinaryNode<E> child = new BinaryNode<E>(e, parent, null, null);
		parent.setLeft(child);
		size++;
		return child;
	}

	/**
	 * Creates a new right child of BinaryNode p storing element e and returns its
	 * BinaryNode.
	 *
	 * @param p the BinaryNode to the right of which the new element is inserted
	 * @param e the new element
	 * @return the BinaryNode of the new element
	 * @throws IllegalArgumentException if p is not a valid BinaryNode for this
	 *                                  tree.
	 * @throws IllegalArgumentException if p already has a right child
	 */
	public BinaryNode<E> addRight(BinaryNode<E> p, E e) throws IllegalArgumentException {
		BinaryNode<E> parent = validate(p);
		if (parent.getRight() != null)
			throw new IllegalArgumentException("p already has a right child");
		BinaryNode<E> child = new BinaryNode<E>(e, parent, null, null);
		parent.setRight(child);
		size++;
		return child;
	}

	/**
	 * Replaces the element at BinaryNode p with element e and returns the replaced
	 * element.
	 *
	 * @param p the relevant BinaryNode
	 * @param e the new element
	 * @return the replaced element
	 * @throws IllegalArgumentException if p is not a valid BinaryNode for this
	 *                                  tree.
	 */
	public E set(BinaryNode<E> p, E e) throws IllegalArgumentException {
		BinaryNode<E> node = validate(p);
		E temp = node.getElement();
		node.setElement(e);
		return temp;
	}

	/**
	 * Attaches trees t1 and t2, respectively, as the left and right subtree of the
	 * leaf BinaryNode p. As a side effect, t1 and t2 are set to empty trees.
	 *
	 * @param p  a leaf of the tree
	 * @param t1 an independent tree whose structure becomes the left child of p
	 * @param t2 an independent tree whose structure becomes the right child of p
	 * @throws IllegalArgumentException if p is not a valid BinaryNode for this tree
	 * @throws IllegalArgumentException if p is not a leaf
	 */
	public void attach(BinaryNode<E> p, myLinkedBinaryTree<E> t1, myLinkedBinaryTree<E> t2)
			throws IllegalArgumentException {
		BinaryNode<E> node = validate(p);
		if (isInternal(p))
			throw new IllegalArgumentException("p must be a leaf");
		size += t1.size() + t2.size();
		if (!t1.isEmpty()) { // attach t1 as left subtree of node
			t1.root.setParent(node);
			node.setLeft(t1.root);
			t1.root = null;
			t1.size = 0;
		}
		if (!t2.isEmpty()) { // attach t2 as right subtree of node
			t2.root.setParent(node);
			node.setRight(t2.root);
			t2.root = null;
			t2.size = 0;
		}
	}

	private boolean isInternal(BinaryNode<E> p) {
		if (p.getLeft() != null || p.getRight() != null)
			return true;
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Removes the node at BinaryNode p and replaces it with its child, if any.
	 *
	 * @param p the relevant BinaryNode
	 * @return element that was removed
	 * @throws IllegalArgumentException if p is not a valid BinaryNode for this
	 *                                  tree.
	 * @throws IllegalArgumentException if p has two children.
	 */
	public E remove(BinaryNode<E> p) throws IllegalArgumentException {
		BinaryNode<E> node = validate(p);
		if (numChildren(p) == 2)
			throw new IllegalArgumentException("p has two children");
		BinaryNode<E> child = (node.getLeft() != null ? node.getLeft() : node.getRight());
		if (child != null)
			child.setParent(node.getParent()); // child's grandparent becomes its parent
		if (node == root)
			root = child; // child becomes root
		else {
			BinaryNode<E> parent = node.getParent();
			if (node == parent.getLeft())
				parent.setLeft(child);
			else
				parent.setRight(child);
		}
		size--;
		E temp = node.getElement();
		node.setElement(null); // help garbage collection
		node.setLeft(null);
		node.setRight(null);
		node.setParent(node); // our convention for defunct node
		return temp;
	}

//	public int numChildren() {
//		System.out.println("The number of children for this tree is: ");
//		return numChildren(root);
//	}
	public int numChildren(BinaryNode<E> p) {
		int childrenCount = 0;
		if (p.getLeft() != null)
			childrenCount = 1 + numChildren(p.getLeft());
		if (p.getRight() != null)
			childrenCount = childrenCount + 1 + numChildren(p.getRight());
		return childrenCount;
	}

	// public E findMax() {
	// return findMax(root);
	// }
	//
	/*
	 * private E findMax(BinaryNode<E> p) {
	 * 
	 * BinaryNode<E> max = p; BinaryNode<E> leftTraverse = null; BinaryNode<E>
	 * rightTraverse = null;
	 * 
	 * if (p.getLeft() != null) leftTraverse.setElement(findMax(p.getLeft())); if
	 * (p.getRight() != null) rightTraverse.setElement(findMax(p.getRight())); if
	 * (compare(leftTraverse.getElement(), rightTraverse.getElement()) > 0)
	 * max.setElement(leftTraverse.getElement()); else
	 * max.setElement(rightTraverse.getElement());
	 * 
	 * return max.getElement();
	 * 
	 * }
	 */

//  public Boolean search(E e){// check if element e is on the tree or not
//     BinaryNode<E> curr = root;
//     if(e.compareTo(curr.getElement())==0){ 
//      return true;
//     }else if(e.compareTo(curr.getElement()) < 0){ 
//              if(curr.getLeft()!=null)
//               return false;
//              else
//               return search(curr.getLeft().getElement());
//      }else if (e.compareTo(curr.getElement()) > 0) {
//       if(curr.getRight()!=null)
//               return false;
//              else
//               return search(curr.getRight().getElement());
//   }
//      return false;
//     }
	public boolean search(E e) {
		return search(root, e);
	}

	private boolean search(BinaryNode<E> p, E e) {
		if (p == null) {
			// System.out.print("Node " + e + " is not on this tree ");
			return false;
		} else {
			if (compare(e, p.getElement()) == 0) {
				// System.out.print("Node " + e + " is on this tree ");
				return true;
			} else {
				if (compare(e, p.getElement()) < 0)
					return search(p.getLeft(), e);
				else
					return search(p.getRight(), e);
			}
		}
	}

//    public void insert(E e){
//     root = insertHelper(root, e);
//    }
	public BinaryNode<E> insert(E e) {
		return insert(root, e);
	}

	private BinaryNode<E> insert(BinaryNode<E> p, E e) {
		BinaryNode<E> newNode = new BinaryNode<E>(e);
		if (root == null) {
			return newNode;
		}
		BinaryNode<E> curr = root;
		while (curr != null) {
			// if (curr == null)
			// return new BinaryNode<E>(e);
			// if (compare(e, p.getElement()) == 0)

			if (compare(e, p.getElement()) < 0) {
				if (curr.getLeft() == null) {
					curr.setLeft(newNode);
					System.out.println("Node " + e + " has been added to the tree");
					break;
				}
				curr = curr.getLeft();
			} else {
				if (curr.getRight() == null) {
					curr.setRight(newNode);
					System.out.println("Node " + e + " has been added to the tree");
					break;
				}
				curr = curr.getRight();
			}
		}
		return root;
	}

	public boolean printAncestors(E e) {
		return printAncestors(root, e);
	}

	private boolean printAncestors(BinaryNode<E> p, E e) {
		// BinaryNode<E> start = curr;
		if (p == null)
			return false;
		if (compare(e, p.getElement()) == 0)
			return true;
		if (printAncestors(p.getLeft(), e) || printAncestors(p.getRight(), e)) {
			System.out.println("Node " + p.getElement() + " is an ancestor of node " + e + ", ");
			return true;
		}
		// System.out.print("Node "+e+"'s ancestors are ");
		return false;
	}

	public ArrayList<E> inorderTraversal() {
		System.out.println("The Inorder Traversal of this tree is: ");
		return inorderTraversal(root);
	}

	public ArrayList<E> inorderTraversal(BinaryNode<E> p) {
		if (p != null) {
			inorderTraversal(p.getLeft());
			treeContents.add(p.getElement());
			inorderTraversal(p.getRight());
		}
		return treeContents;
	}

	public void findMax() {
		Collections.sort(treeContents);
		Collections.reverse(treeContents);
		System.out.println("The max element in this tree is " + treeContents.get(0));
	}

	// System.out.println(+treeContents+);
	public void findLCA(BinaryNode<E> p1, BinaryNode<E> p2) {
		BinaryNode<E> curr = root;
		while (root != null) {
			if (compare(curr.getElement(), p1.getElement()) > 0 && compare(curr.getElement(), p2.getElement()) > 0)
				curr = curr.getLeft();

			if (compare(curr.getElement(), p1.getElement()) < 0 && compare(curr.getElement(), p2.getElement()) < 0)
				curr = curr.getRight();

			else
				System.out.println("The LCA is node: " + curr.getElement());
			break;
		}
	}

	public boolean isIdentical(BinaryNode<E> p, BinaryNode<E> q) {
		if (p == null)
			return (q == null);
		else if ((q == null) || (compare(p.getElement(), q.getElement()) != 0))
			return false;
		return isIdentical(p.getLeft(), q.getLeft()) && isIdentical(p.getRight(), q.getRight());

	}

	public E getParent(E e) {
		return getParent(root, e);
	}

	private E getParent(BinaryNode<E> p, E e) {
		BinaryNode<E> curr = p;
		BinaryNode<E> prev = null;

		if (curr == null)
			System.out.println("This list is empty");
			//return false;
		while (curr != null) {
			if (compare(e, curr.getElement()) < 0) {
				prev = curr;
				curr = curr.getLeft();
			} else if (compare(e, curr.getElement()) > 0) {
				prev = curr;
				curr = curr.getRight();
			} else {
				System.out.println("The parent of node "+e+
						" is "+prev.getElement());
				break;
			}

		}
		return prev.getElement();

	}

	public static void main(String[] args) {

		myLinkedBinaryTree<Integer> binaryTree = new myLinkedBinaryTree<Integer>();
		myLinkedBinaryTree<Integer> binaryTreeTwo = new myLinkedBinaryTree<Integer>();
		binaryTree.addRoot(7);
		binaryTree.addRight(binaryTree.root, 8);
		binaryTree.addLeft(binaryTree.root, 6);
		binaryTree.insert(9);
		binaryTree.insert(4);
		binaryTree.insert(1);
		binaryTree.insert(40);
		binaryTreeTwo.addRoot(7);
		binaryTreeTwo.addRight(binaryTreeTwo.root, 8);
		binaryTreeTwo.addLeft(binaryTreeTwo.root, 6);
		binaryTreeTwo.insert(9);
		binaryTreeTwo.insert(4);
		binaryTreeTwo.insert(2);
		binaryTreeTwo.insert(40);
		System.out.println("The number of the children for this node is " + binaryTree.numChildren(binaryTree.root));
		System.out.println(binaryTree.search(10) ? "This node is in the tree" : "This node is not in the tree");
		System.out.println(binaryTree.size());
		System.out.println(binaryTree.printAncestors(40));
		System.out.println(binaryTree.inorderTraversal());
		binaryTree.findMax();
		binaryTree.findLCA(binaryTree.root.getLeft(), binaryTree.root.getRight());
		binaryTree.isIdentical(binaryTree.root, binaryTreeTwo.root);
		System.out.println(binaryTree.isIdentical(binaryTree.root, binaryTreeTwo.root)
				? "Both are these trees are exactly the same"
				: "These trees are different");
		binaryTree.getParent(4);
	}
}
