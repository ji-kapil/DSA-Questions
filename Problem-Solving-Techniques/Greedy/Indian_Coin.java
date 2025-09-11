import java.util.*;

public class Indian_Coin {
    public static void main(String[] args){
        Integer coin[] = {1,2,5,10,20,50,100,200,500,2000};

        Arrays.sort(coin, Comparator.reverseOrder());

        ArrayList <Integer> coins = new ArrayList<>();

        int count = 0 ; 
        int n = 5 ;
        int amount = n;
        for(int i=0; i<coin.length ; i++){
            if (coin[i] <= amount){
                while(coin[i] <= amount){
                    count++;
                    coins.add(coin[i]);
                    amount = amount - coin[i];
                }
            }
        }

        System.out.println("total coin given is : " + count);

        System.out.print("coin used to make the " + n + " are : " );

        for(int i = 0 ; i<coins.size() ; i++){
            System.out.print(coins.get(i) + "  " );
        }

        System.out.println();
    }
}