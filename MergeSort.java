//package SortingAlgorithms;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.lang.Math;

public class MergeSort {
    public static void main(String[] args) throws IOException{
        MergeSortOperation mergeSortOperation = new MergeSortOperation();
        mergeSortOperation.setNumberList();
        mergeSortOperation.mergeSort();
        mergeSortOperation.printSortedList();
        mergeSortOperation.printResults();
    }
}

class MergeSortOperation{
    protected ArrayList<Integer> numberList = new ArrayList<>();
    protected ArrayList<Integer> tempList;
    Comparison comparison = new Comparison();
    CommonOperations commonOperations = new CommonOperations();

    public void setNumberList() throws IOException {
        this.numberList = commonOperations.getNumberList();
    }

    public void mergeSort(){

        commonOperations.startTimer();              // Start the timer for sorting
        sort(0,numberList.size()-1);
        commonOperations.stopTimer();               // Stop the timer of sorting
    }

    public void sort(int leftMost, int rightMost){
		int midValue=0;
        if (leftMost < rightMost)                  // Compare the leftmost and right most elements
        {
            midValue = (int)Math.floor(((float)(leftMost+rightMost))/2);
            sort(leftMost, midValue);              // Sort the left sub array
            sort(midValue+1, rightMost);  // Sort the right sub array
            merge(leftMost, midValue, rightMost);  // Merge the right and left sub arrays
        }
    }

    public void merge(int leftMost, int midValue, int rightMost){
        tempList = new ArrayList<>(Collections.nCopies(numberList.size(),0));
        for(int i=leftMost;i<=rightMost;i++)            //Copying the content of arraylist into a temporary list
            tempList.set(i,numberList.get(i));
        int left = leftMost;                            // Consider the left most element as left of the array
        int mid = midValue+1;                           // Consider mid element as middle element
        int index = leftMost;                           // Consider index as the element that is being traversed
        while (left <= midValue && mid <= rightMost) {  // Check if the range of left is less than mid and right greater than mid
            if (comparison.compare(tempList.get(mid),(tempList.get(left))) > 0) {
                numberList.set(index,tempList.get(left));// If  the element is less than mid elemnt add in the left array
                left++;
            } else {
                numberList.set(index,tempList.get(mid)); // If the elemnt is greater than mid elemnet add to the right array
                mid++;
            }
            index++;
        }
		
        while (left <= midValue) {
            numberList.set(index,tempList.get(left));
            index++;
            left++;
        }
		
		while (mid <= rightMost) {
            numberList.set(index,tempList.get(mid));
            index++;
            mid++;
        }

    }
	
    public void printSortedList(){
        commonOperations.printSortedList(numberList);
    }

    public void printResults(){
        commonOperations.printResults(comparison.getNumberOfComparisons());
    }
}
