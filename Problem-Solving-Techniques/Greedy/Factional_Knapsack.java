import java.util.*;
public class Factional_Knapsack {
    public static void main(String[] args) {
        int[] value = {60, 100, 120};
        int[] weight = {10,20,30};
        int w = 50;

        double [][] ratio = new double[value.length][2];

        for(int i = 0 ; i<value.length; i++){
            ratio[i][0] = i;
            ratio[i][1] = value[i]/
            (double) weight[i];
        }

        //ascending order
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        int capacity = w ;
        int val = 0 ;
        for(int i = ratio.length-1 ; i>=0 ; i--){
            int idex = (int) ratio[i][0];
            if(capacity>= weight[idex]){
                val += value[idex];
                capacity -= weight[idex];
            }else{
                val += (ratio[i][1] * capacity);
                capacity = 0 ;
                break;
            }
        }

        System.out.println("final output is : " + val);

    }
    
}
