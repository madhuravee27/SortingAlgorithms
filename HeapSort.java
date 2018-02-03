//package SortingAlgorithms;

import java.io.IOException;
import java.util.ArrayList;

public class HeapSort {
    public static void main(String[] args) throws IOException{
        HeapSortOperation heapSortOperation = new HeapSortOperation();
        heapSortOperation.setNumberList();
        heapSortOperation.heapsort();
        heapSortOperation.printSortedList();
        heapSortOperation.printResults();
    }
}

class HeapSortOperation{
    protected ArrayList<Integer> numberList = new ArrayList<>();
    Comparison comparison = new Comparison();
    CommonOperations commonOperations = new CommonOperations();

    public void setNumberList() throws IOException {
        this.numberList = commonOperations.getNumberList();
    }

    public void heapsort(){
        comparison.resetNumberOfComparisons();
        int arrayListSize = numberList.size();
        commonOperations.startTimer();
        for (int i = arrayListSize / 2 - 1; i >= 0; i--)   // start to build heap
            heapify(arrayListSize, i);                     // call heapify on each set

        for (int i=arrayListSize-1; i>=0; i--)             // take each element from heap
        {
            Integer temp = numberList.get(0);              // swap the elements
            numberList.set(0,numberList.get(i));
            numberList.set(i,temp);
            heapify(i, 0);                              // call  max heapify on the elements
        }
        commonOperations.stopTimer();
    }

    void heapify(int arraysize, int i)
    {
        int largest = i;                                   // Keep the largest value as root
        int left = 2*i + 1;                                // Take left element as the last element in left subarray
        int right = 2*i + 2;                               // Take right  as starting element in the right sub string

        if (left < arraysize && comparison.compare(numberList.get(left),numberList.get(largest)) > 0 ) // If left is less than the largest value
            largest = left;

        if (right < arraysize && comparison.compare(numberList.get(right),numberList.get(largest)) > 0) // If the right child is larger than the largest elemnt in the previous elements
            largest = right;


        if (largest != i)  // If largest is not root
        {
            Integer temp = numberList.get(i);
            numberList.set(i,numberList.get(largest));
            numberList.set(largest, temp);
            heapify(arraysize, largest);// Recursively heapify
        }
    }

    public void printSortedList(){
        commonOperations.printSortedList(numberList);
    }

    public void printResults(){
        commonOperations.printResults(comparison.getNumberOfComparisons());
    }
}
