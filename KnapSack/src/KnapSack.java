import java.util.Arrays;

public class KnapSack {
    public static void main(String[] args) {
        

    }

    public int knapSack(int[] price, int[] weights, int bagCapacity){
        float[] priceWeightRatio = new float[price.length];
        float[] maxValue = new float[]{};
        for (int i = 0; i < priceWeightRatio.length; i++){
            priceWeightRatio[i] = Float.valueOf(price[i]/weights[i]);
        }
        int totalWeight = 0;
        float max = priceWeightRatio[0];
        while (totalWeight <= bagCapacity)
        for (int i = 0; i < priceWeightRatio.length-1; i++){
            if (priceWeightRatio[i+1] >= max){
                max = priceWeightRatio[i+1];
                int index = i+1;
            }
        }

    }
}
