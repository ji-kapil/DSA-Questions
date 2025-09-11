public class Pyramid {
   public static void numberDimand(int n ){
        for (int i = 1; i <=n; i++) {
            int k = i;
            for (int j = 1; j <=n-i; j++) {
                System.out.print("  ");
            }
            for (int j = 1; j <=i; j++) {
                System.out.print(k+ " ");
                k--;
            }
            for (int j = 2; j <=i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }  
    }

}