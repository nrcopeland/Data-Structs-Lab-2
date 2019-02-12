public class myLinkedList<E extends Comparable<E>>{
  // instance variables of the SinglyLinkedList
  private Node<E> head = null;               // head node of the list (or null if empty)
  private Node<E> tail = null;
  
  public boolean isEmpty;
  
  // last node of the list (or null if empty)
  
  public myLinkedList() {  // constructs an initially empty list
	this.head=null;
	this.tail=null;
  }            

  public int size() {//Returns the number of elements in the linked list.
		   int size = 0;
		   Node<E> curr = this.head;
		   while(curr != null){
		       curr=curr.getNext();
			   size++;
		   }
		return size;}	  
	   
  public boolean isEmpty() { // Tests whether the linked list is empty.
	  	return size()==0;
	  }
	  

  public E first() {  // returns (but does not remove) the first element
	  Node<E> curr = this.head;
	  return curr.getItem();
  }

  public E last() {              // returns (but does not remove) the last element
	  Node<E> curr = this.tail;
	  return curr.getItem();
  }

  public void addFirst(E e) {                // adds element e to the front of the list
	  Node<E> node = new Node<E>(e);
	  node.setNext(this.head);//ask tutor about correct syntax
	  this.head=node;
  }

  public void addLast(E e) {                 // adds element e to the end of the list
	  Node<E> temp = new Node<E>(e, null);
	  if(this.head!=null) {
		 Node<E> temp1 = this.head;
		 while (temp1.getNext() != null){
		  temp1 = temp1.getNext();
		 }
		  temp1.setNext(temp);
	  } else this.head=temp;
  }
		  
  public E removeFirst() {  
	  Node<E> temp = this.head;
	  this.head.setNext(this.head.getNext());
	  return temp.getItem();
  }
 
  public E removeLast() {                   // removes and returns the first element
	  Node<E> temp = this.head;
	  Node<E> prev = null;
	  while (temp.getNext()!=null) {
		  prev = temp;
		  temp = temp.getNext();
	  }
	  if (prev==null) {
		  this.head=null;
	  }
	  else {
		  prev.setNext(null);
  }
	  return temp.getItem();
  }

  public void concatenateList (myLinkedList<E> M) {//attach another linkedList refered by M to the end of this linkedList
	  
	   Node <E> temp=this.head;
	   // While there are available positions in p; 
	   while (temp.getNext() != null) { 
	        temp = temp.getNext();
	    } 
	        temp.setNext(M.head);
  }
 
  public int searchElement(E targetElement){//test if a target element can be found on the list, return the occurrences of the target element	  
	  Node<E> temp = this.head;
	  while(temp!=null) {
	  if(temp.getItem()==targetElement) {
			  //System.out.println("Node "+temp+" has this value."); test to make sure it was getting both 1's and not the same one twice
	  }
		  temp=temp.getNext();
	  }
	return size();
	} 
  
  public void removeElement(E targetElement){//remove all target element that can be found on the list
	  Node<E> temp = this.head;
	  Node<E> prev = null;
	  if(this.head == null) {
	        return;
	    }
	  if(this.head.getItem()==targetElement){
		  removeFirst();
	  }
	    //Node temp = list.head;
	    //Node prev = null; 
	    // If head node itself holds the key or multiple occurrences of key
	    while(temp != null && temp.getItem() == targetElement) {
	    	this.head = temp.getNext();
	        temp = this.head;
	    }
	    while(temp !=null) {
	        if(temp.getItem() == targetElement) {
	            prev.setNext(temp.getNext());;
	        } else {
	            prev = temp;
	        }
	        temp = temp.getNext();
	    }
	}	  
	  /*if(this.head==null) {//previous way I was trying that did not work out
		  return;
	  }
	  if(temp!=null && temp.getItem()==targetElement) {
		  //removeFirst();
		  this.head=temp.getNext();
		  this.count--;  
	  }
	  while(temp!=null && temp.getItem()!=targetElement) {
		  prev=temp;
		  temp=temp.getNext();
	  }
	  if (prev == null) return;
	 
	  if(temp.getItem()==targetElement){
			  prev.setNext(temp.getNext());
			  this.count--;
			  removeElement(targetElement);
		  
		  }}
	  /*if(temp!=null && temp.getItem()==targetElement) {
		  this.head=temp.getNext();
		  this.count--;
  }*/

  public E middleElement(){//find and return the element that stored at the middle node of a linkedList
	  Node<E> temp = this.head;
	  Node<E> temp1 = this.head;
	  
	  if(this.head!=null) {
		  while(temp!=null && temp.getNext()!=null) {
			  try{
				  temp = temp.getNext().getNext();//traverses linked list twice as fast as temp1
			  }catch(NullPointerException e){temp=temp.getNext();
		  }
			  temp1 = temp1.getNext();//temp gets to end of list while temp1 is in the middle
		  } 
	  }
	  		return temp1.getItem();
  }

  /**
   * Produces a string representation of the contents of the list.
   * This exists for debugging purposes only.
   */
  public String toString() {
    StringBuilder sb = new StringBuilder("(");
    Node<E> walk = head;
    while (walk != null) {
      sb.append(walk.getItem());
      if (walk != tail)
        sb.append(", ");
      walk = walk.getNext();
    }
    sb.append(")");
    return sb.toString();
  }
}
