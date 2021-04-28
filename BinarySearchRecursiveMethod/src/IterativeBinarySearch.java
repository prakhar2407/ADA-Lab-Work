import java.util.Arrays;

public class IterativeBinarySearch {
    static class infoKey{
        Integer index;
        boolean found;

        infoKey(Integer index, boolean found){
            this.index = index;
            this.found = found;
            System.out.println("Key found: "+ found);
            System.out.println("Index is: "+ index);
        }
    }
    public static void main(String[] args) {
        int[] arr = new int[]{3,6,8,12,14,17,25,29,31,36,42,47,53,55};
        IterativeBinarySearch iterativeBinarySearch = new IterativeBinarySearch();
        float startTime = System.nanoTime();
        iterativeBinarySearch.binarySearch(arr,29);
        float endTime = System.nanoTime();
        System.out.println("Time taken is "+(endTime-startTime)+" ns");
    }

    public infoKey binarySearch(int[] arr,int key){
//        Arrays.sort(arr);
        int low = 0;
        int high = arr.length-1;
        int mid = (low + high) / 2;
        while (low != high) {
            if (key == arr[mid]){
                return new infoKey(mid,true);
            }
            else if (key > arr[mid]){
                low = mid + 1;
                mid = (low + high) / 2;
            }
            else {
                high = mid - 1;
                mid = (low + high) / 2;
            }
        }
        return new infoKey(low,true);
    }
}

