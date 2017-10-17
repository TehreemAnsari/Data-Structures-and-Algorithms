package basic; 
/*
 * To implement inbuilt LL use util
 * The LinkedList class extends AbstractSequentialList and 
 * implements the List interface. It provides a linked-list data structure.
 * 
 * Constructors: LinkedList(), creats an empty LL
 * 				:LinkedList(Collection c) builds a LL which is initialized by the
 * 					elements of c
 * 
 * Methods::
 * 1. void add(int index, Object element):Inserts the specified element at 
 * the specified position index in this list. 
 * Throws IndexOutOfBoundsException if the specified index is 
 * out of range (index < 0 || index > size()).
 * 
 * 2.boolean add(Object o): Appends the specified element to the end of this list.
 * 
 * 3. boolean addAll(Collection c): Appends all of the elements in the 
 * specified collection to the end of this list, in the order that they 
 * are returned by the specified collection's iterator. 
 * Throws NullPointerException if the specified collection is null.
 * 
 * 4. boolean addAll(int index, Collection c): Inserts all of the elements 
 * in the specified collection into this list, starting at the specified position. 
 * Throws NullPointerException if the specified collection is null.
 * 
 * 5. void addFirst(Object o):Inserts the given element at the beginning of this list.
 * 
 * 6.void addLast(Object o): Appends the given element to the end of this list.
 * 
 * 7.void clear():Removes all of the elements from this list.
 * 
 * 8.Object clone():Returns a shallow copy of this LinkedList.
 * 
 * 9.boolean contains(Object o):Returns true if this list contains 
 * the specified element. More formally, returns true if and only if 
 * this list contains at least one element e such that 
 * (o==null ? e==null : o.equals(e)).
 * 
 * 10.Object get(int index):Returns the element at the specified position 
 * in this list. Throws IndexOutOfBoundsException if the specified index 
 * is out of range (index < 0 || index >= size()).
 * 
 * 11.Object getFirst():Returns the first element in this list. 
 * Throws NoSuchElementException if this list is empty.
 * 
 * 12.Object getLast():Returns the last element in this list. 
 * Throws NoSuchElementException if this list is empty.
 * 
 * 13.int indexOf(Object o):Returns the index in this list of the 
 * first occurrence of the specified element, or -1 if the list does not 
 * contain this element.
 * 
 * 14.int lastIndexOf(Object o):Returns the index in this list of 
 * the last occurrence of the specified element, or -1 if the list does not 
 * contain this element.
 * 
 * 15.ListIterator listIterator(int index):Returns a list-iterator of the 
 * elements in this list (in proper sequence), starting at the specified position
 *  in the list. Throws IndexOutOfBoundsException if the specified index is 
 *  out of range (index < 0 || index >= size()).
 *  
 * 16.Object remove(int index):Removes the element at the specified position 
 * in this list. Throws NoSuchElementException if this list is empty.
 * 
 * 17.boolean remove(Object o):Removes the first occurrence of the specified 
 * element in this list. Throws NoSuchElementException if this list is empty. 
 * Throws IndexOutOfBoundsException if the specified index is out of range 
 * (index < 0 || index >= size()).
 * 
 * 18.Object removeFirst():Removes and returns the first element from this list. 
 * Throws NoSuchElementException if this list is empty.
 * 
 * 19.Object removeLast():Removes and returns the last element from this list. 
 * Throws NoSuchElementException if this list is empty.
 * 
 * 20.Object set(int index, Object element):Replaces the element at the specified 
 * position in this list with the specified element. 
 * Throws IndexOutOfBoundsException if the specified index is out of range 
 * (index < 0 || index >= size()).
 * 
 * 21.int size():Returns the number of elements in this list.
 * 
 * 22.Object[] toArray():Returns an array containing all of the elements in 
 * this list in the correct order. Throws NullPointerException if the 
 * specified array is null.
 * 
 * 23.Object[] toArray(Object[] a):Returns an array containing all of 
 * the elements in this list in the correct order; the runtime type of the 
 * returned array is that of the specified array.
 */
import java.util.*;
public class BuildInLinkedList {

   public static void main(String args[]) {
      // create a linked list
      LinkedList ll = new LinkedList();
      
      // add elements to the linked list
      ll.add("F");
      ll.add("B");
      ll.add("D");
      ll.add("E");
      ll.add("C");
      ll.addLast("Z");
      ll.addFirst("A");
      ll.add(1, "A2");
      System.out.println("Original contents of ll: " + ll);

      // remove elements from the linked list
      ll.remove("F");
      ll.remove(2);
      System.out.println("Contents of ll after deletion: " + ll);
      
      // remove first and last elements
      ll.removeFirst();
      ll.removeLast();
      System.out.println("ll after deleting first and last: " + ll);

      // get and set a value
      Object val = ll.get(2);
      ll.set(2, (String) val + " Changed");
      System.out.println("ll after change: " + ll);
   }
}