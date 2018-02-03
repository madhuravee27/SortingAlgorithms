//package SortingAlgorithms;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class UtilitySort {
    public static void main(String[] args) throws IOException{
        UtilitySortOperation utilitySortOperation = new UtilitySortOperation();
        utilitySortOperation.setNumberList();
        utilitySortOperation.utilitysort();
        utilitySortOperation.printSortedList();
        utilitySortOperation.printResults();
    }
}

class UtilitySortOperation{
    protected ArrayList<Integer> numberList = new ArrayList<>();
    Comparison comparison = new Comparison();
    CommonOperations commonOperations = new CommonOperations();

    public void setNumberList() throws IOException {
        this.numberList = commonOperations.getNumberList();
    }

    public void utilitysort(){
        comparison.resetNumberOfComparisons();
        comparison.resetNumberOfComparisons();
        commonOperations.startTimer();

        Collections.sort(numberList,comparison);

        commonOperations.stopTimer();
    }

    public void printSortedList(){
        commonOperations.printSortedList(numberList);
    }

    public void printResults(){
        commonOperations.printResults(comparison.getNumberOfComparisons());
    }
}
