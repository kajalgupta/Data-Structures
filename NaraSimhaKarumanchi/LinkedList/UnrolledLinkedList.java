package NaraSimhaKarumanchi.LinkedList;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.ListIterator;

public class UnrolledLinkedList<E> extends AbstractList<E> {
    private int nodeCapacity;
    private int size = 0;
    private Node firstNode;
    private Node lastNode;

    public UnrolledLinkedList(int nodeCapacity) {
        if (nodeCapacity<8) {
            throw new IllegalArgumentException("Node capacity < 8");
        }
        this.nodeCapacity = nodeCapacity;
        firstNode = new Node();
        lastNode = firstNode;

    }
    public UnrolledLinkedList() {
        this(16);
    }
    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return (size == 0);
    }
   @Override
   public boolean contains(Object o) {
       return (indexOf(o) != -1);

   }
   @Override
   public Iterator<E> iterator() {
       return new ULLIterator(firstNode,0 , 0);
   }

   @Override
   public Object[] toArray() {
       Object[] array = new Object[size];
       int p=0;
       for (Node node = firstNode; node!=null; node = node.next) {
           for (int i = 0; i < node.numElements; i++) {
               array[p] = node.elements[i];
               p++;
           }
       }
       // TODO Auto-generated method stub
       return array;
   }
   public <T> T[] toArray(T[] a) {

    if (a.length < size) {
        a = (T[]) java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), size);

    }
    Object[] result = a;
    int p=0;
    for (Node node = firstNode; node!=null; node=node.next) {
        for (int i = 0; i <node.numElements; i++) {
            result[p]= node.elements[i];
            p++;
        }
    }
    return a;
       
   }
   public boolean add(E e) {
       insertIntoNode(lastNode, lastNode.numElements, e);
       return true;
   }

   private void insertIntoNode(Node node, int ptr, E element) {
    if (node.numElements == nodeCapacity) {

        Node newNode = new Node();
        int elementsToMove = nodeCapacity/2;
        int startIndex = nodeCapacity - elementsToMove;
        int i;
        for ( i = 0; i<elementsToMove; i++) {
            newNode.elements[i] = node.elements[startIndex+i];
            node.elements[startIndex+i] = null;
        }
        node.numElements -= elementsToMove;
        newNode.numElements = elementsToMove;
        newNode.next = node.next;
        newNode.previous = node;
        if (node.next != null) {
            node.next.previous = newNode;
        }
        node.next = newNode;
        if (node == lastNode) {
            lastNode = newNode;
        }
        if (ptr > node.numElements) {
            node = newNode;
            ptr-= node.numElements;
        }
        
        
    }
   }

   @Override
   public ListIterator<E> listIterator(int index) {
       if (index<0 || index>size) {
           throw new IndexOutOfBoundsException();
       }
       Node node;
       int p=0;
       if (size - index > index) {
           node = firstNode;
           while (p<=index-node.numElements) {
               p += node.numElements;
               node = node.next;
           }
       }
       else{
           node = lastNode;
           p = size;
           while ((p-= node.numElements)>index) {
               node = node.previous;
           }
       }
       // TODO Auto-generated method stub
       return new ULLIterator(node, index-p, index);
   }
   /**
    * Node
    */
   private class Node {

    Node next;
    Node previous;
    int numElements = 0;
    Object[] elements;
    Node(){
        elements = new Object[nodeCapacity];
    }

   }
    @Override
    public E get(int index) {
        // TODO Auto-generated method stub
        return null;
    }

    private class ULLIterator implements ListIterator<E> {

        Node currentNode;
        int ptr;
        int index;

        private int expectedModCount = modCount; //iterator's field

        ULLIterator(Node node, int ptr, int index){
            this.currentNode = node;
            this.ptr = ptr;
            this.index = index;

        }

        @Override
        public boolean hasNext(){
            return (index < size-1);
        }
        
        @Override
        public E next() {
            // TODO Auto-generated method stub
            ptr++;
            if (ptr >= currentNode.numElements) {
                
            }
            return null;
        }
    
        
    }
    
    

 
}