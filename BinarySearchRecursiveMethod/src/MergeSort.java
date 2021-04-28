public class MergeSort {
    public static void main(String[] args) {

    }

    public static void merge(){

    }

    public static void sort(int[] arr,int low,int high){
        if (low != high){
            int mid = (low + high) / 2;
            sort(arr,low,mid);
            sort(arr,mid+1,high);
        }

    }
}
