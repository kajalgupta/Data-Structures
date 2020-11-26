package GeeksForGeeks.Sorting;

import java.util.Arrays;

public class MinHeap {

    public static void main(String[] args) {
        int[] arr = {2,8,5,3,9,1};
        poll();
    }
    
     private int capacity = 10;
     private int size = 0;

     int[] items = {2,8,5,3,9,1,7,10,11,19};
     //new int[capacity];
    // items = {2,8,5,3,9,1,7,10,11,19};
     //GET INDEX METHODS--
     private int getLeftChildIndex(int parentIndex){
         return 2*parentIndex+1;
     }
     private int getRightChildIndex(int parentIndex){
         return 2*parentIndex+2;
     }
     private int getParentIndex(int childIndex){
         return (childIndex-1)/2;
     }

     //CHECK INDEX METHODS --
     private boolean hasLeftChild(int index){
         return getLeftChildIndex(index)<size;
     }
     private boolean hasRightChild(int index){
        return getRightChildIndex(index)<size;
    }
    private boolean hasParent(int index){
        return getParentIndex(index)>=0;
    }

    //GET VALUES --
    private int leftChild(int index){
        return items[getLeftChildIndex(index)];
    }
    private int rightChild(int index){
        return items[getRightChildIndex(index)];
    }
    private int parent(int index){
        return items[getParentIndex(index)];
    }

    private void swap(int indexOne, int indexTwo){
        int temp = indexOne;
        items[indexOne] = items[indexTwo];
        items[indexTwo] = temp;
    }

    private void ensureExtraCapacity(){
        if (size == capacity) {
            items = Arrays.copyOf(items, capacity*2);
            capacity *= 2;
        }
    }
    
    public int peek(){
        if (size==0) throw new IllegalStateException();
        return items[0];
    }
    public int poll(){
        if(size==0) throw new IllegalStateException();
        int item = items[0];
        items[0] = items[size-1];
        items[size-1] = item;
        size--;
        heapifyDown();
        return item;
    }

    private void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int smallChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && rightChild(index)<leftChild(index)) {
                smallChildIndex = getRightChildIndex(index);
            }
            if (items[index]< items[smallChildIndex]) {
                break;
            }
            else{
                swap(index, smallChildIndex);
            }
            index = smallChildIndex;

        }
    }

    public void add(int item) {
        ensureExtraCapacity();
        items[size] = item;
        size++;
        heapifyUp();
    }

    private void heapifyUp() {
        int index = size-1;
        while (hasParent(index) && parent(index)>items[index]) {
            swap(index, getParentIndex(index));
            index = getParentIndex(index);
        }
    }
    
    
    


    
}