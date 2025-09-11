import java.util.*;

public class Chain_Of_Pairs { // activity selection based question

    public static void main(String[] args) {
        int[] a = {5,39,5,27,50};
        int[] b = {24,60,28,40,90};
        int ans = 1;

        int[][] newArray = new int[a.length][3];

        for(int i = 0 ; i <a.length ; i++){
            newArray[i][0] = i ;
            newArray[i] [1] = a[i];
            newArray[i][2] = b[i];
        }

        Arrays.sort(newArray, Comparator.comparingDouble(o -> o[2]));

        int endTime = newArray[0][2];

        for(int i = 1 ; i < a.length ; i++){
            if( newArray[i][1] >= endTime){
                ans++;
                endTime = newArray[i][2];
            }

        }

        System.out.println("answer is : " + ans);


    }
}