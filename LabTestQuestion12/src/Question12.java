import java.util.Scanner;

public class Question12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] arr = new char[]{'A','B','C','D','E','F'};
        System.out.println("Enter index you want to find sibling for? : ");
        int index = scanner.nextInt();
        while (index <= 0 || index >= arr.length){
            if (index < 0 || index >= arr.length){
                System.out.println("Index "+ index + " not present");
            }
            else if (index == 0){
                System.out.println("No siblings");
            }
            System.out.println("Enter index you want to find sibling for? : ");
            index = scanner.nextInt();
        }
        Question12 question12 = new Question12();
        question12.findSibling(index,arr);
    }

    public void findSibling(int index, char[] arr){
        System.out.println(arr);
        int parentIndex = 0;
        if (index / 2 != 0){
            parentIndex = (index - 1) / 2;
        }
        else {
            parentIndex = (index - 2) / 2;
        }
        int leftSibling = (2 * parentIndex) + 1;
        int rightSibling = (2 * parentIndex) + 2;
        if (rightSibling >= arr.length){
            System.out.println("No siblings");
            return;
        }
        System.out.println(arr[leftSibling] + " and " + arr[rightSibling] + " are siblings");
    }
}
