import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    int recursiveCall = 0;

    int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = (low-1);
        for (int j=low; j<high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }

    void sort(int arr[], int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            recursiveCall++;
            sort(arr, low, pi-1);
            recursiveCall++;
            sort(arr, pi+1, high);
        }
    }

    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] randomArray = new int[1000];
        int[] ascendingArray = new int[1000];
        int[] descendingArray = new int[1000];
        int[] sameArray = new int[1000];
        for (int i = 0; i < 1000; i++){
            randomArray[i] = random.nextInt(1000);
            ascendingArray[i] = i;
            sameArray[i] = 99;
            descendingArray[i] = 1000-i;
        }

        QuickSort ob1 = new QuickSort();
        long randomStartTime = System.nanoTime();
        ob1.sort(randomArray, 0, randomArray.length-1);
        long randomEndTime = System.nanoTime();
        System.out.println("Sorted random array : ");
        printArray(randomArray);
        System.out.println("Time taken is : "+ (randomEndTime-randomStartTime));
        System.out.println("No of Recursive calls are : "+ob1.recursiveCall);
        System.out.println();

        QuickSort ob2 = new QuickSort();
        long ascendingStartTime = System.nanoTime();
        ob2.sort(ascendingArray, 0, ascendingArray.length-1);
        long ascendingEndTime = System.nanoTime();
        System.out.println("Sorted ascending array : ");
        printArray(ascendingArray);
        System.out.println("Time taken is : "+ (ascendingEndTime-ascendingStartTime));
        System.out.println("No of Recursive calls are : "+ob2.recursiveCall);
        System.out.println();

        QuickSort ob3 = new QuickSort();
        long descendingStartTime = System.nanoTime();
        ob3.sort(descendingArray, 0, descendingArray.length-1);
        long descendingEndTime = System.nanoTime();
        System.out.println("Sorted descending array : ");
        printArray(descendingArray);
        System.out.println("Time taken is : "+ (descendingEndTime-descendingStartTime));
        System.out.println("No of Recursive calls are : "+ob3.recursiveCall);
        System.out.println();

        QuickSort ob4 = new QuickSort();
        long sameStartTime = System.nanoTime();
        ob4.sort(sameArray, 0, sameArray.length-1);
        long sameEndTime = System.nanoTime();
        System.out.println("same array : ");
        printArray(sameArray);
        System.out.println("Time taken is : "+ (sameEndTime-sameStartTime));
        System.out.println("No of Recursive calls are : "+ob4.recursiveCall);
    }

}