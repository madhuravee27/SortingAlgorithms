//package SortingAlgorithms;

//import SortingAlgorithms.Comparison;

//import SortingAlgorithms.CommonOperations;

import java.io.IOException;
import java.util.ArrayList;

public class InsertionSort {
    public static void main(String[] args) throws IOException{
        InsertionSortOperation insertionSortOperation = new InsertionSortOperation();
        insertionSortOperation.setNumberList();
        insertionSortOperation.insertSort();
        insertionSortOperation.printSortedList();
        insertionSortOperation.printResults();
    }
}
class InsertionSortOperation{
    protected ArrayList<Integer>numberList = new ArrayList<>();
    Comparison comparison = new Comparison();
    CommonOperations commonOperations = new CommonOperations();

    public void setNumberList() throws IOException{
        this.numberList = commonOperations.getNumberList();
    }

    public void insertSort() {
        comparison.resetNumberOfComparisons();
        commonOperations.startTimer();
        int i = 0;
        outerloop:
        while (i < numberList.size()) {
            int j = i;
            innerloop:
            while (j > 0) {
                if (comparison.compare(numberList.get(j-1),numberList.get(j)) > 0) {
                    Integer temporary = numberList.get(j - 1);
                    numberList.set((j - 1), numberList.get(j));
                    numberList.set(j, temporary);
                } else break innerloop;
                j--;
            }
            i++;
        }
        commonOperations.stopTimer();
    }

    public void printSortedList(){
        commonOperations.printSortedList(numberList);
    }

    public void printResults(){
        commonOperations.printResults(comparison.getNumberOfComparisons());
    }
}


