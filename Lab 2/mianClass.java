
public class mianClass {
	public static void main(String[] args) {
		myLinkedList <Integer> listOne = new  myLinkedList <Integer>();
		listOne.addFirst(2);
		listOne.addLast(3);
		listOne.addLast(4);
		listOne.addFirst(1);
		System.out.println("listOne: "+listOne);
		myLinkedList <Integer> listTwo = new  myLinkedList <Integer>();
		listTwo.addFirst(2);
		listTwo.addLast(3);
		listTwo.addLast(4);
		listTwo.addFirst(1);
		System.out.println("listTwo: "+listTwo);
		listOne.removeLast();
		System.out.println("listOne after removing last: "+listOne);
		listOne.concatenateList(listTwo);
		System.out.println("listOne after concatenate with listTwo: "+listOne);
		if(listOne.searchElement(1)>0)
			System.out.println("Found 1 in the list. ");
		else System.out.println("No 1 in the list. ");
		listOne.removeElement(1);
		System.out.println("listOne after remove all 1: "+listOne);
		if(listOne.searchElement(1)<1)
		System.out.println("Failed to find 1 in the list. ");
		else System.out.println("No 1 in the list. ");
		System.out.println("Middle element of "+ listOne +" is "+listOne.middleElement());
		listOne.addFirst(5);
		System.out.println("New List after inserting one item is"+ listOne);
		System.out.println("Middle element of "+ listOne +" is "+listOne.middleElement());
		//System.out.print(listOne.size()); testing size is working correctly
	}
}
