import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class KnapsackProblem {
    private static double getMaxValue(int[] weight, int[] price, int capacity) {
        Item[] indexPrice = new Item[weight.length];

        for (int i = 0; i < weight.length; i++) {
            indexPrice[i] = new Item(weight[i], price[i], i);
        }
        Arrays.sort(indexPrice, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o2.cost.compareTo(o1.cost);
            }
        });

        double totalValue = 0d;

        for (Item i : indexPrice) {

            int currentWeight = (int)i.wt;
            int currentPrice = (int)i.val;

            if (capacity - currentPrice >= 0) {
                capacity = capacity - currentPrice;
                totalValue += currentPrice;
            }
            else {
                double fraction = ((double)capacity / (double)currentPrice);
                totalValue += (currentPrice * fraction);
                capacity = (int)(capacity - (currentPrice * fraction));
                break;
            }
        }

        return totalValue;
    }


    static class Item {
        Double cost;
        double wt, val, ind;
        public Item(int wt, int val, int ind) {
            this.wt = wt;
            this.val = val;
            this.ind = ind;
            cost = (double) val / (double) wt;
        }
    }

    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public static void main(String[] args) {
        DecimalFormat df2 = new DecimalFormat("#.##");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter no of items : ");
        int noOfItems = scanner.nextInt();

        System.out.print("Enter total capacity : ");
        int capacity = scanner.nextInt();

        int[] arrayValue = new int[noOfItems];
        int[] arrayWeight = new int[noOfItems];
        for (int i = 0; i < noOfItems; i++) {
            arrayWeight[i] = getRandomNumber(1,100);
            arrayValue[i] = getRandomNumber(100,1000);
        }

        System.out.println("Array of Weights : "+Arrays.toString(arrayValue));
        System.out.println("Array of Values : "+Arrays.toString(arrayWeight));

        double maxValue = getMaxValue(arrayWeight, arrayValue, capacity);
        System.out.println("Maximum value we can obtain = "+df2.format(maxValue));
    }
}
